package cynosure.conundrum.cryptogram;

import java.util.*;

import org.junit.*;

import cynosure.conundrum.cryptogram.dao.*;
import static org.junit.Assert.*;

public class InMemoryWordsDAOTest 
{
	private InMemoryWordsDAO m_dao;
	private WordDTO m_dtoThe;
	private WordDTO m_dtoTwo;
	private WordDTO m_dtoAnd;
	private WordDTO m_dtoTee;
	private WordDTO m_dtoBee;
	
	@Before
	public void setUp()
	{
		m_dao = new InMemoryWordsDAO();
		m_dtoThe = new WordDTO("the", "012");
		m_dtoTwo = new WordDTO("two", "012");
		m_dtoAnd = new WordDTO("and", "012");
		m_dtoTee = new WordDTO("tee", "011");
		m_dtoBee = new WordDTO("bee", "011");
	}
	
	@Test
	public void countInitiallyZero()
	{
		assertEquals(0, m_dao.count());
	}
	
	@Test
	public void countCorrect()
	{
		m_dao.add(m_dtoThe);
		m_dao.add(m_dtoTwo);
		m_dao.add(m_dtoAnd);
		assertEquals(3, m_dao.count());
	}
	
	@Test
	public void constructor()
	{
		assertNotNull(m_dao);
	}
	
	@Test
	public void findTheReturnsAWord()
	{
		m_dao.add(m_dtoThe);
		WordDTO dto = m_dao.findByWord("the");
		
		assertNotNull(dto);
	}
	
	@Test
	public void findTheReturnsTheRightWord()
	{
		m_dao.add(m_dtoThe);
		WordDTO dto = m_dao.findByWord("the");
		
		assertEquals(m_dtoThe, dto);
	}
	
	@Test
	public void findAnd()
	{
		m_dao.add(m_dtoAnd);
		assertNotNull(m_dtoAnd);
	}

	@Test
	public void findAndReturnsTheRightWord()
	{
		m_dao.add(m_dtoAnd);
		WordDTO dto = m_dao.findByWord("and");
		
		assertEquals(m_dtoAnd, dto);
	}
	
	@Test
	public void findNonWordReturnsNull()
	{
		WordDTO dto = m_dao.findByWord("ZZZ");
		
		assertNull(dto);
	}
	
	@Test
	public void findBySymbolizedReturnsAList()
	{
		List<WordDTO> listDTOs = m_dao.findBySymbolized("012");
		
		assertNotNull(listDTOs);
	}
	
	@Test
	public void findBySymbolizedReturnsAListWithTwoEntries()
	{
		m_dao.add(m_dtoThe);
		m_dao.add(m_dtoAnd);
		List<WordDTO> listDTOs = m_dao.findBySymbolized("012");
		
		assertEquals(2, listDTOs.size());
	}
	
	@Test
	public void findBySymbolizedReturnsAListWithCorrectEntries()
	{
		m_dao.add(m_dtoThe);
		m_dao.add(m_dtoAnd);
		List<WordDTO> listDTOs = m_dao.findBySymbolized("012");
		
		assertTrue(listDTOs.contains(m_dtoThe));
		assertTrue(listDTOs.contains(m_dtoAnd));
	}
	
	@Test
	public void findByMissingSymbolizeReturnsEmptyList()
	{
		List<WordDTO> listDTOs = m_dao.findBySymbolized("333");
		
		assertEquals(0, listDTOs.size());
	}
	
	@Test
	public void findNoneByUnsolvedYieldsEmptyList()
	{
		List<WordDTO> listDTOs = m_dao.findBySolved("?he");
		
		assertEquals(0, listDTOs.size());
	}
	
	@Test
	public void findTheByUnsolvedYieldsResult()
	{
		m_dao.add(m_dtoThe);
		
		List<WordDTO> listDTOs = m_dao.findBySolved("?he");
		
		assertEquals(1, listDTOs.size());
	}
	
	@Test
	public void findTheByUnsolvedYieldsOneResult()
	{
		m_dao.add(m_dtoThe);
		m_dao.add(m_dtoAnd);
		
		List<WordDTO> listDTOs = m_dao.findBySolved("?he");
		
		assertEquals(1, listDTOs.size());
	}

	@Test
	public void findTheByUnsolvedYieldsTheResult()
	{
		m_dao.add(m_dtoThe);
		m_dao.add(m_dtoAnd);
		
		List<WordDTO> listDTOs = m_dao.findBySolved("?he");
		
		assertEquals(m_dtoThe, listDTOs.get(0));
	}
	
	@Test
	public void findAndByMiddleMatch()
	{
		m_dao.add(m_dtoAnd);
		
		List<WordDTO> listDTOs = m_dao.findBySolved("a?d");
		
		assertEquals(m_dtoAnd, listDTOs.get(0));
	}
	
	@Test
	public void findMultipleMatch()
	{
		m_dao.add(m_dtoThe);
		m_dao.add(m_dtoTwo);
		
		List<WordDTO> listDTOs = m_dao.findBySolved("t??");
		
		assertTrue(listDTOs.contains(m_dtoThe));
		assertTrue(listDTOs.contains(m_dtoTwo));
	}
	
	@Test
	public void countSolved()
	{
		m_dao.add(m_dtoAnd);
		
		assertEquals(1, m_dao.countBySolved("a?d"));
	}
	
	@Test
	public void countSolvedNoHit()
	{
		assertEquals(0, m_dao.countBySolved("a?d"));
	}
	
	@Test
	public void countSymbolized()
	{
		m_dao.add(m_dtoThe);
		m_dao.add(m_dtoTwo);
		
		assertEquals(2, m_dao.countBySymbolized("012"));
	}
	
	@Test
	public void countSymbolizedNoHit()
	{
		assertEquals(0, m_dao.countBySymbolized("012"));
	}

	@Test
	public void countWithMultipleSymbolizes()
	{
		m_dao.add(m_dtoAnd);
		m_dao.add(m_dtoThe);
		m_dao.add(m_dtoTwo);
		m_dao.add(m_dtoTee);
		
		assertEquals(3, m_dao.countBySymbolized("012"));
	}
	
	@Test
	public void countWithSymAndPartialMatchOne()
	{
		m_dao.add(m_dtoAnd);
		m_dao.add(m_dtoThe);
		m_dao.add(m_dtoTwo);
		m_dao.add(m_dtoTee);
		
		assertEquals(1, m_dao.countBySymbolizedAndSolved("012", "??e"));
	}
	
	@Test
	public void countWithSymAndPartialMatchTwo()
	{
		m_dao.add(m_dtoAnd);
		m_dao.add(m_dtoThe);
		m_dao.add(m_dtoTwo);
		m_dao.add(m_dtoTee);
		m_dao.add(m_dtoBee);
		
		assertEquals(2, m_dao.countBySymbolizedAndSolved("011", "??e"));
	}
	
	@Test
	public void findWithSymAndPartialMatchOneCountIsCorrect()
	{
		m_dao.add(m_dtoAnd);
		m_dao.add(m_dtoThe);
		m_dao.add(m_dtoTwo);
		m_dao.add(m_dtoTee);
		
		assertEquals(1, m_dao.findBySymbolizedAndSolved("012", "??e").size());
	}
	
	@Test
	public void findWithSymAndPartialMatchOneCountHasCorrectWord()
	{
		m_dao.add(m_dtoAnd);
		m_dao.add(m_dtoThe);
		m_dao.add(m_dtoTwo);
		m_dao.add(m_dtoTee);
		
		assertTrue(m_dao.findBySymbolizedAndSolved("012", "??e").contains(m_dtoThe));
	}
	
	@Test
	public void findWithSymAndPartialMatchTwoCountIsCorrect()
	{
		m_dao.add(m_dtoAnd);
		m_dao.add(m_dtoThe);
		m_dao.add(m_dtoTwo);
		m_dao.add(m_dtoTee);
		m_dao.add(m_dtoBee);
		
		assertEquals(2, m_dao.findBySymbolizedAndSolved("011", "??e").size());
	}
	
	@Test
	public void findWithSymAndPartialMatchTwoCountHasCorrectWords()
	{
		m_dao.add(m_dtoAnd);
		m_dao.add(m_dtoThe);
		m_dao.add(m_dtoTwo);
		m_dao.add(m_dtoTee);
		m_dao.add(m_dtoBee);
		
		List<WordDTO> listWords = m_dao.findBySymbolizedAndSolved("011", "??e"); 
		
		assertTrue(listWords.contains(m_dtoTee));
		assertTrue(listWords.contains(m_dtoBee));
	}

	@Test
	public void countSymbolizedWithOnlyThe()
	{
		m_dao.add(m_dtoThe);
		Map<String, Integer> map = m_dao.countOfSymbolized(3);
		
		assertEquals((Integer)1, map.get("012"));
	}
	
	@Test
	public void countSymbolizedWithTheAndBee()
	{
		m_dao.add(m_dtoThe);
		m_dao.add(m_dtoAnd);
		m_dao.add(m_dtoBee);
		Map<String, Integer> map = m_dao.countOfSymbolized(3);
		
		assertEquals((Integer)2, map.get("012"));
		assertEquals((Integer)1, map.get("011"));
	}
	
}
