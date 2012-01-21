package cynosure.conundrum.cryptogram.utilprog;

import java.io.*;

public class GetNs 
{
	public static void getN(int _nSize) throws Exception
	{
		String sFileIn = "C:\\Users\\worldnamer\\Desktop\\enable2k.txt";
	    String sFileOut = "C:\\Users\\worldnamer\\Desktop\\enable2k-" + _nSize + "s.txt";
		BufferedReader input = new BufferedReader(new FileReader(new File(sFileIn)));
	    BufferedWriter output = new BufferedWriter(new FileWriter(sFileOut));
		
		try 
		{
	        String sLine = null;
	        
	        while ((sLine = input.readLine()) != null)
	        	if (sLine.length() == _nSize)
	        	{
			    	output.write(sLine);
			    	output.write("\r\n");
	        	}
		}
	    finally 
	    {
	    	input.close();
	        output.close();
	    }
	}
	
	public static void main(String[] args) throws Exception
	{
		for (int i = 2; i < 10; i++)
		{
			getN(i);
		}
	}
}
