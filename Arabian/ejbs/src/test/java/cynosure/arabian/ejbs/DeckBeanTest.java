package cynosure.arabian.ejbs;

import static org.junit.Assert.*;

import java.util.*;

import org.jmock.*;
import org.junit.*;

import cynosure.arabian.business.*;
import cynosure.arabian.data.EncounterCard;

public class DeckBeanTest
{
	private Mockery mockery;
	private DeckBean bean;
	private EncounterCard card;
	private Deck deck;
	
	@Before
	public void before() 
	{
		card = new EncounterCard();
		card.setTitle(UUID.randomUUID().toString());
		
		final List<EncounterCard> cards = new ArrayList<EncounterCard>();
		cards.add(card);

		mockery = new Mockery();
		final EncounterCardsLocal cardsBean = mockery.mock(EncounterCardsLocal.class);
		mockery.checking(new Expectations() {{
			allowing(cardsBean).getCards(); will(returnValue(cards));
		}});
		
		deck = mockery.mock(Deck.class);

		bean = new DeckBean();
		bean.setEncounterCardsBean(cardsBean);
		bean.postConstruct();
	}

	@After
	public void after() 
	{
		mockery.assertIsSatisfied();
	}
	
	@Test
	public void deckIsNotNull() 
	{
		assertNotNull(bean.getDeck());
	}
	
	@Test
	public void deckIsSameBetweenCalls()
	{
		assertEquals(bean.getDeck(), bean.getDeck());
	}
	
	@Test
	public void deckGetCard()
	{
		mockery.checking(new Expectations() {{
			oneOf(deck).getCard(); will(returnValue(card));
		}});
		
		bean.setDeck(deck);
		assertEquals(card, bean.getCard());
	}

	@Test
	public void deckShuffle()
	{
		mockery.checking(new Expectations() {{
			oneOf(deck).shuffle();
		}});
		
		bean.setDeck(deck);
		bean.shuffle();
	}

	@Test
	public void deckTakeCard()
	{
		mockery.checking(new Expectations() {{
			oneOf(deck).takeCard(with(card.getTitle())); will(returnValue(card));
		}});
		
		bean.setDeck(deck);
		bean.takeCard(card.getTitle());
	}

	@Test
	public void takenCards()
	{
		mockery.checking(new Expectations() {{
			oneOf(deck).takeCard(with(card.getTitle())); will(returnValue(card));
		}});
		
		bean.setDeck(deck);
		bean.takeCard(card.getTitle());
		
		assertTrue(bean.getTakenCards().contains(card));
	}
	
	@Test
	public void replaceCard()
	{
		mockery.checking(new Expectations() {{
			oneOf(deck).takeCard(with(card.getTitle())); will(returnValue(card));
			oneOf(deck).replaceCard(with(card));
		}});
		
		bean.setDeck(deck);
		bean.takeCard(card.getTitle());
		
		bean.replaceCard(card.getTitle());
		
		assertTrue(bean.getTakenCards().isEmpty());
	}
}
