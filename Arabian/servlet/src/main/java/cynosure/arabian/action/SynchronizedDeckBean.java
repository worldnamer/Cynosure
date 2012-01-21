package cynosure.arabian.action;

import java.util.List;

import cynosure.arabian.data.EncounterCard;
import cynosure.arabian.ejbs.DeckBeanLocal;

public class SynchronizedDeckBean implements DeckBeanLocal
{
	private DeckBeanLocal deck;

	public EncounterCard getCard()
	{
		synchronized (deck)
		{
			return deck.getCard();
		}
	}

	public List<EncounterCard> getTakenCards()
	{
		synchronized (deck)
		{
			return deck.getTakenCards();
		}
	}

	public void replaceCard(String title)
	{
		synchronized (deck)
		{
			deck.replaceCard(title);
		}
	}

	public void shuffle()
	{
		synchronized (deck)
		{
			deck.shuffle();
		}
	}

	public EncounterCard takeCard(String title)
	{
		synchronized (deck)
		{
			return deck.takeCard(title);
		}
	}

	public SynchronizedDeckBean(DeckBeanLocal deck)
	{
		synchronized (deck)
		{
			this.deck = deck;
		}
	}

	@Override
	public boolean equals(Object o)
	{
		if (o instanceof SynchronizedDeckBean)
		{
			if (((SynchronizedDeckBean) o).deck == deck)
				return true;
		}
		else if (o instanceof DeckBeanLocal)
		{
			if (o.equals(deck))
				return true;
		}

		return false;
	}
}
