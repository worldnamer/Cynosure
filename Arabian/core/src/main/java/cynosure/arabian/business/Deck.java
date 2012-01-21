package cynosure.arabian.business;

import java.util.*;

import cynosure.arabian.data.EncounterCard;

public interface Deck
{
	EncounterCard getCard();

	void shuffle();

	EncounterCard takeCard(String title);

	void replaceCard(EncounterCard card);

	public void setCards(List<EncounterCard> cards);
}