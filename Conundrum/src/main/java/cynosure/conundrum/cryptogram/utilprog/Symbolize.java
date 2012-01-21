package cynosure.conundrum.cryptogram.utilprog;

import java.io.*;

import cynosure.conundrum.cryptogram.SymbolizerBase;

public class Symbolize
{
	public static void main(String[] args) throws IOException 
	{
		String sFileIn = "C:\\Users\\worldnamer\\Desktop\\enable2k-5s.txt";
	    String sFileOut = "C:\\Users\\worldnamer\\Desktop\\enable2k-5s-sym.csv";
		BufferedReader input = new BufferedReader(new FileReader(new File(sFileIn)));
	    BufferedWriter output = new BufferedWriter(new FileWriter(sFileOut));
		
		try 
		{
	    	SymbolizerBase sym = new SymbolizerBase();
	        String sLine = null;
	        
	        while ((sLine = input.readLine()) != null)
	    	{
	        	if (!sLine.equals(""))
	        	{
			    	output.write(sLine);
			    	output.write(",");
			    	output.write(sym.symbolize(sLine));
			    	output.write("\n");
	        	}
	    	}
		}
	    finally 
	    {
	    	input.close();
	    	output.close();
	    }
	}
}
