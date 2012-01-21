package cynosure.conundrum.cryptogram;

import java.util.*;

import cynosure.conundrum.cryptogram.dao.WordDTO;
import cynosure.conundrum.cryptogram.interfaces.*;

import org.junit.*;
import static org.junit.Assert.*;

import static org.easymock.EasyMock.*;

public class WordCrossreferencerTest 
{
	@Test
	public void constructor()
	{
		WordCrossreferencer cfr = new WordCrossreferencer();
		
		assertNotNull(cfr);
	}
	
	@Test
	public void setWordsDAO()
	{
		WordCrossreferencer cfr = new WordCrossreferencer();
		
		WordsDAO dao = createMock(WordsDAO.class);
		replay(dao);
		
		cfr.setWordsDAO(dao);

		verify(dao);
	}
	
	@Test
	public void setSymbolizer()
	{
		WordCrossreferencer cfr = new WordCrossreferencer();
		
		Symbolizer sym = createMock(Symbolizer.class);
		replay(sym);
		
		cfr.setSymbolizer(sym);
		
		verify(sym);
	}
	
	@Test
	public void matchBoth()
	{
		String sCipherLeft = "RFAWIGAWR";
		String sSymbolizedLeft = "012345230";
		String sCipherRight = "LWACML";
		String sSymbolizedRight = "012340";
		String sSymbolized = "012340230532675";
		String sWordLeft = "sometimes";
		String sWordRight = "demand";

		Map<Character, Character> mapSolution = new HashMap<Character, Character>();
		mapSolution.put('R', 's');
		mapSolution.put('F', 'o');
		mapSolution.put('A', 'm');
		mapSolution.put('W', 'e');
		mapSolution.put('I', 't');
		mapSolution.put('G', 'i');
		mapSolution.put('L', 'd');
		mapSolution.put('C', 'a');
		mapSolution.put('M', 'n');
		
		WordCrossreferencer cfr = new WordCrossreferencer();

		Symbolizer sym = createMock(Symbolizer.class);
		expect(sym.symbolize(sCipherLeft)).andReturn(sSymbolizedLeft);
		expect(sym.symbolize(sCipherRight)).andReturn(sSymbolizedRight);
		expect(sym.symbolize(sCipherLeft + sCipherRight)).andReturn(sSymbolized);
		expect(sym.symbolize(sWordLeft + sWordRight)).andReturn(sSymbolized);
		replay(sym);
		
		CryptogramWord wordLeft = new CryptogramWord(sCipherLeft, sym);
		CryptogramWord wordRight = new CryptogramWord(sCipherRight, sym);
		
		WordsDAO dao = createMock(WordsDAO.class);
		List<WordDTO> listPossiblesLeft = new ArrayList<WordDTO>();
		listPossiblesLeft.add(new WordDTO(sWordLeft, sSymbolizedLeft));
		List<WordDTO> listPossiblesRight = new ArrayList<WordDTO>();
		listPossiblesRight.add(new WordDTO(sWordRight, sSymbolizedRight));
		expect(dao.findBySymbolizedAndSolved(sSymbolizedLeft, wordLeft.getSolved())).andReturn(listPossiblesLeft);
		expect(dao.findBySymbolizedAndSolved(sSymbolizedRight, wordRight.getSolved())).andReturn(listPossiblesRight);
		replay(dao);
		
		cfr.setWordsDAO(dao);
		cfr.setSymbolizer(sym);
		
		Map<Character, Character> mapSolved = cfr.solvePair(wordLeft, wordRight);
		assertEquals(mapSolution, mapSolved);
		
		verify(dao);
		verify(sym);
	}

	@Test
	public void matchLeft()
	{
		String sCipherLeft = "RFAWIGAWR";
		String sSymbolizedLeft = "012345230";
		String sCipherRight = "LWACML";
		String sSymbolizedRight = "012340";
		String sSymbolized = "012340230532675";
		String sWordLeft = "sometimes";
		String sWordRight1 = "demand";
		String sWordRight2 = "tdolst";

		Map<Character, Character> mapSolution = new HashMap<Character, Character>();
		mapSolution.put('R', 's');
		mapSolution.put('F', 'o');
		mapSolution.put('A', 'm');
		mapSolution.put('W', 'e');
		mapSolution.put('I', 't');
		mapSolution.put('G', 'i');
		
		WordCrossreferencer cfr = new WordCrossreferencer();

		Symbolizer sym = createMock(Symbolizer.class);
		expect(sym.symbolize(sCipherLeft)).andReturn(sSymbolizedLeft);
		expect(sym.symbolize(sCipherRight)).andReturn(sSymbolizedRight);
		expect(sym.symbolize(sCipherLeft + sCipherRight)).andReturn(sSymbolized);
		expect(sym.symbolize(sWordLeft + sWordRight1)).andReturn(sSymbolized);
		expect(sym.symbolize(sWordLeft + sWordRight2)).andReturn(sSymbolized);
		replay(sym);
		
		CryptogramWord wordLeft = new CryptogramWord(sCipherLeft, sym);
		CryptogramWord wordRight = new CryptogramWord(sCipherRight, sym);
		
		WordsDAO dao = createMock(WordsDAO.class);
		List<WordDTO> listPossiblesLeft = new ArrayList<WordDTO>();
		listPossiblesLeft.add(new WordDTO(sWordLeft, sSymbolizedLeft));
		List<WordDTO> listPossiblesRight = new ArrayList<WordDTO>();
		listPossiblesRight.add(new WordDTO(sWordRight1, sSymbolizedRight));
		listPossiblesRight.add(new WordDTO(sWordRight2, sSymbolizedRight));
		expect(dao.findBySymbolizedAndSolved(sSymbolizedLeft, wordLeft.getSolved())).andReturn(listPossiblesLeft);
		expect(dao.findBySymbolizedAndSolved(sSymbolizedRight, wordRight.getSolved())).andReturn(listPossiblesRight);
		replay(dao);
		
		cfr.setWordsDAO(dao);
		cfr.setSymbolizer(sym);
		
		Map<Character, Character> mapSolved = cfr.solvePair(wordLeft, wordRight);
		assertEquals(mapSolution, mapSolved);
		
		verify(dao);
		verify(sym);
	}

	@Test
	public void matchRight()
	{
		String sCipherLeft = "RFAWIGAWR";
		String sSymbolizedLeft = "012345230";
		String sCipherRight = "LWACML";
		String sSymbolizedRight = "012340";
		String sSymbolized = "012340230532675";
		String sWordLeft1 = "sometimes";
		String sWordLeft2 = "qpodzuodq";
		String sWordRight = "demand";

		Map<Character, Character> mapSolution = new HashMap<Character, Character>();
		mapSolution.put('L', 'd');
		mapSolution.put('W', 'e');
		mapSolution.put('A', 'm');
		mapSolution.put('C', 'a');
		mapSolution.put('M', 'n');
		
		WordCrossreferencer cfr = new WordCrossreferencer();

		Symbolizer sym = createMock(Symbolizer.class);
		expect(sym.symbolize(sCipherLeft)).andReturn(sSymbolizedLeft);
		expect(sym.symbolize(sCipherRight)).andReturn(sSymbolizedRight);
		expect(sym.symbolize(sCipherLeft + sCipherRight)).andReturn(sSymbolized);
		expect(sym.symbolize(sWordLeft1 + sWordRight)).andReturn(sSymbolized);
		expect(sym.symbolize(sWordLeft2 + sWordRight)).andReturn(sSymbolized);
		replay(sym);
		
		CryptogramWord wordLeft = new CryptogramWord(sCipherLeft, sym);
		CryptogramWord wordRight = new CryptogramWord(sCipherRight, sym);
		
		WordsDAO dao = createMock(WordsDAO.class);
		List<WordDTO> listPossiblesLeft = new ArrayList<WordDTO>();
		listPossiblesLeft.add(new WordDTO(sWordLeft1, sSymbolizedLeft));
		listPossiblesLeft.add(new WordDTO(sWordLeft2, sSymbolizedLeft));
		List<WordDTO> listPossiblesRight = new ArrayList<WordDTO>();
		listPossiblesRight.add(new WordDTO(sWordRight, sSymbolizedRight));
		expect(dao.findBySymbolizedAndSolved(sSymbolizedLeft, wordLeft.getSolved())).andReturn(listPossiblesLeft);
		expect(dao.findBySymbolizedAndSolved(sSymbolizedRight, wordRight.getSolved())).andReturn(listPossiblesRight);
		replay(dao);
		
		cfr.setWordsDAO(dao);
		cfr.setSymbolizer(sym);
		
		Map<Character, Character> mapSolved = cfr.solvePair(wordLeft, wordRight);
		assertEquals(mapSolution, mapSolved);
		
		verify(dao);
		verify(sym);
	}

	@Test
	public void stopsEarly()
	{
		String sCipherLeft = "RFAWIGAWR";
		String sSymbolizedLeft = "012345230";
		String sCipherRight = "LWACML";
		String sSymbolizedRight = "012340";
		String sSymbolized = "012340230532675";
		String sWordLeft1 = "sometimes";
		String sWordLeft2 = "qpodzuodq";
		String sWordRight1 = "demand";
		String sWordRight2 = "tdolst";

		WordCrossreferencer cfr = new WordCrossreferencer();

		Symbolizer sym = createMock(Symbolizer.class);
		expect(sym.symbolize(sCipherLeft)).andReturn(sSymbolizedLeft);
		expect(sym.symbolize(sCipherRight)).andReturn(sSymbolizedRight);
		expect(sym.symbolize(sCipherLeft + sCipherRight)).andReturn(sSymbolized);
		expect(sym.symbolize(sWordLeft1 + sWordRight1)).andReturn(sSymbolized);
		expect(sym.symbolize(sWordLeft1 + sWordRight2)).andReturn(sSymbolized);
		expect(sym.symbolize(sWordLeft2 + sWordRight1)).andReturn(sSymbolized);
//
		//expect(sym.symbolize(sWordLeft2 + sWordRight2)).andReturn(sSymbolized);
		replay(sym);
		
		CryptogramWord wordLeft = new CryptogramWord(sCipherLeft, sym);
		CryptogramWord wordRight = new CryptogramWord(sCipherRight, sym);
		
		WordsDAO dao = createMock(WordsDAO.class);
		List<WordDTO> listPossiblesLeft = new ArrayList<WordDTO>();
		listPossiblesLeft.add(new WordDTO(sWordLeft1, sSymbolizedLeft));
		listPossiblesLeft.add(new WordDTO(sWordLeft2, sSymbolizedLeft));
		List<WordDTO> listPossiblesRight = new ArrayList<WordDTO>();
		listPossiblesRight.add(new WordDTO(sWordRight1, sSymbolizedRight));
		listPossiblesRight.add(new WordDTO(sWordRight2, sSymbolizedRight));
		expect(dao.findBySymbolizedAndSolved(sSymbolizedLeft, wordLeft.getSolved())).andReturn(listPossiblesLeft);
		expect(dao.findBySymbolizedAndSolved(sSymbolizedRight, wordRight.getSolved())).andReturn(listPossiblesRight);
		replay(dao);
		
		cfr.setWordsDAO(dao);
		cfr.setSymbolizer(sym);
		
		Map<Character, Character> mapSolved = cfr.solvePair(wordLeft, wordRight);
		assertEquals(0, mapSolved.size());
		
		verify(dao);
		verify(sym);
	}

	@Test
	public void findsMustLetters()
	{
		String sCipherLeft = "RFAWIGAWR";
		String sSymbolizedLeft = "012345230";
		String sCipherRight = "LWACML";
		String sSymbolizedRight = "012340";
		String sSymbolized = "012340230532675";
		String sWordLeft1 = "sometimes";
		String sWordLeft2 = "qpoezuoeq";
		String sWordRight1 = "demand";
		String sWordRight2 = "teolst";

		WordCrossreferencer cfr = new WordCrossreferencer();

		Symbolizer sym = createMock(Symbolizer.class);
		expect(sym.symbolize(sCipherLeft)).andReturn(sSymbolizedLeft);
		expect(sym.symbolize(sCipherRight)).andReturn(sSymbolizedRight);
		expect(sym.symbolize(sCipherLeft + sCipherRight)).andReturn(sSymbolized);
		expect(sym.symbolize(sWordLeft1 + sWordRight1)).andReturn(sSymbolized);
		expect(sym.symbolize(sWordLeft1 + sWordRight2)).andReturn(sSymbolized);
		expect(sym.symbolize(sWordLeft2 + sWordRight1)).andReturn(sSymbolized);
		expect(sym.symbolize(sWordLeft2 + sWordRight2)).andReturn(sSymbolized);
		replay(sym);
		
		CryptogramWord wordLeft = new CryptogramWord(sCipherLeft, sym);
		CryptogramWord wordRight = new CryptogramWord(sCipherRight, sym);
		
		WordsDAO dao = createMock(WordsDAO.class);
		List<WordDTO> listPossiblesLeft = new ArrayList<WordDTO>();
		listPossiblesLeft.add(new WordDTO(sWordLeft1, sSymbolizedLeft));
		listPossiblesLeft.add(new WordDTO(sWordLeft2, sSymbolizedLeft));
		List<WordDTO> listPossiblesRight = new ArrayList<WordDTO>();
		listPossiblesRight.add(new WordDTO(sWordRight1, sSymbolizedRight));
		listPossiblesRight.add(new WordDTO(sWordRight2, sSymbolizedRight));
		expect(dao.findBySymbolizedAndSolved(sSymbolizedLeft, wordLeft.getSolved())).andReturn(listPossiblesLeft);
		expect(dao.findBySymbolizedAndSolved(sSymbolizedRight, wordRight.getSolved())).andReturn(listPossiblesRight);
		replay(dao);
		
		cfr.setWordsDAO(dao);
		cfr.setSymbolizer(sym);
		
		Map<Character, Character> mapSolved = cfr.solvePair(wordLeft, wordRight);
		assertEquals(1, mapSolved.size());
		assertEquals((Character)'e', mapSolved.get('W'));
		
		verify(dao);
		verify(sym);
	}

	@Test
	public void noListBoth()
	{
		String sSymbolizedLeft = "012345230";
		String sSymbolizedRight = "012340";
		String sCipherLeft = "RFAWIGAWR";
		String sCipherRight = "LWACML";
		String sSymbolized = "012340230532675";

		Symbolizer sym = createMock(Symbolizer.class);
		expect(sym.symbolize(sCipherLeft)).andReturn(sSymbolizedLeft);
		expect(sym.symbolize(sCipherRight)).andReturn(sSymbolizedRight);
		expect(sym.symbolize(sCipherLeft + sCipherRight)).andReturn(sSymbolized);
		replay(sym);
		
		CryptogramWord wordLeft = new CryptogramWord(sCipherLeft, sym);
		CryptogramWord wordRight = new CryptogramWord(sCipherRight, sym);

		WordCrossreferencer cfr = new WordCrossreferencer();

		WordsDAO dao = createMock(WordsDAO.class);
		List<WordDTO> listPossiblesLeft = new ArrayList<WordDTO>();
		List<WordDTO> listPossiblesRight = new ArrayList<WordDTO>();
		expect(dao.findBySymbolizedAndSolved(sSymbolizedLeft, wordLeft.getSolved())).andReturn(listPossiblesLeft);
		expect(dao.findBySymbolizedAndSolved(sSymbolizedRight, wordRight.getSolved())).andReturn(listPossiblesRight);
		replay(dao);
		
		cfr.setWordsDAO(dao);
		cfr.setSymbolizer(sym);
		
		Map<Character, Character> mapSolved = cfr.solvePair(wordLeft, wordRight);
		assertEquals(0, mapSolved.size());
		
		verify(dao);
		verify(sym);
	}
	
	@Test
	public void rightListLongAndSolves()
	{
		WordCrossreferencer cfr = new WordCrossreferencer();

		String sSymbolizedLeft = "012345230";
		String sSymbolizedRight = "012340";
		String sSymbolized = "012345230532675";
		String sCipherLeft = "RFAWIGAWR";
		String sCipherRight = "LWACML";
		String sWordLeft1 = "sometimes";
		String sWordLeft2 = "012345230";
		String sWordRight1 = "demand";
		String sWordRight2 = "532675";
		String sSymbolizedLeft1Right1 = "012340230532675";
		String sSymbolizedLeft1Right2 = "0123452306789A6";
		String sSymbolizedLeft2Right1 = "0123452306789A6";
		String sSymbolizedLeft2Right2 = "012345230532675";
		
		Symbolizer sym = createMock(Symbolizer.class);
		expect(sym.symbolize(sCipherLeft + sCipherRight)).andReturn(sSymbolized);
		expect(sym.symbolize(sCipherLeft)).andReturn(sSymbolizedLeft);
		expect(sym.symbolize(sCipherRight)).andReturn(sSymbolizedRight);
		expect(sym.symbolize(sWordLeft1 + sWordRight1)).andReturn(sSymbolizedLeft1Right1);
		expect(sym.symbolize(sWordLeft1 + sWordRight2)).andReturn(sSymbolizedLeft1Right2);
		expect(sym.symbolize(sWordLeft2 + sWordRight1)).andReturn(sSymbolizedLeft2Right1);
		expect(sym.symbolize(sWordLeft2 + sWordRight2)).andReturn(sSymbolizedLeft2Right2);
		replay(sym);
		
		CryptogramWord wordLeft = new CryptogramWord(sCipherLeft, sym);
		CryptogramWord wordRight = new CryptogramWord(sCipherRight, sym);
		
		WordsDAO dao = createMock(WordsDAO.class);
		List<WordDTO> listPossiblesLeft = new ArrayList<WordDTO>();
		listPossiblesLeft.add(new WordDTO(sWordLeft1, sSymbolizedLeft));
		listPossiblesLeft.add(new WordDTO(sWordLeft2, sSymbolizedLeft));
		List<WordDTO> listPossiblesRight = new ArrayList<WordDTO>();
		listPossiblesRight.add(new WordDTO(sWordRight1, sSymbolizedLeft));
		listPossiblesRight.add(new WordDTO(sWordRight2, sSymbolizedLeft));
		expect(dao.findBySymbolizedAndSolved(sSymbolizedLeft, wordLeft.getSolved())).andReturn(listPossiblesLeft);
		expect(dao.findBySymbolizedAndSolved(sSymbolizedRight, wordRight.getSolved())).andReturn(listPossiblesRight);
		replay(dao);
		
		cfr.setWordsDAO(dao);
		cfr.setSymbolizer(sym);
		
		Map<Character, Character> mapSolved = cfr.solvePair(wordLeft, wordRight);
		assertEquals(9, mapSolved.size());
		
		verify(dao);
		verify(sym);
	}
	
	@Test
	public void noListRight()
	{
		String sSymbolizedLeft = "012345230";
		String sSymbolizedRight = "012'3";
		String sCipherLeft = "RFAWIGAWR";
		String sCipherRight = "LFM'I";
		String sSymbolized = "012345230617'4";

		Symbolizer sym = createMock(Symbolizer.class);
		expect(sym.symbolize(sCipherLeft)).andReturn(sSymbolizedLeft);
		expect(sym.symbolize(sCipherRight)).andReturn(sSymbolizedRight);
		expect(sym.symbolize(sCipherLeft + sCipherRight)).andReturn(sSymbolized);

		replay(sym);
		
		CryptogramWord wordLeft = new CryptogramWord(sCipherLeft, sym);
		CryptogramWord wordRight = new CryptogramWord(sCipherRight, sym);

		WordsDAO dao = createMock(WordsDAO.class);
		List<WordDTO> listPossiblesLeft = new ArrayList<WordDTO>();
		listPossiblesLeft.add(new WordDTO("sainfoins", sSymbolizedLeft));
		listPossiblesLeft.add(new WordDTO("snowplows", sSymbolizedLeft));
		listPossiblesLeft.add(new WordDTO("sometimes", sSymbolizedLeft));
		listPossiblesLeft.add(new WordDTO("sonatinas", sSymbolizedLeft));
		listPossiblesLeft.add(new WordDTO("sukiyakis", sSymbolizedLeft));
		List<WordDTO> listPossiblesRight = new ArrayList<WordDTO>();
		expect(dao.findBySymbolizedAndSolved(sSymbolizedLeft, wordLeft.getSolved())).andReturn(listPossiblesLeft);
		expect(dao.findBySymbolizedAndSolved(sSymbolizedRight, wordRight.getSolved())).andReturn(listPossiblesRight);
		replay(dao);
		
		WordCrossreferencer cfr = new WordCrossreferencer();

		cfr.setWordsDAO(dao);
		cfr.setSymbolizer(sym);
		
		Map<Character, Character> mapSolved = cfr.solvePair(wordLeft, wordRight);
		assertEquals(1, mapSolved.size());
		
		verify(dao);
		verify(sym);
	}

	@Test
	public void noListLeft()
	{
		String sSymbolizedRight = "012345230";
		String sSymbolizedLeft = "012'3";
		String sCipherRight = "RFAWIGAWR";
		String sCipherLeft = "LFM'I";
		String sSymbolized = "012345230617'4";

		Symbolizer sym = createMock(Symbolizer.class);
		expect(sym.symbolize(sCipherLeft)).andReturn(sSymbolizedLeft);
		expect(sym.symbolize(sCipherRight)).andReturn(sSymbolizedRight);
		expect(sym.symbolize(sCipherLeft + sCipherRight)).andReturn(sSymbolized);

		replay(sym);
		
		CryptogramWord wordLeft = new CryptogramWord(sCipherLeft, sym);
		CryptogramWord wordRight = new CryptogramWord(sCipherRight, sym);

		WordsDAO dao = createMock(WordsDAO.class);
		List<WordDTO> listPossiblesRight = new ArrayList<WordDTO>();
		listPossiblesRight.add(new WordDTO("sainfoins", sSymbolizedRight));
		listPossiblesRight.add(new WordDTO("snowplows", sSymbolizedRight));
		listPossiblesRight.add(new WordDTO("sometimes", sSymbolizedRight));
		listPossiblesRight.add(new WordDTO("sonatinas", sSymbolizedRight));
		listPossiblesRight.add(new WordDTO("sukiyakis", sSymbolizedRight));
		List<WordDTO> listPossiblesLeft = new ArrayList<WordDTO>();
		expect(dao.findBySymbolizedAndSolved(sSymbolizedLeft, wordLeft.getSolved())).andReturn(listPossiblesLeft);
		expect(dao.findBySymbolizedAndSolved(sSymbolizedRight, wordRight.getSolved())).andReturn(listPossiblesRight);
		replay(dao);
		
		WordCrossreferencer cfr = new WordCrossreferencer();

		cfr.setWordsDAO(dao);
		cfr.setSymbolizer(sym);
		
		Map<Character, Character> mapSolved = cfr.solvePair(wordLeft, wordRight);
		assertEquals(1, mapSolved.size());
		
		verify(dao);
		verify(sym);
	}

	@Test
	public void buildHints()
	{
		Symbolizer sym = createMock(Symbolizer.class);
		expect(sym.symbolize("RFAWIGAWR")).andReturn("012345230");
		replay(sym);
		
		List<WordDTO> listWords = new ArrayList<WordDTO>();
		listWords.add(new WordDTO("sainfoins", "012345230"));
		listWords.add(new WordDTO("sometimes", "012345230"));
		listWords.add(new WordDTO("sonatinas", "012345230"));
		listWords.add(new WordDTO("sukiyakis", "012345230"));
		listWords.add(new WordDTO("snowplows", "012345230"));
		
		WordsDAO dao = createMock(WordsDAO.class);
		expect(dao.findBySymbolizedAndSolved("012345230", "?????????")).andReturn(listWords);
		replay(dao);
		
		LetterHints hints = createMock(LetterHints.class);
		hints.put('R', new HashSet<Character>(Arrays.asList('s')));
		hints.put('F', new HashSet<Character>(Arrays.asList('a', 'o', 'u', 'n')));
		hints.put('A', new HashSet<Character>(Arrays.asList('i', 'm', 'n', 'k', 'o')));
		hints.put('W', new HashSet<Character>(Arrays.asList('n', 'e', 'a', 'i', 'w')));
		hints.put('I', new HashSet<Character>(Arrays.asList('f', 't', 'y', 'p')));
		hints.put('G', new HashSet<Character>(Arrays.asList('o', 'i', 'a', 'l')));
		hints.put('A', new HashSet<Character>(Arrays.asList('i', 'm', 'n', 'k', 'o')));
		hints.put('W', new HashSet<Character>(Arrays.asList('n', 'e', 'a', 'i', 'w')));
		hints.put('R', new HashSet<Character>(Arrays.asList('s')));
		replay(hints);
		
		WordCrossreferencer cfr = new WordCrossreferencer();

		cfr.setWordsDAO(dao);
		cfr.setSymbolizer(sym);

		cfr.buildHints(new CryptogramWord("RFAWIGAWR", sym), hints);
		
		verify(hints);
		verify(dao);
		verify(sym);
	}

	@Test
	public void solveWithHints()
	{
		String sLeft = "RFAWIGAWR";
		String sSymbolizedLeft = "012345230";
		String sRight = "LWACML";
		String sSymbolizedRight = "012340";
		String sSymbolized = "012345230632786";
		
		Symbolizer sym = createMock(Symbolizer.class);
		expect(sym.symbolize(sLeft)).andReturn(sSymbolizedLeft);
		expect(sym.symbolize(sRight)).andReturn(sSymbolizedRight);
		expect(sym.symbolize(sLeft + sRight)).andReturn(sSymbolized);
		replay(sym);
		
		List<WordDTO> listWordsLeft = new ArrayList<WordDTO>();
		listWordsLeft.add(new WordDTO("sainfoins", sSymbolizedLeft));
		listWordsLeft.add(new WordDTO("sometimes", sSymbolizedLeft));
		listWordsLeft.add(new WordDTO("sonatinas", sSymbolizedLeft));
		listWordsLeft.add(new WordDTO("sukiyakis", sSymbolizedLeft));
		listWordsLeft.add(new WordDTO("snowplows", sSymbolizedLeft));

		List<WordDTO> listWordsRight = new ArrayList<WordDTO>();
		
		WordsDAO dao = createMock(WordsDAO.class);
		expect(dao.findBySymbolizedAndSolved(sSymbolizedLeft, "?????????")).andReturn(listWordsLeft);
		expect(dao.findBySymbolizedAndSolved(sSymbolizedLeft, "?????????")).andReturn(listWordsLeft);
		expect(dao.findBySymbolizedAndSolved(sSymbolizedRight, "??????")).andReturn(listWordsRight);
		expect(dao.findBySymbolizedAndSolved(sSymbolizedRight, "??????")).andReturn(listWordsRight);
		replay(dao);
		
		LetterHints hints = createMock(LetterHints.class);
		
		expect(hints.isPlausible(aryEq(sLeft.toCharArray()), aryEq("sainfoins".toCharArray()))).andReturn(false);
		expect(hints.isPlausible(aryEq(sLeft.toCharArray()), aryEq("sometimes".toCharArray()))).andReturn(true);
		expect(hints.isPlausible(aryEq(sLeft.toCharArray()), aryEq("sonatinas".toCharArray()))).andReturn(true);
		expect(hints.isPlausible(aryEq(sLeft.toCharArray()), aryEq("sukiyakis".toCharArray()))).andReturn(false);
		expect(hints.isPlausible(aryEq(sLeft.toCharArray()), aryEq("snowplows".toCharArray()))).andReturn(false);
		
		hints.put('R', new HashSet<Character>(Arrays.asList('s')));
		hints.put('F', new HashSet<Character>(Arrays.asList('o')));
		hints.put('A', new HashSet<Character>(Arrays.asList('m', 'n')));
		hints.put('W', new HashSet<Character>(Arrays.asList('e', 'a')));
		hints.put('I', new HashSet<Character>(Arrays.asList('t')));
		hints.put('G', new HashSet<Character>(Arrays.asList('i')));
		hints.put('A', new HashSet<Character>(Arrays.asList('m', 'n')));
		hints.put('W', new HashSet<Character>(Arrays.asList('e', 'a')));
		hints.put('R', new HashSet<Character>(Arrays.asList('s')));
		replay(hints);
		
		WordCrossreferencer cfr = new WordCrossreferencer();

		cfr.setWordsDAO(dao);
		cfr.setSymbolizer(sym);

		Map<Character, Character> mapSolved = cfr.solvePair(
			new CryptogramWord(sLeft, sym), 
			new CryptogramWord(sRight, sym), 
			hints
		);
		
		assertEquals(4, mapSolved.size());
		assertEquals((Character)'s', mapSolved.get('R'));
		assertEquals((Character)'o', mapSolved.get('F'));
		assertEquals((Character)'t', mapSolved.get('I'));
		assertEquals((Character)'i', mapSolved.get('G'));
		
		verify(hints);
		verify(dao);
		verify(sym);
	}
	
	@Test
	public void solveCompletelyWithHints()
	{
		String sLeft = "RFAWIGAWR";
		String sSymbolizedLeft = "012345230";
		String sRight = "LWACML";
		String sSymbolizedRight = "012340";
		String sSymbolized = "012345230632786";
		
		Symbolizer sym = createMock(Symbolizer.class);
		expect(sym.symbolize(sLeft)).andReturn(sSymbolizedLeft);
		expect(sym.symbolize(sRight)).andReturn(sSymbolizedRight);
		expect(sym.symbolize(sLeft + sRight)).andReturn(sSymbolized);
		replay(sym);
		
		List<WordDTO> listWordsLeft = new ArrayList<WordDTO>();
		listWordsLeft.add(new WordDTO("sainfoins", sSymbolizedLeft));
		listWordsLeft.add(new WordDTO("sometimes", sSymbolizedLeft));
		listWordsLeft.add(new WordDTO("sonatinas", sSymbolizedLeft));
		listWordsLeft.add(new WordDTO("sukiyakis", sSymbolizedLeft));
		listWordsLeft.add(new WordDTO("snowplows", sSymbolizedLeft));

		List<WordDTO> listWordsRight = new ArrayList<WordDTO>();
		
		WordsDAO dao = createMock(WordsDAO.class);
		expect(dao.findBySymbolizedAndSolved(sSymbolizedLeft, "?????????")).andReturn(listWordsLeft);
		expect(dao.findBySymbolizedAndSolved(sSymbolizedLeft, "?????????")).andReturn(listWordsLeft);
		expect(dao.findBySymbolizedAndSolved(sSymbolizedRight, "??????")).andReturn(listWordsRight);
		expect(dao.findBySymbolizedAndSolved(sSymbolizedRight, "??????")).andReturn(listWordsRight);
		replay(dao);
		
		LetterHints hints = createMock(LetterHints.class);
		
		expect(hints.isPlausible(aryEq(sLeft.toCharArray()), aryEq("sainfoins".toCharArray()))).andReturn(false);
		expect(hints.isPlausible(aryEq(sLeft.toCharArray()), aryEq("sometimes".toCharArray()))).andReturn(true);
		expect(hints.isPlausible(aryEq(sLeft.toCharArray()), aryEq("sonatinas".toCharArray()))).andReturn(false);
		expect(hints.isPlausible(aryEq(sLeft.toCharArray()), aryEq("sukiyakis".toCharArray()))).andReturn(false);
		expect(hints.isPlausible(aryEq(sLeft.toCharArray()), aryEq("snowplows".toCharArray()))).andReturn(false);
		
		hints.put('R', new HashSet<Character>(Arrays.asList('s')));
		hints.put('F', new HashSet<Character>(Arrays.asList('o')));
		hints.put('A', new HashSet<Character>(Arrays.asList('m')));
		hints.put('W', new HashSet<Character>(Arrays.asList('e')));
		hints.put('I', new HashSet<Character>(Arrays.asList('t')));
		hints.put('G', new HashSet<Character>(Arrays.asList('i')));
		hints.put('A', new HashSet<Character>(Arrays.asList('m')));
		hints.put('W', new HashSet<Character>(Arrays.asList('e')));
		hints.put('R', new HashSet<Character>(Arrays.asList('s')));
		replay(hints);
		
		WordCrossreferencer cfr = new WordCrossreferencer();

		cfr.setWordsDAO(dao);
		cfr.setSymbolizer(sym);

		Map<Character, Character> mapSolved = cfr.solvePair(
			new CryptogramWord(sLeft, sym), 
			new CryptogramWord(sRight, sym), 
			hints
		);
		
		assertEquals(6, mapSolved.size());
		assertEquals((Character)'s', mapSolved.get('R'));
		assertEquals((Character)'o', mapSolved.get('F'));
		assertEquals((Character)'m', mapSolved.get('A'));
		assertEquals((Character)'e', mapSolved.get('W'));
		assertEquals((Character)'t', mapSolved.get('I'));
		assertEquals((Character)'i', mapSolved.get('G'));
		
		verify(hints);
		verify(dao);
		verify(sym);
	}
}
