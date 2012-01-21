package cynosure.arabian.business;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;


import cynosure.arabian.business.DeckImpl;
import cynosure.arabian.data.EncounterCard;

public class DeckImplTest
{
	private DeckImpl deck;
	private EncounterCard one, two;
	private List<EncounterCard> list;

	@Before
	public void before()
	{
		deck = new DeckImpl();
		
		one = new EncounterCard();
		one.setTitle("one");
		two = new EncounterCard();
		two.setTitle("two");
		list = new ArrayList<EncounterCard>();
		list.add(one);
		list.add(two);
	}

	@Test
	public void noCardsYieldsNull()
	{
		assertEquals(null, deck.getCard());
	}

	@Test
	public void setGetSingleCard()
	{
		EncounterCard card = new EncounterCard();
		deck.setCards(Arrays.asList(new EncounterCard[]
		{
			card
		}));

		assertEquals(card, deck.getCard());
	}

	@Test
	public void noCardDrawnTwice()
	{
		deck.setCards(list);

		EncounterCard card = deck.getCard();
		if (card == one)
			assertEquals(two, deck.getCard());
		else
			assertEquals(one, deck.getCard());
	}

	@Test
	public void deckRunsOut()
	{
		deck.setCards(list);

		deck.getCard();
		deck.getCard();

		assertEquals(null, deck.getCard());
	}

	@Test
	public void deckIsRandom()
	{
		deck.setCards(list);

		EncounterCard testOne = deck.getCard();
		EncounterCard testTwo = deck.getCard();

		boolean provedRandom = false;
		for (int i = 0; (i < 10) && (!provedRandom); i++)
		{
			deck = new DeckImpl();

			deck.setCards(list);

			if (testOne != deck.getCard()) if (testTwo != deck.getCard()) provedRandom = true;
		}

		assertTrue(provedRandom);
	}

	@Test
	public void shuffleIsSafe()
	{
		deck.shuffle();
	}

	@Test
	public void shuffleRecyclesCards()
	{
		deck.setCards(list);

		deck.getCard();
		deck.getCard();

		deck.shuffle();

		assertNotNull(deck.getCard());
	}

	@Test
	public void takeCard()
	{
		deck.setCards(list);
		
		deck.takeCard("one");
		
		assertEquals(two, deck.getCard());
		assertEquals(null, deck.getCard());
	}

	@Test
	public void shuffleAfterTake()
	{
		deck.setCards(list);
		
		deck.takeCard("one");
		
		deck.getCard();
		deck.getCard();
		
		deck.shuffle();

		assertEquals(two, deck.getCard());
		assertEquals(null, deck.getCard());
	}

	@Test
	public void replace()
	{
		deck.setCards(list);
		
		EncounterCard card = deck.takeCard("one");
		deck.replaceCard(card);
		
		assertEquals(two, deck.getCard());
	}

	@Test
	public void replaceAfterGet()
	{
		deck.setCards(list);
		
		EncounterCard card = deck.getCard();
		deck.replaceCard(card);
		
		if (card == one)
			assertEquals(two, deck.getCard());
		else
			assertEquals(one, deck.getCard());
	}
	
	@Test
	public void takeMultipleTimes()
	{
		deck.setCards(list);
		
		EncounterCard card = deck.takeCard("one");
		deck.replaceCard(card);
		deck.takeCard("one");
		deck.replaceCard(card);
		
		assertEquals(two, deck.getCard());
	}
}
