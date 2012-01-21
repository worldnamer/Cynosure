package cynosure.arabian.data.dao;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.util.List;

import org.junit.Test;

import cynosure.arabian.data.*;

public class EncounterCardDAOImplTest
{
	@Test
	public void getCardByTitle() {
		StringReader rd = new StringReader("{\"title\":\"SAMARKAND\",\"type\":\"CITY\",\"options\":[{\"type\":\"only\",\"value\":\"81\"}]}");
		EncounterCardDAO dao = new EncounterCardDAOImpl(rd);
		
		EncounterCard card = dao.getCard("SAMARKAND"); 
		assertNotNull(card);
		assertEquals("SAMARKAND", card.getTitle());
	}

	@Test
	public void getCardCaseInsensitive() {
		StringReader rd = new StringReader("{\"title\":\"SAMARKAND\",\"type\":\"CITY\",\"options\":[{\"type\":\"only\",\"value\":\"81\"}]}");
		EncounterCardDAO dao = new EncounterCardDAOImpl(rd);
		
		EncounterCard card = dao.getCard("samarkand"); 
		assertNotNull(card);
		assertEquals("SAMARKAND", card.getTitle());
	}
	
	@Test
	public void getMissingCardYieldsNull() {
		EncounterCardDAO dao = new EncounterCardDAOImpl(new StringReader("{\"title\":\"1\",\"options\":[{\"adjective\":\"Rock\",\"description\":\"Slide\",\"reactionMatrix\":\"F\"},{\"adjective\":\"Rock\",\"description\":\"Slide\",\"reactionMatrix\":\"F\"},{\"adjective\":\"Bloodthirsty\",\"description\":\"Brigands\",\"reactionMatrix\":\"I\"},{\"adjective\":\"Lonely\",\"description\":\"Prince\",\"reactionMatrix\":\"A\"},{\"adjective\":\"Mystic\",\"description\":\"Fire\",\"reactionMatrix\":\"F\"},{\"adjective\":\"Minor\",\"description\":\"Treasure\",\"reactionMatrix\":\"E\"},{\"adjective\":\"Strange\",\"description\":\"Artifact\",\"reactionMatrix\":\"E\"},{\"adjective\":\"Terrible\",\"description\":\"Storm\",\"reactionMatrix\":\"F\"},{\"adjective\":\"Terrible\",\"description\":\"Storm\",\"reactionMatrix\":\"F\"},{\"adjective\":\"Ghostly\",\"description\":\"Beast\",\"reactionMatrix\":\"J\"},{\"adjective\":\"Ghostly\",\"description\":\"Beast\",\"reactionMatrix\":\"J\"},{\"adjective\":\"All-Powerful\",\"description\":\"'Efreet\",\"reactionMatrix\":\"M\"}]}"));
		
		EncounterCard card = dao.getCard("samarkand"); 
		assertEquals(null, card);
	}
	
	@Test
	public void nullReaderIsOkay() {
		EncounterCardDAO dao = new EncounterCardDAOImpl(null);
		
		EncounterCard card = dao.getCard("samarkand"); 
		assertEquals(null, card);
	}
	
	@Test
	public void cards() {
		StringReader rd = new StringReader(
			"{\"title\":\"SAMARKAND\",\"type\":\"CITY\",\"options\":[{\"type\":\"only\",\"value\":\"81\"}]}\n" +
			"{\"title\":\"TIMBUKTU\",\"type\":\"CITY\",\"options\":[{\"type\":\"only\",\"value\":\"77\"}]}"
		);
		EncounterCardDAO dao = new EncounterCardDAOImpl(rd);
		
		List<EncounterCard> cards = dao.getCards(); 
		assertNotNull(cards);
		assertEquals(2, cards.size());
	}
}
