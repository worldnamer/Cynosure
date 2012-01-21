package cynosure.arabian.business;

import java.util.*;

import cynosure.arabian.data.EncounterCard;

public class DeckImpl implements Deck
{
	List<EncounterCard> cards;

	int cardIndex = 0;

	public EncounterCard getCard()
	{
		if (cards != null && cardIndex < cards.size())
			return cards.get(cardIndex++);
		else
			return null;
	}

	public void setCards(List<EncounterCard> cards)
	{
		this.cards = cards;
		Collections.shuffle(this.cards);
	}

	public void shuffle()
	{
		if (cards != null)
		{
			Collections.shuffle(this.cards);
			cardIndex = 0;
		}
	}

	public EncounterCard takeCard(String title)
	{
		for (int i = 0; i < cards.size(); i++)
		{
			if (cards.get(i).getTitle().equals(title))
			{
				EncounterCard card = cards.remove(i);
				if (cardIndex != 0)
					cardIndex--;
				
				return card;
			}
		}

		return null;
	}

	public void replaceCard(EncounterCard card)
	{
		cards.add(0, card);
			
		cardIndex++;
	}
}
