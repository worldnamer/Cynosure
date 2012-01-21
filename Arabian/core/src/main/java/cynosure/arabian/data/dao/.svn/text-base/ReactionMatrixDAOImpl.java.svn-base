package cynosure.arabian.data.dao;

import java.io.*;
import java.util.*;

import com.google.gson.Gson;

import cynosure.arabian.data.*;

public class ReactionMatrixDAOImpl implements ReactionMatrixDAO
{
	public Map<String, ReactionMatrix> matricies = new HashMap<String, ReactionMatrix>();
	
	public ReactionMatrixDAOImpl(Reader rd)
	{
		if (rd != null) {
			try 
			{
				Gson gson = new Gson();
				
				BufferedReader buf = new BufferedReader(rd);
				String line = buf.readLine();
				while (line != null)
				{
					ReactionMatrix matrix = gson.fromJson(line, ReactionMatrix.class);
					matricies.put(matrix.getTitle().toLowerCase(), matrix);
					line = buf.readLine();
				}
			}
			catch (IOException ex) {
				
			}
		}
	}

	@Override
	public ReactionMatrix getMatrix(String title)
	{
		return matricies.get(title.toLowerCase());
	}
}
