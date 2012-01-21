package cynosure.arabian.data.dao;

import java.util.List;

import cynosure.arabian.data.EncounterCard;

public interface EncounterCardDAO
{
	List<EncounterCard> getCards();
	EncounterCard getCard(String title);
}