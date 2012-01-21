package cynosure.arabian.data.dao;

import java.util.List;

import cynosure.arabian.data.EncounterTable;

public interface EncounterTableDAO
{
	EncounterTable getTable(String string);

	List<EncounterTable> getTables();
}
