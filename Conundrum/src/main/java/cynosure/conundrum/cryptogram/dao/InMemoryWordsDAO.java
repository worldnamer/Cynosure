package cynosure.conundrum.cryptogram.dao;

import java.util.*;

import cynosure.conundrum.cryptogram.interfaces.WordsDAO;

public class InMemoryWordsDAO implements WordsDAO 
{
	Map<String, WordDTO> m_mapWordsByWord;
	Map<String, List<WordDTO>> m_mapWordsBySymbolized;
	
	public InMemoryWordsDAO()
	{
		m_mapWordsByWord = new HashMap<String, WordDTO>();
		
		m_mapWordsBySymbolized = new HashMap<String, List<WordDTO>>();
	}
	
	public void add(WordDTO _dtoWord) 
	{
		List<WordDTO> listWords = m_mapWordsBySymbolized.get(_dtoWord.getSymbolized());
		if (listWords == null)
		{
			listWords = new ArrayList<WordDTO>();
			m_mapWordsBySymbolized.put(_dtoWord.getSymbolized(), listWords);
		}
		
		if (!listWords.contains(_dtoWord))
			listWords.add(_dtoWord);
		
		if (!m_mapWordsByWord.containsKey(_dtoWord.getWord()))
			m_mapWordsByWord.put(_dtoWord.getWord(), _dtoWord);
	}

	public WordDTO findByWord(String _sWord) 
	{
		return m_mapWordsByWord.get(_sWord);
	}

	public List<WordDTO> findBySymbolized(String _sSymbolized) 
	{
		List<WordDTO> listWords = m_mapWordsBySymbolized.get(_sSymbolized);
		
		if (listWords == null)
			return new ArrayList<WordDTO>();
		
		return listWords;
	}

	public List<WordDTO> findBySolved(String _sUnsolved) 
	{
		String sRegEx = _sUnsolved.replace('?', '.');
		List<WordDTO> listMatches = new ArrayList<WordDTO>();
		
		for (String sKey : m_mapWordsByWord.keySet())
		{
			if (sKey.matches(sRegEx))
				listMatches.add(m_mapWordsByWord.get(sKey));
		}
		
		return listMatches;
	}

	public int countBySymbolized(String _sSymbolized)
	{
		List<WordDTO> list = m_mapWordsBySymbolized.get(_sSymbolized);
		if (list == null)
			return 0;

		return list.size();
	}

	public int countBySolved(String _sSolved) 
	{
		String sRegEx = _sSolved.replace('?', '.');
		int nCount = 0;
		
		for (String sKey : m_mapWordsByWord.keySet())
		{
			if (sKey.matches(sRegEx))
				nCount++;
		}
		
		return nCount;
	}

	public int countBySymbolizedAndSolved(String _sSymbolized, String _sSolved) 
	{
		int nCount = 0;
		
		String sRegEx = _sSolved.replace('?', '.');
		List<WordDTO> listWords = findBySymbolized(_sSymbolized);

		for (WordDTO word : listWords)
		{
			if (word.getWord().matches(sRegEx))
				nCount++;
		}
		
		return nCount;
	}

	public List<WordDTO> findBySymbolizedAndSolved(String _sSymbolized, String _sSolved) 
	{
		String sRegEx = _sSolved.replace('?', '.');
		List<WordDTO> listWords = findBySymbolized(_sSymbolized);
		
		List<WordDTO> listMatches = new ArrayList<WordDTO>();

		for (WordDTO word : listWords)
		{
			if (word.getWord().matches(sRegEx))
				listMatches.add(word);
		}
		
		return listMatches;
	}

	public int count() 
	{
		return m_mapWordsByWord.size();
	}
	
	public Map<String, Integer> countOfSymbolized(int _nLength)
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (Map.Entry<String, List<WordDTO>> entry : m_mapWordsBySymbolized.entrySet())
		{
			if (entry.getKey().length() == _nLength)
			{
				map.put(entry.getKey(), entry.getValue().size());
			}
		}
		
		return map;
	}
}
