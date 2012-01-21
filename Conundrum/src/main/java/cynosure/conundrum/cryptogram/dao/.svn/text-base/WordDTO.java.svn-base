package cynosure.conundrum.cryptogram.dao;

public class WordDTO 
{
	private String m_sWord;
	private String m_sSymbolized;

	public WordDTO()
	{
		
	}
	
	public WordDTO(String _sWord, String _sSymbolized) 
	{
		m_sWord = _sWord;
		m_sSymbolized = _sSymbolized;
	}

	public String getWord() 
	{
		return m_sWord;
	}

	public void setWord(String _sWord) 
	{
		m_sWord = _sWord;
	}

	public String getSymbolized() 
	{
		return m_sSymbolized;
	}

	public void setSymbolized(String _sSymbolized) 
	{
		m_sSymbolized = _sSymbolized;
	}
	
	@Override
	public boolean equals(Object _oToCompareTo) 
	{
		if (_oToCompareTo == null)
			return false;
		
		if (_oToCompareTo == this)
			return true;
		
		if (_oToCompareTo instanceof WordDTO)
		{
			WordDTO dto = (WordDTO)_oToCompareTo;
			if (
				(m_sWord.equals(dto.m_sWord)) &&
				(m_sSymbolized.equals(dto.m_sSymbolized))
			   )
			   return true;
		}
		
		return false;
	}
	
	@Override
	public String toString()
	{
		return "[" + m_sWord + "," + m_sSymbolized + "]";
	}
}
