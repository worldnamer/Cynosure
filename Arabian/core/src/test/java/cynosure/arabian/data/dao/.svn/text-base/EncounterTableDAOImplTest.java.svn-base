package cynosure.arabian.data.dao;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.util.List;

import org.junit.Test;

import cynosure.arabian.data.*;

public class EncounterTableDAOImplTest
{
	@Test
	public void getTableByTitle() {
		StringReader rd = new StringReader("{\"title\":\"1\",\"options\":[{\"adjective\":\"Rock\",\"description\":\"Slide\",\"reactionMatrix\":\"F\"},{\"adjective\":\"Rock\",\"description\":\"Slide\",\"reactionMatrix\":\"F\"},{\"adjective\":\"Bloodthirsty\",\"description\":\"Brigands\",\"reactionMatrix\":\"I\"},{\"adjective\":\"Lonely\",\"description\":\"Prince\",\"reactionMatrix\":\"A\"},{\"adjective\":\"Mystic\",\"description\":\"Fire\",\"reactionMatrix\":\"F\"},{\"adjective\":\"Minor\",\"description\":\"Treasure\",\"reactionMatrix\":\"E\"},{\"adjective\":\"Strange\",\"description\":\"Artifact\",\"reactionMatrix\":\"E\"},{\"adjective\":\"Terrible\",\"description\":\"Storm\",\"reactionMatrix\":\"F\"},{\"adjective\":\"Terrible\",\"description\":\"Storm\",\"reactionMatrix\":\"F\"},{\"adjective\":\"Ghostly\",\"description\":\"Beast\",\"reactionMatrix\":\"J\"},{\"adjective\":\"Ghostly\",\"description\":\"Beast\",\"reactionMatrix\":\"J\"},{\"adjective\":\"All-Powerful\",\"description\":\"'Efreet\",\"reactionMatrix\":\"M\"}]}");
		EncounterTableDAO dao = new EncounterTableDAOImpl(rd);
		
		EncounterTable table = dao.getTable("1"); 
		assertNotNull(table);
		assertEquals("1", table.getTitle());
	}

	@Test
	public void tables() {
		StringReader rd = new StringReader(
			"{\"title\":\"SAMARKAND\",\"type\":\"CITY\",\"options\":[{\"type\":\"only\",\"value\":\"81\"}]}\n" +
			"{\"title\":\"TIMBUKTU\",\"type\":\"CITY\",\"options\":[{\"type\":\"only\",\"value\":\"77\"}]}"
		);
		EncounterTableDAO dao = new EncounterTableDAOImpl(rd);
		
		List<EncounterTable> tables = dao.getTables(); 
		assertNotNull(tables);
		assertEquals(2, tables.size());
	}
}
