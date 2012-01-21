package cynosure.arabian.data.dao;

import java.io.*;
import java.util.*;

import com.google.gson.Gson;

import cynosure.arabian.data.EncounterCard;

public class EncounterCardDAOImpl implements EncounterCardDAO
{
	Map<String, EncounterCard> cards = new HashMap<String, EncounterCard>();
	
	public EncounterCardDAOImpl(Reader rd)
	{
		if (rd != null) {
			try 
			{
				Gson gson = new Gson();
				
				BufferedReader buf = new BufferedReader(rd);
				String line = buf.readLine();
				while (line != null)
				{
					EncounterCard card = gson.fromJson(line, EncounterCard.class);
					cards.put(card.getTitle().toLowerCase(), card);
					line = buf.readLine();
				}
			}
			catch (IOException ex) {
				
			}
		}
	}

	public List<EncounterCard> getCards() {
		List<EncounterCard> list = new ArrayList<EncounterCard>();
		
		for (Map.Entry<String, EncounterCard> entry : cards.entrySet()) {
			list.add(entry.getValue());
		}
		
		return list;
	}

	public EncounterCard getCard(String title)
	{
		return cards.get(title.toLowerCase());
	}
}
