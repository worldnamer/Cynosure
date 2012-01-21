package cynosure.prolixity;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

public class WordCountTest
{
	@Test
	public void countStartsAtZero() {
		WordCount wc = new WordCount();
		
		assertEquals(0, wc.getCount());
	}
	
	@Test
	public void wordCanBeRetrieved() {
		String word = UUID.randomUUID().toString();
		
		WordCount wc = new WordCount();
		wc.setWord(word);
		
		assertEquals(word, wc.getWord());
	}
	
	@Test
	public void countCanBeRetrieved() {
		WordCount wc = new WordCount();
		
		wc.setCount(1);
		
		assertEquals(1, wc.getCount());
	}
	
	@Test
	public void equality() {
		WordCount wc = new WordCount();
		
		wc.setWord("test");
		wc.setCount(1);
		
		assertEquals(new WordCount("test", 1), wc);
	}

	@Test
	public void inequalCounts() {
		WordCount wc = new WordCount();
		
		wc.setWord("test");
		wc.setCount(1);
		
		assertFalse(new WordCount("test", 2).equals(wc));
	}
	
	@Test
	public void inequalWords() {
		WordCount wc = new WordCount();
		
		wc.setWord("test1");
		wc.setCount(1);
		
		assertFalse(new WordCount("test", 1).equals(wc));
	}
}
