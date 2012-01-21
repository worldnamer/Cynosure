package cynosure.conundrum.cryptogram;

import org.junit.*;
import static org.junit.Assert.*;

public class PhraseParserTest
{
	private PhraseParser m_parser;
	
	// Jack Handy
	String m_sKnownCryptogram = "RFAWIGAWR G IDGMJ QFH DCXW IF ACKOD KGSDI GM CML LWACML QFHK KGSDIR, " +
		                        "WXWM GZ QFH LFM'I JMFT TDCI QFHK KGSDIR CKW, FK TDF IDW BWKRFM GR " +
		                        "QFH'KW ICPJGMS IF.";
	
	@Before
	public void setUp()
	{
		m_parser = new PhraseParser();
	}
	
	@Test
	public void constructor()
	{
		assertNotNull(m_parser);
	}
	
	@Test
	public void oneWordPhraseHasOneWord()
	{
		assertEquals(1, m_parser.parse("PHRASE").length);
	}
	
	@Test
	public void oneWordPhraseHasCorrectWord()
	{
		assertEquals("PHRASE", m_parser.parse("PHRASE")[0]);
	}
	
	@Test
	public void twoWordPhraseHasTwoWords()
	{
		assertEquals(2, m_parser.parse("TWO WORDS").length);
	}
	
	@Test
	public void twoWordPhraseHasCorrectWords()
	{
		String[] aWords = m_parser.parse("TWO WORDS");
		
		assertEquals("TWO", aWords[0]);
		assertEquals("WORDS", aWords[1]);
	}
	
	@Test
	public void punctuatedWordsIncludePunctuation()
	{
		String[] aWords = m_parser.parse("DON'T BREAK");
		
		assertEquals("DON'T", aWords[0]);
	}
	
	@Test
	public void hypensAreNotWordSeparators()
	{
		String[] aWords = m_parser.parse("HYPHEN-WORD");
		
		assertEquals("HYPHENWORD", aWords[0]);
	}
	
	@Test
	public void periodsAreWordSeparators()
	{
		String[] aWords = m_parser.parse("TWO.WORDS.");
		
		assertEquals("TWO", aWords[0]);
		assertEquals("WORDS", aWords[1]);
	}
	
	@Test
	public void commasAreWordSeparators()
	{
		String[] aWords = m_parser.parse("TWO,WORDS");
		
		assertEquals("TWO", aWords[0]);
		assertEquals("WORDS", aWords[1]);
	}
	
	@Test
	public void hyphensWithNoWordAreSeparators()
	{
		String[] aWords = m_parser.parse("TWO -- WORDS");
		
		assertEquals("TWO", aWords[0]);
		assertEquals("WORDS", aWords[1]);
	}
	
	@Test
	public void knownCryptogram()
	{
		String[] aWords = m_parser.parse(m_sKnownCryptogram);
		
		assertEquals(30, aWords.length);
	}
	
	@Test
	public void semicolonsAreWordSeparators()
	{
		String[] aWords = m_parser.parse("TWO;WORDS");
		
		assertEquals("TWO", aWords[0]);
		assertEquals("WORDS", aWords[1]);
	}
}
