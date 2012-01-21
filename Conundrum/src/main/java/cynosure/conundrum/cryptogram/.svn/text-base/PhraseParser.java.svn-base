package cynosure.conundrum.cryptogram;

import java.util.*;

public class PhraseParser 
{
	public String[] parse(String _sPhrase) 
	{
		String sStripHyphens = _sPhrase.replace("-", "");
		
		String sRemoveExtraSpaces = sStripHyphens.replaceAll("  ", " ");
		
		String[] aWords = sRemoveExtraSpaces.split("[ .,;]");
		
		List<String> listWordsFromArrays = Arrays.asList(aWords);
		ArrayList<String> listWords = new ArrayList<String>(listWordsFromArrays);
		List<String> listToRemove = Arrays.asList("");
		
		listWords.removeAll(listToRemove);
		
		return listWords.toArray(new String[0]);
	}
}
