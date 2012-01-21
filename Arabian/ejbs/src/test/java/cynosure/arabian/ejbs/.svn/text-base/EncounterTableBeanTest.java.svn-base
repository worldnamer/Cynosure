package cynosure.arabian.ejbs;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.jmock.*;
import org.junit.Test;

import cynosure.arabian.data.*;
import cynosure.arabian.data.dao.*;

public class EncounterTableBeanTest
{
	@Test
	public void getTable() {
		final String title = UUID.randomUUID().toString();
		
		final EncounterTable table = new EncounterTable();
		
		Mockery mockery = new Mockery();
		final EncounterTableDAO dao = mockery.mock(EncounterTableDAO.class);
		mockery.checking(new Expectations() {{
			oneOf(dao).getTable(title); will(returnValue(table));
		}});
		
		EncounterTableBean bean = new EncounterTableBean();
		bean.setDAO(dao);
		
		EncounterTable fromService = bean.getTable(title);
		
		assertEquals(table, fromService);
		mockery.assertIsSatisfied();
	}
}