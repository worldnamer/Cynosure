package cynosure.arabian.data.dao;

import java.io.*;
import java.util.*;

import com.google.gson.Gson;

import cynosure.arabian.data.*;

public class EncounterTableDAOImpl implements EncounterTableDAO
{
	private Map<String, EncounterTable> tables = new HashMap<String, EncounterTable>();
	
	public EncounterTableDAOImpl(Reader rd)
	{
		if (rd != null) {
			try 
			{
				Gson gson = new Gson();
				
				BufferedReader buf = new BufferedReader(rd);
				String line = buf.readLine();
				while (line != null)
				{
					EncounterTable card = gson.fromJson(line, EncounterTable.class);
					tables.put(card.getTitle().toLowerCase(), card);
					line = buf.readLine();
				}
			}
			catch (IOException ex) {
				
			}
		}
	}

	public List<EncounterTable> getTables() {
		List<EncounterTable> list = new ArrayList<EncounterTable>();
		
		for (Map.Entry<String, EncounterTable> entry : tables.entrySet()) {
			list.add(entry.getValue());
		}
		
		return list;
	}

	public EncounterTable getTable(String title)
	{
		return tables.get(title.toLowerCase());
	}
}
