package cynosure.conundrum.cryptogram.utilprog;

import java.io.*;
import java.util.*;

import cynosure.conundrum.cryptogram.SymbolizerBase;
import cynosure.conundrum.cryptogram.dao.*;

public class TestCrossreferencing
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
	
	public static void main(String[] args) throws Exception
	{
		SymbolizerBase sym = new SymbolizerBase();
		
		InMemoryWordsDAOFileLoader loader = new InMemoryWordsDAOFileLoader();
		loader.setSymbolizer(sym);
		
		InMemoryWordsDAO dao = new InMemoryWordsDAO();

		for (int i = 2; i < 10; i++)
		{
			System.out.println("Loading " + i + " length words...");
			loadN(i, loader, dao);
		}
		System.out.println("All words loaded!");

		List<WordDTO> listFive = dao.findBySymbolizedAndSolved("01234", "t?in?");
		List<WordDTO> listSix = dao.findBySolved("?em???");
		
		System.out.println("fives: " + listFive.size());
		System.out.println("sixes: " + listSix.size());
		System.out.println();
		
		String sSymbolized = sym.symbolize("IDGMJ" + "LWACML");
		
		Set<WordDTO> setFivesThatMatch = new HashSet<WordDTO>();
		Set<WordDTO> setSixesThatMatch = new HashSet<WordDTO>();
		
		for (WordDTO wordSix : listSix)
		{
			for (WordDTO wordFive : listFive)
			{
				String sToCheck = sym.symbolize(wordFive.getWord() + wordSix.getWord());
				if (sSymbolized.equals(sToCheck))
				{
					setFivesThatMatch.add(wordFive);
					setSixesThatMatch.add(wordSix);
				}
			}
		}

		System.out.println("fives after cf: " + setFivesThatMatch.size());
		System.out.println("sixes after cf: " + setSixesThatMatch.size());
		System.out.println();
		
		System.out.println("fives ---");
		for (WordDTO wordFive : setFivesThatMatch)
			System.out.println(wordFive.getWord());
		System.out.println();
		
		System.out.println("sixes ---");
		for (WordDTO wordSix : setSixesThatMatch)
			System.out.println(wordSix.getWord());
	}
}
