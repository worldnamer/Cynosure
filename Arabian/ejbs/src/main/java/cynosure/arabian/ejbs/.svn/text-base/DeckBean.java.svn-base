package cynosure.arabian.ejbs;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.ejb.*;

import cynosure.arabian.business.*;
import cynosure.arabian.data.EncounterCard;

@Stateful
public class DeckBean implements DeckBeanLocal
{
	@EJB 
	private EncounterCardsLocal cardsBean;
	private Deck deck;
	private List<EncounterCard> takenCards = new ArrayList<EncounterCard>();
	
	public void setEncounterCardsBean(EncounterCardsLocal cardsBean)
	{
		this.cardsBean = cardsBean;
	}

	@PostConstruct
	public void postConstruct()
	{
		deck = new DeckImpl();
		deck.setCards(cardsBean.getCards());
	}
	
	protected void setDeck(Deck deck) 
	{
		this.deck = deck;
	}

	public Deck getDeck()
	{
		return deck;
	}

	public EncounterCard getCard()
	{
		return deck.getCard();
	}
	
	public void shuffle()
	{
		deck.shuffle();
	}

	public EncounterCard takeCard(String title)
	{
		EncounterCard card = deck.takeCard(title);

		takenCards.add(card);
		
		return card;
	}

	public void replaceCard(String title)
	{
		for (EncounterCard card : takenCards)
			if (card.getTitle().equals(title))
			{
				deck.replaceCard(card);
				takenCards.remove(card);
				break;
			}
	}

	public List<EncounterCard> getTakenCards()
	{
		return takenCards;
	}
}
