package cynosure.arabian.action;

import java.util.UUID;

import org.jmock.*;
import org.junit.*;

import cynosure.arabian.ejbs.DeckBeanLocal;

public class SynchronizedDeckBeanTest
{
	private Mockery mockery;
	private DeckBeanLocal deck;
	private DeckBeanLocal deckWrapper;
	
	@Before
	public void before() {
		mockery = new Mockery();
		deck = mockery.mock(DeckBeanLocal.class);

		deckWrapper = new SynchronizedDeckBean(deck);
	}
	
	@After
	public void after() {
		mockery.assertIsSatisfied();
	}
	
	@Test
	public void takeCard() {
		final String title = UUID.randomUUID().toString();
		
		mockery.checking(new Expectations() {{
			oneOf(deck).takeCard(with(title)); will(returnValue(null));
		}});
		
		deckWrapper.takeCard(title);
	}
}
