package cynosure.arabian.ejbs;

import java.io.InputStreamReader;
import java.util.List;

import javax.ejb.Stateless;

import cynosure.arabian.data.*;
import cynosure.arabian.data.dao.*;

@Stateless
public class EncounterTableBean implements EncounterTableLocal
{
	private EncounterTableDAO dao;

	public void createDAO() {
		InputStreamReader in = new InputStreamReader(EncounterCardsBean.class.getResourceAsStream("/encounterTables.txt"));

		dao = new EncounterTableDAOImpl(in); 
	}

	@Override
	public List<EncounterTable> getTables()
	{
		if (dao == null) {
			createDAO();
		}

		return dao.getTables();
	}
	
	public EncounterTable getTable(String title)
	{
		if (dao == null) {
			createDAO();
		}
		
		EncounterTable table = dao.getTable(title);
		
		if (table != null) {
			return table;
		}
		
		return null;
	}

	public void setDAO(EncounterTableDAO dao)
	{
		this.dao = dao;
	}
}
