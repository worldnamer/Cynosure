package cynosure.prolixity;

import static org.junit.Assert.*;

import java.io.StringReader;

import org.junit.Test;

public class DocumentParserTest
{
	@Test
	public void parseDocument() {
		StringReader rd = new StringReader("This is an example example of some data read from a reader.");
		
		DocumentParser parser = new DocumentParser();
		Document doc = parser.parse(rd);
		
		assertNotNull(doc);
		assertEquals(11, doc.getWords().size());
		assertTrue(doc.getWords().contains(new WordCount("example", 2)));
	}
}
