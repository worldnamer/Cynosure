package cynosure.conundrum.cryptogram;

import org.junit.*;

import cynosure.conundrum.cryptogram.dao.WordDTO;
import static org.junit.Assert.*;

public class WordDTOTest 
{
	private WordDTO m_dtoWord;
	
	@Before
	public void setUp()
	{
		m_dtoWord = new WordDTO();
	}
	
	@Test
	public void constructor()
	{
		assertNotNull(m_dtoWord);
	}
	
	@Test
	public void alternateConstructor()
	{
		m_dtoWord = new WordDTO("the", "012");
		
		assertEquals("the", m_dtoWord.getWord());
		assertEquals("012", m_dtoWord.getSymbolized());
	}
	
	@Test
	public void getAndSetWord()
	{
		m_dtoWord.setWord("TEST");
		
		assertEquals("TEST", m_dtoWord.getWord());
	}
	
	@Test
	public void getAndSetSymbolized()
	{
		m_dtoWord.setSymbolized("0120");
		
		assertEquals("0120", m_dtoWord.getSymbolized());
	}
	
	@Test
	public void equality()
	{
		WordDTO dto = new WordDTO("the", "012");
		m_dtoWord.setWord("the");
		m_dtoWord.setSymbolized("012");
		
		assertEquals(dto, m_dtoWord);
	}
	
	@Test
	public void toStringIsCorrectForTest()
	{
		WordDTO dto = new WordDTO("test", "0120");
		
		assertEquals("[test,0120]", dto.toString());
	}
	
	
	@Test
	public void toStringIsCorrectForBogus()
	{
		WordDTO dto = new WordDTO("bogus", "01234");
		
		assertEquals("[bogus,01234]", dto.toString());
	}
}
