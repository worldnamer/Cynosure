package cynosure.conundrum.cryptogram;

import java.util.*;

import cynosure.conundrum.cryptogram.interfaces.LetterHints;

public class LetterHintsBase implements LetterHints 
{
	private Map<Character, Set<Character>> m_mapHints;
	
	public LetterHintsBase()
	{
		m_mapHints = new HashMap<Character, Set<Character>>();
	}
	
	/* (non-Javadoc)
	 * @see cynosure.conundrum.cryptogram.LetterHints#size()
	 */
	public int size()
	{
		return m_mapHints.size();
	}

	public void put(char _cKey, Set<Character> _setHints) 
	{
		Set<Character> setHints = m_mapHints.get(_cKey);
		
		if (null == setHints)
		{
			m_mapHints.put(_cKey, _setHints);
			setHints = _setHints;
		}
		else
		{
			Iterator<Character> itr = setHints.iterator();
			while (itr.hasNext())
			{
				if (!_setHints.contains(itr.next()))
					itr.remove();
			}
		}

		if (_setHints.size() == 1)
		{
			char cToRemove = _setHints.toArray((new Character[0]))[0];
			for (Set<Character> setToRemove : m_mapHints.values())
			{
				if (setToRemove != setHints)
				{
					setToRemove.remove(cToRemove);
				}
			}
		}
		
		for (Set<Character> setToCheck : m_mapHints.values())
		{
			if ((1 == setToCheck.size()) && setToCheck != setHints)
				setHints.remove(setToCheck.toArray((new Character[0]))[0]);
		}
	}

	public Set<Character> get(char _cKey) 
	{
		return m_mapHints.get(_cKey);
	}

	public boolean isPlausible(char[] _szCipher, char[] _szWord)
	{
		boolean bIsPlausible = true;
		for (int i = 0; (i < _szCipher.length) && (bIsPlausible); i++)
		{
			Set<Character> setHints = m_mapHints.get(_szCipher[i]);
			if (setHints != null && !setHints.contains(_szWord[i]))
				bIsPlausible = false;
		}
		
		return bIsPlausible;
	}
	
	@Override
	public String toString()
	{
		return m_mapHints.toString();
	}
}
