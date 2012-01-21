package cynosure.conundrum.cryptogram;

import java.util.Arrays;

import cynosure.conundrum.cryptogram.interfaces.Symbolizer;

public class CryptogramWord 
{
	private int m_nToSolve;
	private char[] m_szCiphered;
	private char[] m_szSolved;
	
	private Symbolizer m_sym;
	
	private String m_sCiphered;
	private String m_sSymbolized;
	
	@Override
	public String toString() 
	{
		return m_sCiphered;
	}
	
	@Override
	public boolean equals(Object _o) 
	{
		if (_o == this)
			return true;
		else if (_o instanceof CryptogramWord)
		{
			CryptogramWord word = (CryptogramWord)_o;
			
			// compare ciphered
			if (
				Arrays.equals(m_szCiphered, word.m_szCiphered) &&
				Arrays.equals(m_szSolved, word.m_szSolved)
			   )
				return true;
		}
		
		return false;
	}

	public CryptogramWord()
	{
		
	}
	
	public CryptogramWord(String _sCiphered) 
	{
		setWord(_sCiphered);
	}

	public CryptogramWord(String _sCiphered, Symbolizer _sym) 
	{
		setWord(_sCiphered);
		m_sym = _sym;
	}

	public void setWord(String _sCiphered) 
	{
		m_sCiphered = _sCiphered;
		
		m_szCiphered = new char[_sCiphered.length()];
		_sCiphered.getChars(0, m_szCiphered.length, m_szCiphered, 0);
		
		String sSolved = _sCiphered.replaceAll("[a-zA-Z]", "?");
		m_szSolved = new char[sSolved.length()];
		sSolved.getChars(0, m_szSolved.length, m_szSolved, 0);
		
		for (int i = 0; i < m_szSolved.length; i++)
			if (m_szSolved[i] == '?')
				m_nToSolve++;
	}

	public void setSymbolizer(Symbolizer _sym) 
	{
		m_sym = _sym;
	}

	public String symbolize() 
	{
		if (m_sSymbolized == null)
			m_sSymbolized = m_sym.symbolize(new String(m_szCiphered)); 
		
		return m_sSymbolized;
	}

	public String getSolved() 
	{
		return new String(m_szSolved);
	}

	public void solve(char _cCiphered, char _cPlain) 
	{
		for (int i = 0; i < m_szCiphered.length; i++)
		{
			if (m_szCiphered[i] == _cCiphered)
			{
				if (
					(_cCiphered == '?') &&
					(m_szSolved[i] != '?')
				   )
					m_nToSolve++;
				else if (
						 (_cCiphered != '?') &&
						 (m_szSolved[i] == '?')
						)
					m_nToSolve--;
					
				m_szSolved[i] = _cPlain;
				
			}
		}
	}
	
	public void unsolve(char _cCipherLetterToReset)
	{
		solve(_cCipherLetterToReset, '?');
	}

	public boolean isSolved() 
	{
		return m_nToSolve == 0;
	}
}
