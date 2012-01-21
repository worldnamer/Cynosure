package cynosure.prolixity;

import static org.junit.Assert.*;

import org.junit.*;

public class DocumentTest
{
	private Document doc;
	
	@Before
	public void before() {
		doc = new Document();
	}
	
	@Test
	public void newDocumentsHaveNoWords() {
		assertNotNull(doc.getWords());
		assertEquals(0, doc.getWords().size());
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void returnedListIsImmutable() {
		doc.getWords().add(new WordCount());
	}
	
	@Test
	public void addWord() {
		WordCount wc = new WordCount();
		wc.setWord("test");
		wc.setCount(1);
		doc.addWord(wc);
		
		assertEquals(1, doc.getWords().size());
		assertEquals(wc, doc.getWords().get(0));
	}
	
	@Test
	public void addingSameWordIncreasesCounts() {
		WordCount wc = new WordCount();
		wc.setWord("test");
		wc.setCount(1);
		doc.addWord(wc);
		doc.addWord(wc);
		
		assertEquals(1, doc.getWords().size());
		assertEquals(2, doc.getWords().get(0).getCount());
	}
}
