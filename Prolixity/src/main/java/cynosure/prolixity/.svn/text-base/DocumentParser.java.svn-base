package cynosure.prolixity;

import java.io.*;
import java.util.*;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;

public class DocumentParser
{
	public Document parse(StringReader rd)
	{
		Analyzer analyzer = new SimpleAnalyzer();
		TokenStream tokenStream = analyzer.tokenStream("field", rd);
		
		Map<String, Integer> words = new HashMap<String, Integer>();
		try
		{
			tokenStream.reset();

			while (tokenStream.incrementToken()) {
				TermAttribute attr = tokenStream.getAttribute(TermAttribute.class);
				if (words.containsKey(attr.term())) {
					words.put(attr.term(), words.get(attr.term()) + 1);
				} else {
					words.put(attr.term(), 1);
				}
			}
			
			tokenStream.end();
			tokenStream.close();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		
		Document doc = new Document();
		for (Map.Entry<String, Integer> entry : words.entrySet()) {
			doc.addWord(new WordCount(entry.getKey(), entry.getValue()));
		}
		return doc;
	}
}
