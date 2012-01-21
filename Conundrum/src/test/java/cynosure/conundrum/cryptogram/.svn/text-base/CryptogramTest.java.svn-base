package cynosure.conundrum.cryptogram;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

public class CryptogramTest 
{
	@Test
	public void constructor()
	{
		Cryptogram cgram = new Cryptogram();
		
		assertNotNull(cgram);
	}
	
	@Test
	public void setCryptogram()
	{
		CryptogramWord wordFirst = new CryptogramWord("FIRST");
		CryptogramWord wordSecond = new CryptogramWord("POST");
		List<CryptogramWord> listWords = Arrays.asList(new CryptogramWord[] {wordFirst, wordSecond});
		
		Cryptogram cgram = new Cryptogram();
		
		cgram.setWords(listWords);
		
		assertEquals(listWords, cgram.getWords());
	}
	
	@Test
	public void setCryptogramMoreWords()
	{
		CryptogramWord wordFirst = new CryptogramWord("FIRST");
		CryptogramWord wordSecond = new CryptogramWord("POST");
		CryptogramWord wordThird = new CryptogramWord("TODAY");
		List<CryptogramWord> listWords = Arrays.asList(new CryptogramWord[] {wordFirst, wordSecond, wordThird});
		
		Cryptogram cgram = new Cryptogram();
		
		cgram.setWords(listWords);
		
		assertEquals(listWords, cgram.getWords());
	}
	
	@Test
	public void solveALetter()
	{
		CryptogramWord wordFirst = new CryptogramWord("FIRST");
		CryptogramWord wordSecond = new CryptogramWord("POST");
		List<CryptogramWord> listWords = Arrays.asList(new CryptogramWord[] {wordFirst, wordSecond});
		
		Cryptogram cgram = new Cryptogram();
		cgram.setWords(listWords);
		
		cgram.solve('T', 'd');
		
		CryptogramWord wordFirst2 = new CryptogramWord("FIRST");
		wordFirst2.solve('T', 'd');
		CryptogramWord wordSecond2 = new CryptogramWord("POST");
		wordSecond2.solve('T', 'd');
		List<CryptogramWord> listWords2 = Arrays.asList(new CryptogramWord[] {wordFirst2, wordSecond2});
		
		assertEquals(listWords2, cgram.getWords());
	}
	
	@Test
	public void toStringIsCiphertext()
	{
		CryptogramWord wordFirst = new CryptogramWord("FIRST");
		CryptogramWord wordSecond = new CryptogramWord("POST");
		List<CryptogramWord> listWords = Arrays.asList(new CryptogramWord[] {wordFirst, wordSecond});
		
		Cryptogram cgram = new Cryptogram();
		cgram.setWords(listWords);
		
		assertEquals("FIRST POST", cgram.toString());
	}
	
	@Test
	public void toStringSolvedIsCorrect()
	{
		CryptogramWord wordFirst = new CryptogramWord("FIRST");
		CryptogramWord wordSecond = new CryptogramWord("POST");
		wordFirst.solve('T', 'Q');
		wordSecond.solve('T', 'Q');
		List<CryptogramWord> listWords = Arrays.asList(new CryptogramWord[] {wordFirst, wordSecond});
		
		Cryptogram cgram = new Cryptogram();
		cgram.setWords(listWords);
		
		assertEquals("????Q ???Q", cgram.toStringSolved());
	}
}
