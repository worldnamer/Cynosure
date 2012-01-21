package cynosure.arabian.ejbs;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.jmock.*;
import org.junit.Test;

import cynosure.arabian.data.EncounterCard;
import cynosure.arabian.data.dao.EncounterCardDAO;

public class EncounterCardsBeanTest
{
	@Test
	public void getCard() {
		final String title = UUID.randomUUID().toString();
		
		final EncounterCard card = new EncounterCard();
		
		Mockery mockery = new Mockery();
		final EncounterCardDAO dao = mockery.mock(EncounterCardDAO.class);
		mockery.checking(new Expectations() {{
			oneOf(dao).getCard(title); will(returnValue(card));
		}});
		
		EncounterCardsBean bean = new EncounterCardsBean();
		bean.setDAO(dao);
		
		EncounterCard fromService = bean.getCard(title);
		
		assertEquals(card, fromService);
		mockery.assertIsSatisfied();
	}
}