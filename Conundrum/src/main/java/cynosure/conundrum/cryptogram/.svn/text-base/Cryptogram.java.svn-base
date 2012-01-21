package cynosure.conundrum.cryptogram;

import java.util.*;

public class Cryptogram 
{
	private List<CryptogramWord> m_listWords;
	
	@Override
	public String toString()
	{
		String sToString = "";
		for (CryptogramWord word : m_listWords)
			sToString += word + " ";
		
		return sToString.trim();
	}

	public void setWords(List<CryptogramWord> _listWords) 
	{
		m_listWords = _listWords;
	}

	public List<CryptogramWord> getWords() 
	{
		return m_listWords;
	}

	public void solve(char _cFrom, char _cTo) 
	{
		for (CryptogramWord word : m_listWords)
			word.solve(_cFrom, _cTo);
	}

	public String toStringSolved() 
	{
		String sToString = "";
		for (CryptogramWord word : m_listWords)
			sToString += word.getSolved() + " ";
		
		return sToString.trim();
	}
}
