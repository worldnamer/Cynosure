package cynosure.conundrum.cryptogram;

import java.io.*;

import org.junit.*;

import cynosure.conundrum.cryptogram.dao.*;
import cynosure.conundrum.cryptogram.interfaces.*;
import static org.junit.Assert.*;

import static org.easymock.EasyMock.*;

public class InMemoryWordsDAOFileLoaderTest 
{
	@Test
	public void constructor()
	{
		InMemoryWordsDAOFileLoader loader = new InMemoryWordsDAOFileLoader();
		
		assertNotNull(loader);
	}
	
	@Test
	public void loadFromReader()
	{
		BufferedReader reader = new BufferedReader(new StringReader("test"));
		
		Symbolizer sym = createMock(Symbolizer.class);
		expect(sym.symbolize("test")).andReturn("0120");
		replay(sym);
		
		InMemoryWordsDAOFileLoader loader = new InMemoryWordsDAOFileLoader();
		loader.setSymbolizer(sym);
		
		WordsDAO dao = createMock(WordsDAO.class);
		dao.add(new WordDTO("test", "0120"));
		replay(dao);		
		
		loader.load(reader, dao);
		
		verify(dao);
		verify(sym);
	}
	
	@Test
	public void loadTwoFromReader()
	{
		BufferedReader reader = new BufferedReader(new StringReader("test\r\nthe"));
		
		Symbolizer sym = createMock(Symbolizer.class);
		expect(sym.symbolize("test")).andReturn("0120");
		expect(sym.symbolize("the")).andReturn("012");
		replay(sym);
		
		InMemoryWordsDAOFileLoader loader = new InMemoryWordsDAOFileLoader();
		loader.setSymbolizer(sym);
		
		WordsDAO dao = createMock(WordsDAO.class);
		dao.add(new WordDTO("test", "0120"));
		dao.add(new WordDTO("the", "012"));
		replay(dao);		
		
		loader.load(reader, dao);
		
		verify(dao);
		verify(sym);
	}
}
