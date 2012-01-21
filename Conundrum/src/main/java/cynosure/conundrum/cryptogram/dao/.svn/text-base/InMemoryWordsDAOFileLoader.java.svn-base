package cynosure.conundrum.cryptogram.dao;

import java.io.*;

import cynosure.conundrum.cryptogram.interfaces.*;

public class InMemoryWordsDAOFileLoader
{
	private Symbolizer m_sym;

	public void setSymbolizer(Symbolizer _sym) 
	{
		m_sym = _sym;
	}

	public void load(BufferedReader _rdr, WordsDAO _dao) 
	{
		try
		{
			String sLine = null;
			while ((sLine = _rdr.readLine()) != null)
			{
				_dao.add(new WordDTO(sLine, m_sym.symbolize(sLine)));
			}
		}
		catch (IOException ex)
		{
			
		}
	}
}
