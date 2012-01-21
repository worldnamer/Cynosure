package cynosure.conundrum.cryptogram.utilprog;

import java.io.*;
import java.util.*;

import cynosure.conundrum.cryptogram.*;
import cynosure.conundrum.cryptogram.dao.*;

public class DeCryptogram
{
	public static void loadN(
		int _nSize, 
		InMemoryWordsDAOFileLoader _loader, 
		InMemoryWordsDAO _dao
	   ) throws Exception
	{
		String sFileInN = "C:\\Users\\worldnamer\\Desktop\\enable2k-" + _nSize + "s.txt";
		BufferedReader input  = new BufferedReader(new FileReader(new File(sFileInN)));
		
		_loader.load(input, _dao);
		
		input.close();
	}
	
	public static void main(String args[]) throws Exception
	{
		// Jack Handy
		//String sCryptogram = "RFAWIGAWR G IDGMJ QFH DCXW IF ACKOD KGSDI GM CML LWACML QFHK KGSDIR, WXWM GZ QFH LFM'I JMFT TDCI QFHK KGSDIR CKW, FK TDF IDW BWKRFM GR QFH'KW ICPJGMS IF.";
		
		// Sylvia Plath
		String sCryptogram = "E AQFN JC RCRA YDW YBB NQR MPUBW WUPOA WRYW; E BEIN JC RCRA YDW YBB EA SPUD YKYED.";
		
		LetterHintsBase hints = new LetterHintsBase();
		
		SymbolizerBase sym = new SymbolizerBase();
		
		PhraseParser parser = new PhraseParser();
		
		String[] sWords = parser.parse(sCryptogram);
		
		List<CryptogramWord> listWords = new ArrayList<CryptogramWord>();
		
		int nMinSize = 100;
		int nMaxSize = 0;
		for (String sWord : sWords)
		{
			listWords.add(new CryptogramWord(sWord, sym));
			
			if (nMinSize > sWord.length())
				nMinSize = sWord.length();
			if (nMaxSize < sWord.length())
				nMaxSize = sWord.length();
		}

		for (CryptogramWord wordToSolve : listWords)
		{
			wordToSolve.solve('D', 'n');
			wordToSolve.solve('J', 'm');
		}
		
		/*
		for (CryptogramWord wordToSolve : listWords)
		{
			wordToSolve.solve('E', 'i');
			wordToSolve.solve('R', 'e');
			wordToSolve.solve('Y', 'a');
			wordToSolve.solve('P', 'o');

			wordToSolve.solve('K', 'g');
			wordToSolve.solve('D', 'n');
			wordToSolve.solve('W', 'd');
			wordToSolve.solve('O', 'p');
			wordToSolve.solve('A', 's');
			wordToSolve.solve('S', 'b');
			wordToSolve.solve('Q', 'h');
			wordToSolve.solve('C', 'y');
			wordToSolve.solve('F', 'u');
			wordToSolve.solve('J', 'm');
		}
		*/
		
		InMemoryWordsDAOFileLoader loader = new InMemoryWordsDAOFileLoader();
		loader.setSymbolizer(sym);
		
		InMemoryWordsDAO dao = new InMemoryWordsDAO();
		
		for (int i = nMinSize; i <= nMaxSize; i++)
		{
			System.out.println("Loading " + i + " length words...");
			loadN(i, loader, dao);
		}
		System.out.println("All words loaded!");
		
		for (CryptogramWord word : listWords)
		{
			String sSymbolized = word.symbolize();
			int nCount = dao.countBySymbolized(sSymbolized);
			if (nCount == 1)
			{
				List<WordDTO> listWord = dao.findBySymbolized(sSymbolized);
				
				System.out.println("solved " + word + " for " + listWord.get(0));
			}
		}
		
		Cryptogram cgram = new Cryptogram();
		cgram.setWords(listWords);
		
		WordCrossreferencer cfr = new WordCrossreferencer();
		cfr.setSymbolizer(sym);
		cfr.setWordsDAO(dao);
		
		for (CryptogramWord word : cgram.getWords())
		{
			for (CryptogramWord wordCf : cgram.getWords())
			{
				if (
					(word != wordCf) &&
					(
					 !word.isSolved() ||
					 !wordCf.isSolved()
					)
				   )
				{
					Map<Character, Character> mapUnsolvedToSolved = cfr.solvePair(word, wordCf, hints);
					
					for (Map.Entry<Character, Character> entry : mapUnsolvedToSolved.entrySet())
					{
						cgram.solve(entry.getKey(), entry.getValue());
					}
				}
			}
		}

		System.out.println();
		System.out.println("_____ SOLUTION SO FAR ____");
		System.out.println(cgram.toStringSolved());
	}
}
