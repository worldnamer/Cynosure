package cynosure.conundrum.cryptogram;

import cynosure.conundrum.cryptogram.interfaces.Symbolizer;

public class SymbolizerBase implements Symbolizer 
{
	private char getCharForIndex(int _nIndex, char _cCurrently)
	{
		if (_cCurrently == '\'')
			return _cCurrently;
		if (_nIndex < 10)
			return (char)((int)'0' + _nIndex);
		
		return (char)((int)'A' + _nIndex - 10);
	}

	/*
	// This algorithm, ugly as sin, seems to have a better worst-case processing speed. It seems also
	// to have a worse average-case speed. I'm uncertain whether using this has a measurable effect
	// on larger speeds, however.
	public String newSymbolize(String _sToSymbolize)
	{
		char[] szToSymbolize = _sToSymbolize.toCharArray();
		
		// Degenerate Cases
		if (szToSymbolize.length == 1)
			return "0";
		
		if (szToSymbolize.length == 2)
			if (szToSymbolize[0] == szToSymbolize[1])
				return "00";
			else
				return "01";

		// Arrays for tracking state
		char[] szSymbolized = new char[szToSymbolize.length];
		boolean[] bSymbolized = new boolean[szToSymbolize.length];
		
		int nIndex = 0;
		int nFirst = 0;
		int nSecond = 1;
		
		while (nFirst < szToSymbolize.length)
		{
			if (
				(nFirst == szToSymbolize.length - 1) ||
				(nSecond == szToSymbolize.length)
			   )
			{
				szSymbolized[nFirst] = getCharForIndex(nIndex);
				nFirst = szToSymbolize.length;
			}
			else if (nSecond == szToSymbolize.length - 1)
			{
				szSymbolized[nFirst] = getCharForIndex(nIndex);
				if (szToSymbolize[nFirst] == szToSymbolize[nSecond])
				{
					szSymbolized[nSecond] = szSymbolized[nFirst];
				}
				else
				{
					nIndex++;
					szSymbolized[nSecond] = getCharForIndex(nIndex);
				}

				nFirst = szToSymbolize.length;
			}
			else
			{
				int nNextFirst = szToSymbolize.length;
				int nNextSecond = szToSymbolize.length;
				
				// Cache the symbols we're going to use for the first and second letters
				char cFirst = getCharForIndex(nIndex);
				nIndex++;
				char cSecond = getCharForIndex(nIndex);
				nIndex++;

				// Find first two non-repeats
				while (szToSymbolize[nFirst] == szToSymbolize[nSecond])
				{
					szSymbolized[nSecond] = cFirst;
					bSymbolized[nSecond] = true;
					
					if (nSecond == szToSymbolize.length - 1)
					{
						szSymbolized[nFirst] = cFirst;
						return new String(szSymbolized);
					}
					else
						nSecond++;
				}
				
				szSymbolized[nFirst] = cFirst;
				bSymbolized[nFirst] = true;
				szSymbolized[nSecond] = cSecond;
				bSymbolized[nSecond] = true;
				
				// Array is larger than two characters
				for (int i = nFirst + 1; i < szToSymbolize.length; i++)
				{
					if (!bSymbolized[i])
					{
						if (szToSymbolize[i] == szToSymbolize[nFirst])
						{
							szSymbolized[i] = cFirst;
							bSymbolized[i] = true;
						}
						else if (szToSymbolize[i] == szToSymbolize[nSecond])
						{
							szSymbolized[i] = cSecond;
							bSymbolized[i] = true;
						}
						else
						{
							if (nNextFirst == szToSymbolize.length)
							{
								nNextFirst = i;
							}
							else if (nNextSecond == szToSymbolize.length)
							{
								nNextSecond = i;
							}
						}
					}
				}
				
				nFirst = nNextFirst;
				nSecond = nNextSecond;
			}
		}

		return new String(szSymbolized);
	}
	*/

	public String oldSymbolize(String _sToSymbolize)
	{
		char[] szToSymbolize = _sToSymbolize.toCharArray();
		
		// Degenerate Cases
		if (szToSymbolize.length == 1)
			return "0";
		
		if (szToSymbolize.length == 2)
			if (szToSymbolize[0] == szToSymbolize[1])
				return "00";
			else
				return "01";

		// Arrays for tracking state
		char[] szSymbolized = new char[szToSymbolize.length];
		boolean[] bSymbolized = new boolean[szToSymbolize.length];
		
		int nIndex = 0;
		
		for (int i = 0; i < szToSymbolize.length; i++)
		{
			if (!bSymbolized[i])
			{
				char cSource = szToSymbolize[i];
				boolean bDidReplace = false;
				for (int j = i; j < szToSymbolize.length; j++)
				{
					if (cSource == szToSymbolize[j])
					{
						char cReplace = getCharForIndex(nIndex, cSource);
						szSymbolized[j] = cReplace;
						bSymbolized[j] = true;

						if (cReplace != szToSymbolize[j])
							bDidReplace = true;
					}
				}
				if (bDidReplace)
					nIndex++;
			}
		}

		return new String(szSymbolized);
	}
	
	@Override
	public String symbolize(String _sToSymbolize) 
	{
		return oldSymbolize(_sToSymbolize);
	}
}
