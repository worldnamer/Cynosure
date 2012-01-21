package cynosure.conundrum.cryptogram;

import org.junit.*;

import cynosure.conundrum.cryptogram.interfaces.Symbolizer;
import static org.junit.Assert.*;

import static org.easymock.EasyMock.*;

public class CryptogramWordTest 
{
	private CryptogramWord m_wordIDGMJ;
	private CryptogramWord m_wordQFHKW;
	
	@Before
	public void setUp()
	{
		m_wordIDGMJ = new CryptogramWord("IDGMJ");
		m_wordQFHKW = new CryptogramWord("QFH'KW");
	}
	
	@Test
	public void constructor()
	{
		CryptogramWord word = new CryptogramWord();
		
		assertNotNull(word);
	}
	
	@Test
	public void alternateConstructor()
	{
		CryptogramWord word = new CryptogramWord("RFAWIGAWR");
		
		assertEquals("RFAWIGAWR", word.toString());
	}
	
	@Test
	public void setWord()
	{
		CryptogramWord word = new CryptogramWord();
		
		word.setWord("RFAWIGAWR");
		
		assertEquals("RFAWIGAWR", word.toString());
	}
	
	@Test
	public void toStringReturnsSameEachTime()
	{
		CryptogramWord word = new CryptogramWord();
		
		word.setWord("RFAWIGAWR");
		
		String sWord = word.toString();
		
		assertSame(sWord, word.toString());
	}
	
	@Test
	public void differentWord()
	{
		assertEquals("IDGMJ", m_wordIDGMJ.toString());
	}
	
	@Test
	public void setSymbolizer()
	{
		Symbolizer sym = createMock(Symbolizer.class);
		replay(sym);
		
		m_wordIDGMJ.setSymbolizer(sym);

		verify(sym);
	}
	
	@Test
	public void symbolizerConstructor()
	{
		Symbolizer sym = createMock(Symbolizer.class);
		replay(sym);

		CryptogramWord word = new CryptogramWord("IDGMJ", sym);
		
		assertEquals("IDGMJ", word.toString());

		verify(sym);
	}
	
	@Test
	public void symbolize()
	{
		Symbolizer sym = createMock(Symbolizer.class);
		expect(sym.symbolize("IDGMJ")).andReturn("01234");
		replay(sym);

		CryptogramWord word = new CryptogramWord("IDGMJ", sym);
		
		assertEquals("01234", word.symbolize());
		
		verify(sym);
	}
	
	@Test
	public void symbolizeTwiceReturnsSameString()
	{
		Symbolizer sym = createMock(Symbolizer.class);
		expect(sym.symbolize("IDGMJ")).andReturn("01234");
		replay(sym);

		CryptogramWord word = new CryptogramWord("IDGMJ", sym);
		
		String sSymbolized = word.symbolize();
		assertSame(sSymbolized, word.symbolize());
		
		verify(sym);
	}
	
	@Test
	public void symbolizeAlt()
	{
		Symbolizer sym = createMock(Symbolizer.class);
		expect(sym.symbolize("IDGMJ")).andReturn("12345");
		replay(sym);

		CryptogramWord word = new CryptogramWord("IDGMJ", sym);
		
		assertEquals("12345", word.symbolize());
		
		verify(sym);
	}
	
	@Test
	public void getSolvedInitiallyReturnsAllQuestionMarks()
	{
		assertEquals("???'??", m_wordQFHKW.getSolved());
	}

	
	@Test
	public void solveALetter()
	{
		m_wordQFHKW.solve('K', 'N');
		
		assertEquals("???'N?", m_wordQFHKW.getSolved());
	}
	
	@Test
	public void unsolveALetter()
	{
		m_wordQFHKW.solve('K', 'N');
		m_wordQFHKW.unsolve('K');
		
		assertEquals("???'??", m_wordQFHKW.getSolved());
	}
	
	@Test
	public void solveTwoLetters()
	{
		m_wordQFHKW.solve('K', 'N');
		m_wordQFHKW.solve('W', 'T');
		
		assertEquals("???'NT", m_wordQFHKW.getSolved());
	}
	
	@Test
	public void solveTwoLettersAndUnsolveTheFirst()
	{
		m_wordQFHKW.solve('K', 'N');
		m_wordQFHKW.solve('W', 'T');
		m_wordQFHKW.unsolve('K');
		
		assertEquals("???'?T", m_wordQFHKW.getSolved());
	}
	
	@Test
	public void isSolvedFalse()
	{
		m_wordQFHKW.solve('K', 'N');
		assertFalse(m_wordQFHKW.isSolved());
	}
	
	@Test
	public void isSolvedTrue()
	{
		m_wordQFHKW.solve('Q', 'a');
		m_wordQFHKW.solve('F', 'v');
		m_wordQFHKW.solve('H', 'e');
		m_wordQFHKW.solve('K', 'r');
		m_wordQFHKW.solve('W', 'y');
		
		assertTrue(m_wordQFHKW.isSolved());
	}
	
	@Test
	public void equalsOnSelfIsTrue()
	{
		assertEquals(m_wordQFHKW, m_wordQFHKW);
	}
	
	@Test
	public void equalsOnIsDataTrue()
	{
		assertEquals(m_wordQFHKW, new CryptogramWord("QFH'KW"));
	}
	
	@Test
	public void equalsNullIsFalse()
	{
		assertFalse(m_wordQFHKW.equals(null));
	}
	
	@Test
	public void equalsOtherWordIsFalse()
	{
		assertFalse(m_wordQFHKW.equals(m_wordIDGMJ));
	}	
	
	@Test
	public void equalsDiffersBySolvedIsFalse()
	{
		m_wordQFHKW.solve('W', 'e');
		assertFalse(m_wordQFHKW.equals(new CryptogramWord("QFH'KW")));
	}
}
