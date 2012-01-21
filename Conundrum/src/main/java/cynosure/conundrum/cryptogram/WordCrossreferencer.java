package cynosure.conundrum.cryptogram;

import java.util.*;

import cynosure.conundrum.cryptogram.dao.WordDTO;
import cynosure.conundrum.cryptogram.interfaces.*;

public class WordCrossreferencer 
{
	Symbolizer m_sym;
	WordsDAO m_dao;
	
	public void setWordsDAO(WordsDAO _dao)
	{
		m_dao = _dao;
	}
	
	protected Map<Character, Character> solvePair(
		CryptogramWord _wordLeft, 
		CryptogramWord _wordRight,
		List<WordDTO> _listLeft,
		List<WordDTO> _listRight
	   )
	{
		Map<Character, Character> mapUnsolvedToSolved = new HashMap<Character, Character>();
		
		String sSymbolized = m_sym.symbolize(_wordLeft.toString() + _wordRight.toString());

		System.out.println("Solving pair [" + _wordLeft + "(" + _listLeft.size() + "), " + _wordRight + "(" + _listRight.size() + ")]");
		
		char[] szLeft = null;
		char[] szRight = null;
		
		Iterator<WordDTO> itrLeft = _listLeft.iterator();
		int nNonReplacedLeftLetters = -10000;
		int nNonReplacedRightLetters = -10000;
		while (
			   itrLeft.hasNext()
			   && ((nNonReplacedLeftLetters != 0) || (nNonReplacedRightLetters != 0))
			  )
		{
			WordDTO wordLeft = itrLeft.next();

			Iterator<WordDTO> itrRight = _listRight.iterator();
			while (
				   itrRight.hasNext()
				   && ((nNonReplacedLeftLetters != 0) || (nNonReplacedRightLetters != 0))
				  )
			{
				WordDTO wordRight = itrRight.next();

				String sSymbolizedProduct = m_sym.symbolize(wordLeft.getWord() + wordRight.getWord());
				if (sSymbolizedProduct.equals(sSymbolized))
				{
					if (null == szLeft)
					{
						szLeft = wordLeft.getWord().toCharArray();
						nNonReplacedLeftLetters = szLeft.length;
					}
					if (null == szRight)
					{
						szRight = wordRight.getWord().toCharArray();
						nNonReplacedRightLetters = szRight.length;
					}

					for (int i = 0; i < wordLeft.getWord().length(); i++)
					{
						if (szLeft[i] != wordLeft.getWord().charAt(i))
						{
							if (szLeft[i] != '?')
							{
								nNonReplacedLeftLetters--;
								szLeft[i] = '?';
							}
						}
					}
					
					for (int i = 0; i < wordRight.getWord().length(); i++)
					{
						if (szRight[i] != wordRight.getWord().charAt(i))
						{
							if (szRight[i] != '?')
							{
								nNonReplacedRightLetters--;
								szRight[i] = '?';
							}
						}
					}
				}
			}
		}
		
		if (_listLeft.size() == 0)
		{
			Iterator<WordDTO> itrRight = _listRight.iterator();
			while (itrRight.hasNext())
			{
				WordDTO wordRight = itrRight.next();
				
				if (null == szRight)
				{
					szRight = wordRight.getWord().toCharArray();
					nNonReplacedRightLetters = szRight.length;
				}
				
				for (int i = 0; i < wordRight.getWord().length(); i++)
				{
					if (szRight[i] != wordRight.getWord().charAt(i))
					{
						if (szRight[i] != '?')
						{
							nNonReplacedRightLetters--;
							szRight[i] = '?';
						}
					}
				}
			}
		}
		if (_listRight.size() == 0)
		{
			itrLeft = _listLeft.iterator();
			while (itrLeft.hasNext())
			{
				WordDTO wordLeft = itrLeft.next();
				
				if (null == szLeft)
				{
					szLeft = wordLeft.getWord().toCharArray();
					nNonReplacedLeftLetters = szLeft.length;
				}
				
				for (int i = 0; i < wordLeft.getWord().length(); i++)
				{
					if (szLeft[i] != wordLeft.getWord().charAt(i))
					{
						if (szLeft[i] != '?')
						{
							nNonReplacedLeftLetters--;
							szLeft[i] = '?';
						}
					}
				}
			}
		}

		if (nNonReplacedLeftLetters > 0)
			for (int i = 0; i < _wordLeft.toString().length(); i++)
				if (szLeft[i] != '?')
					mapUnsolvedToSolved.put(_wordLeft.toString().charAt(i), szLeft[i]);					
		if (nNonReplacedRightLetters > 0)
			for (int i = 0; i < _wordRight.toString().length(); i++)
				if (szRight[i] != '?')
					mapUnsolvedToSolved.put(_wordRight.toString().charAt(i), szRight[i]);					
		
		if (mapUnsolvedToSolved.size() != 0)
			System.out.println("solved: " + mapUnsolvedToSolved);
		
		return mapUnsolvedToSolved;
    }

	public Map<Character, Character> solvePair(CryptogramWord _wordLeft, CryptogramWord _wordRight) 
	{
		List<WordDTO> listLeft = m_dao.findBySymbolizedAndSolved(_wordLeft.symbolize(), _wordLeft.getSolved());
		List<WordDTO> listRight = m_dao.findBySymbolizedAndSolved(_wordRight.symbolize(), _wordRight.getSolved());

		return solvePair(_wordLeft, _wordRight, listLeft, listRight);
	}

	public Map<Character, Character> solvePair(CryptogramWord _wordLeft, CryptogramWord _wordRight, LetterHints _hints) 
	{
		List<WordDTO> listLeft = m_dao.findBySymbolizedAndSolved(_wordLeft.symbolize(), _wordLeft.getSolved());
		List<WordDTO> listRight = m_dao.findBySymbolizedAndSolved(_wordRight.symbolize(), _wordRight.getSolved());
		
		Iterator<WordDTO> itrLeft = listLeft.iterator();
		while (itrLeft.hasNext())
		{
			WordDTO word = itrLeft.next();
			if (!_hints.isPlausible(_wordLeft.toString().toCharArray(), word.getWord().toCharArray()))
				itrLeft.remove();
		}
		
		Iterator<WordDTO> itrRight = listRight.iterator();
		while (itrRight.hasNext())
		{
			WordDTO word = itrRight.next();
			if (!_hints.isPlausible(_wordRight.toString().toCharArray(), word.getWord().toCharArray()))
				itrRight.remove();
		}
		buildHints(_wordLeft, _hints);
		buildHints(_wordRight, _hints);

		System.out.println(_hints);
		
		return solvePair(_wordLeft, _wordRight, listLeft, listRight);
	}

	public void setSymbolizer(Symbolizer _sym) 
	{
		m_sym = _sym;
	}

	protected void buildHints(CryptogramWord _word, List<WordDTO> _list, LetterHints hints) 
	{
		if (_list.size() > 0)
		{
			for (int i = 0; i < _word.toString().length(); i++)
			{
				Set<Character> setHints = new HashSet<Character>();

				for (WordDTO word : _list)
					setHints.add(word.getWord().charAt(i));

				hints.put(_word.toString().charAt(i), setHints);
			}
		}
	}
	
	public void buildHints(CryptogramWord _word, LetterHints hints) 
	{
		List<WordDTO> list = m_dao.findBySymbolizedAndSolved(_word.symbolize(), _word.getSolved());

		buildHints(_word, list, hints);
	}
}
