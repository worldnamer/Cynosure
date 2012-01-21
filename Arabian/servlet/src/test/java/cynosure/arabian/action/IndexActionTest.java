package cynosure.arabian.action;

import static org.junit.Assert.*;

import java.util.*;

import javax.naming.*;

import org.jmock.Mockery;
import org.junit.*;

import cynosure.arabian.ejbs.DeckBeanLocal;

public class IndexActionTest
{
	private Mockery mockery;
	private DeckBeanLocal deckBean;
	private IndexAction action;
	
	@Before
	public void before()
	{
		mockery = new Mockery();
		deckBean = mockery.mock(DeckBeanLocal.class);
		action = new IndexAction();
	}
	
	@After
	public void after()
	{
		mockery.assertIsSatisfied();
	}
	
	@Test
	public void execute()
	{
		assertEquals("success", action.execute());
	}

	@Test
	public void setSessionWithoutBean()
	{
		try
		{
			SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
			builder.bind("ear-1.0-SNAPSHOT/DeckBean/local", deckBean);
			builder.activate();

			Map<String, Object> session = new HashMap<String, Object>();
			action.setSession(session);
			
			assertTrue(action.getDeck().equals(deckBean));
			assertTrue(session.get("deckBean").equals(deckBean));
			
			mockery.assertIsSatisfied();
		}
		catch (NamingException ex)
		{
			fail("Caught a naming exception. [" + ex + "]");
		}
	}
	
	@Test
	public void setSessionWithBean()
	{
		Map<String, Object> session = new HashMap<String, Object>();
		session.put("deckBean", deckBean);

		action.setSession(session);
		
		assertEquals(deckBean, action.getDeck());
		
		mockery.assertIsSatisfied();
	}
}
