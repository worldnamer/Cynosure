package cynosure.arabian.data;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class EncounterTableTest
{
	private EncounterTable table;

	@Before
	public void before()
	{
		table = new EncounterTable();
	}

	@Test
	public void title()
	{
		String title = UUID.randomUUID().toString();
		table.setTitle(title);

		assertEquals(title, table.getTitle());
	}

	@Test
	public void startWithTweleveEntries()
	{
		assertEquals(12, table.getEntries().length);
	}

	@Test
	@Ignore
	public void entries()
	{
		EncounterTableOption option = new EncounterTableOption();
		EncounterTableOption[] options = new EncounterTableOption[]
		{
			option, option, option, option, option, option, option, option, option, option, option, option
		};
		table.setEntries(options); 
		assertTrue(Arrays.deepEquals(options, table.getEntries()));
	}

	private EncounterTableOption newOption(String adjective, String description, String reactionMatrix)
	{
		EncounterTableOption option = new EncounterTableOption();
		option.setAdjective(adjective);
		option.setDescription(description);
		option.setReactionMatrix(reactionMatrix);

		return option;
	}

	@Test
	public void stringConversion()
	{
		EncounterTableOption[] options = new EncounterTableOption[]
		{
			newOption("Rock", "Slide", "F"), newOption("Rock", "Slide", "F"),
			newOption("Bloodthirsty", "Brigands", "I"), newOption("Lonely", "Prince", "A"),
			newOption("Mystic", "Fire", "F"), newOption("Minor", "Treasure", "E"),
			newOption("Strange", "Artifact", "E"), newOption("Terrible", "Storm", "F"),
			newOption("Terrible", "Storm", "F"), newOption("Ghostly", "Beast", "J"),
			newOption("Ghostly", "Beast", "J"), newOption("All-Powerful", "'Efreet", "M")
		};

		table.setTitle("1");
		table.setEntries(options);

		assertEquals(
				"{\"title\":\"1\",\"entries\":[{\"adjective\":\"Rock\",\"description\":\"Slide\",\"reactionMatrix\":\"F\"},{\"adjective\":\"Rock\",\"description\":\"Slide\",\"reactionMatrix\":\"F\"},{\"adjective\":\"Bloodthirsty\",\"description\":\"Brigands\",\"reactionMatrix\":\"I\"},{\"adjective\":\"Lonely\",\"description\":\"Prince\",\"reactionMatrix\":\"A\"},{\"adjective\":\"Mystic\",\"description\":\"Fire\",\"reactionMatrix\":\"F\"},{\"adjective\":\"Minor\",\"description\":\"Treasure\",\"reactionMatrix\":\"E\"},{\"adjective\":\"Strange\",\"description\":\"Artifact\",\"reactionMatrix\":\"E\"},{\"adjective\":\"Terrible\",\"description\":\"Storm\",\"reactionMatrix\":\"F\"},{\"adjective\":\"Terrible\",\"description\":\"Storm\",\"reactionMatrix\":\"F\"},{\"adjective\":\"Ghostly\",\"description\":\"Beast\",\"reactionMatrix\":\"J\"},{\"adjective\":\"Ghostly\",\"description\":\"Beast\",\"reactionMatrix\":\"J\"},{\"adjective\":\"All-Powerful\",\"description\":\"\\u0027Efreet\",\"reactionMatrix\":\"M\"}]}",
				table.toString());
	}
}
