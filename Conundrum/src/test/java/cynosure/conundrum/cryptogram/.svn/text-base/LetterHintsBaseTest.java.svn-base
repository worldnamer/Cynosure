package cynosure.conundrum.cryptogram;

import java.util.*;

import org.junit.*;

import cynosure.conundrum.cryptogram.interfaces.LetterHints;
import static org.junit.Assert.*;

public class LetterHintsBaseTest 
{
	private LetterHints m_hints;
	
	@Before
	public void setUp()
	{
		m_hints = new LetterHintsBase();
	}
	
	@Test
	public void constructor()
	{
		assertNotNull(m_hints);
	}
	
	@Test
	public void initialHintsEmpty()
	{
		assertEquals(0, m_hints.size());
	}
	
	@Test
	public void addHint()
	{
		m_hints.put('F', new HashSet<Character>(Arrays.asList('a', 'o', 'u', 'n')));
	}
	
	@Test
	public void sizeAfterAdd()
	{
		Set<Character> setHints = new HashSet<Character>(Arrays.asList('a', 'b')); 
		
		m_hints.put('F', setHints);
		m_hints.put('Q', setHints);
		
		assertEquals(2, m_hints.size());
	}
	
	@Test
	public void getHint()
	{
		Set<Character> setHints = new HashSet<Character>(Arrays.asList('a', 'o', 'u', 'n')); 
		
		m_hints.put('F', setHints);
		
		assertEquals(setHints, m_hints.get('F'));
	}
	
	@Test
	public void getHintMultipleLists()
	{
		Set<Character> setHintsF = new HashSet<Character>(Arrays.asList('a', 'o', 'u', 'n')); 
		Set<Character> setHintsW = new HashSet<Character>(Arrays.asList('n', 'e', 'a', 'i', 'w')); 
		Set<Character> setHintsA = new HashSet<Character>(Arrays.asList('i', 'm', 'n', 'k', 'o')); 
		
		m_hints.put('F', setHintsF);
		m_hints.put('W', setHintsW);
		m_hints.put('A', setHintsA);

		assertEquals(setHintsW, m_hints.get('W'));
	}
	
	@Test
	public void putsThinSet()
	{
		Set<Character> setHintsMin = new HashSet<Character>(Arrays.asList('a', 'n'));
		m_hints.put('F', new HashSet<Character>(Arrays.asList('a', 'q', 'n')));
		m_hints.put('F', new HashSet<Character>(Arrays.asList('a', 'o', 'u', 'n')));
		
		assertEquals(setHintsMin, m_hints.get('F'));
	}
	
	@Test
	public void emptySet()
	{
		Set<Character> setHintsEmpty = new HashSet<Character>();
		m_hints.put('F', new HashSet<Character>(Arrays.asList('a')));
		m_hints.put('F', new HashSet<Character>(Arrays.asList('b')));
		
		assertEquals(setHintsEmpty, m_hints.get('F'));
	}
	
	@Test
	public void isPlausibleWithEmptySetReturnsTrue()
	{
		assertTrue(m_hints.isPlausible("RFAWIGAWR".toCharArray(), "sukiyakis".toCharArray())); 
	}
	
	@Test
	public void isNotPlausibleWithExcludingHints()
	{
		m_hints.put('A', new HashSet<Character>(Arrays.asList('m', 'n')));
		assertFalse(m_hints.isPlausible("RFAWIGAWR".toCharArray(), "sukiyakis".toCharArray())); 
	}
	
	@Test
	public void solvingALetterRemovesFromOtherSets()
	{
		m_hints.put('A', new HashSet<Character>(Arrays.asList('m', 'n')));
		m_hints.put('B', new HashSet<Character>(Arrays.asList('m', 't')));
		m_hints.put('C', new HashSet<Character>(Arrays.asList('m')));
		
		assertEquals(1, m_hints.get('A').size());
		assertTrue(m_hints.get('A').contains('n'));
		assertEquals(1, m_hints.get('B').size());
		assertTrue(m_hints.get('B').contains('t'));
		assertEquals(1, m_hints.get('C').size());
		assertTrue(m_hints.get('C').contains('m'));
	}
	
	@Test
	public void solvingALetterKeepsThatLetterOutOfOtherSets()
	{
		m_hints.put('A', new HashSet<Character>(Arrays.asList('m')));
		m_hints.put('B', new HashSet<Character>(Arrays.asList('m', 't')));
		
		assertEquals(1, m_hints.get('B').size());
		assertTrue(m_hints.get('B').contains('t'));
	}
}
