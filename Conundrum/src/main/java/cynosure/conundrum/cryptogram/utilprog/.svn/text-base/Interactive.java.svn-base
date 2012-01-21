package cynosure.conundrum.cryptogram.utilprog;

import java.io.*;
import java.util.*;

import cynosure.conundrum.cryptogram.*;
import cynosure.conundrum.cryptogram.dao.*;

public class Interactive 
{
	public static void loadDAO(
		InMemoryWordsDAOFileLoader _loader, 
		InMemoryWordsDAO _dao
	   )
	{
		try
		{
			String sFileInN = "C:\\Users\\worldnamer\\Desktop\\enable2k.txt";
			BufferedReader input  = new BufferedReader(new FileReader(new File(sFileInN)));
			
			_loader.load(input, _dao);
			
			input.close();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void main(String args[]) 
	{
		boolean bDone = false;
		
		java.io.InputStreamReader isrdIn = new InputStreamReader(System.in);
		java.io.BufferedReader rdIn = new BufferedReader(isrdIn);
		
		SymbolizerBase sym = new SymbolizerBase();
		InMemoryWordsDAOFileLoader loader = new InMemoryWordsDAOFileLoader();
		loader.setSymbolizer(sym);
		
		InMemoryWordsDAO dao = new InMemoryWordsDAO();
		System.out.print("loading dictionary...");
		loadDAO(loader, dao);
		System.out.println("done.");
		
		Cryptogram cgram = new Cryptogram();
		LetterHintsBase hints = new LetterHintsBase(); 
		
		while (!bDone)
		{
			try
			{
				System.out.print("> ");
				String sLine = rdIn.readLine();
				if (sLine == null) // this only happens when there's an thread interruption, I think
					sLine = "";
				else
					sLine = sLine.trim();
				
				if (sLine.equals("!q"))
				{
					bDone = true;
				}
				else if (sLine.equals("!c"))
				{
					System.out.println("count: " + dao.count());
				}
				else if (sLine.startsWith("!c "))
				{
					String sSolved = sLine.substring(2).trim();
					System.out.println("count [" + sSolved + "]: " + dao.countBySolved(sSolved));
				}
				else if (sLine.startsWith("!s "))
				{
					String sSymbolized = sLine.substring(2).trim();
					System.out.println("solutions: " + dao.findBySymbolized(sSymbolized));
				}
				else if (sLine.startsWith("!cs "))
				{
					String sSymbolized = sLine.substring(3).trim();
					System.out.println("count [" + sSymbolized + "]: " + dao.countBySymbolized(sSymbolized));
				}
				else if (sLine.startsWith("!cos "))
				{
					String sSymbolized = sLine.substring(4).trim();
					System.out.println("count of symbolized [" + sSymbolized + "]: " + dao.countOfSymbolized(Integer.parseInt(sSymbolized)));
				}
				else if (sLine.startsWith("!g "))
				{
					String sCryptogram = sLine.substring(3).trim().toUpperCase();
					PhraseParser parser = new PhraseParser();
					String[] aWords = parser.parse(sCryptogram);
					List<CryptogramWord> listWords = new ArrayList<CryptogramWord>();
					for (String sWord : aWords)
						listWords.add(new CryptogramWord(sWord, sym));
					cgram.setWords(listWords);
					
					System.out.println("Set cryptogram to [" + sCryptogram + "]");
				}
				else if (sLine.equals("!g"))
				{
					System.out.println("Current cryptogram [" + cgram + "]");
					System.out.println("Current solution [" + cgram.toStringSolved() + "]");
				}
				else if (sLine.startsWith("!gs "))
				{
					String sParams = sLine.substring(3).trim();
					String[] aParams = sParams.split(" ");
					if (aParams.length == 2)
					{
						char cFrom = aParams[0].charAt(0);
						char cTo = aParams[1].charAt(0);
						cgram.solve(cFrom, cTo);
						
						System.out.println("solving letter [" + cFrom + "] with [" + cTo + "]");
					}
					else
						System.out.println("confused by parameters list [" + sParams + "]");
				}
				else if (sLine.startsWith("!x "))
				{
					String sParams = sLine.substring(2).trim();
					String[] aParams = sParams.split(" ");
					
					if (aParams.length == 2)
					{
						WordCrossreferencer cfr = new WordCrossreferencer();
						cfr.setWordsDAO(dao);
						cfr.setSymbolizer(sym);
						Map<Character, Character> mapSolved = cfr.solvePair(
							new CryptogramWord(aParams[0], sym),
							new CryptogramWord(aParams[1], sym),
							hints
						);
						System.out.println("solutions: " + mapSolved);
					}
					else
						System.out.println("confused by parameters list [" + sParams + "]");
				}
				else
				{
					String[] aParams = sLine.split(" ");
					
					if (aParams.length == 1)
						System.out.println("solutions: " + dao.findBySolved(sLine));
					else if (aParams.length == 2)
						System.out.println("solutions: " + dao.findBySymbolizedAndSolved(aParams[0], aParams[1]));
					else
						System.out.println("confused by parameters list [" + sLine + "]");

				}
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
				bDone = true;
			}
		}
	}
}
