package cynosure.prolixity;

import java.io.*;
import java.util.*;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;

public class ComplexityConverter
{
	public static void main(String[] args)
	{
		Deque<Integer> lastTenComplexities = new ArrayDeque<Integer>();
		double lastTenComplexitiesSummed = 0.0;
		double overallComplexitySum = 0.0;
		int termCount = 0;
		int movingAverageTerms = 20;
		
		Map<String, Integer> words = new HashMap<String, Integer>();
		
		Analyzer analyzer = new SimpleAnalyzer();
		Complexometer meter = new Complexometer();
		try
		{
			FileReader rd = new FileReader(ComplexityConverter.class.getResource("/playtest.txt").getFile());
			BufferedReader ln = new BufferedReader(rd);
			try
			{
				String line = ln.readLine();
				while (line != null) {
					line = line.toLowerCase();
					
					String replaceLine = line;
					StringReader rdString = new StringReader(replaceLine);
					TokenStream tokenStream = analyzer.tokenStream("field", rdString);
					
					tokenStream.reset();

					while (tokenStream.incrementToken()) {
						TermAttribute attr = tokenStream.getAttribute(TermAttribute.class);
						String replacedTerm = attr.term();
						
						int complexity = meter.measure(replacedTerm);
						overallComplexitySum += complexity;
						termCount++;
						
						if (lastTenComplexities.size() < movingAverageTerms) {
							lastTenComplexities.add(complexity);
							lastTenComplexitiesSummed += complexity; 
						} else {
							Integer oldComplexity = lastTenComplexities.remove();
							lastTenComplexities.add(complexity);
							lastTenComplexitiesSummed -= oldComplexity;
							lastTenComplexitiesSummed += complexity;
							//System.out.println(lastTenComplexitiesSummed / movingAverageTerms);
						}
						
						if (replaceLine != null && (replacedTerm != null)) {
							Double d = new Double(complexity);
							if (termCount > movingAverageTerms) {
								d = new Double(lastTenComplexitiesSummed/movingAverageTerms);
							}
							
							if (d >= 1.4d) {
								System.out.println(attr.term() + " ");
							}
								
						}
						
						words.put(attr.term(), meter.measure(attr.term()));
					}
					
					tokenStream.end();
					tokenStream.close();
					rdString.close();
					
					System.out.println(replaceLine);
					//System.out.println(line);

					line = ln.readLine();
				}
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
		catch (FileNotFoundException ex1)
		{
			System.err.println("Couldn't find file [mom.txt]");
		}
		
		/*
		for (Map.Entry<String, Integer> entry : words.entrySet()) {
			System.out.println("[" + entry.getKey() + "] : " + entry.getValue());
		}
		*/
		
		System.out.println("Terms: [" + termCount + "]  Complexity: [" + overallComplexitySum / termCount + "]");
	}

	@SuppressWarnings("unused")
	private static String pad(String string, int length)
	{
		if (string.length() < length) {
			char[] spaces = new char[length - string.length()];
			Arrays.fill(spaces, ' ');
			return string + new String(spaces);
		}
		
		return string;
	}
}
