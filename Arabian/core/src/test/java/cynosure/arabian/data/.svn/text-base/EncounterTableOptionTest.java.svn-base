package cynosure.arabian.data;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.*;

public class EncounterTableOptionTest
{
	private EncounterTableOption option;
	
	@Before
	public void before() {
		option = new EncounterTableOption();
	}
	
	@Test
	public void adjective() {
		String adjective = UUID.randomUUID().toString();
		option.setAdjective(adjective);
		
		assertEquals(adjective, option.getAdjective());
	}
	
	@Test
	public void description() {
		String description = UUID.randomUUID().toString();
		option.setDescription(description);
		
		assertEquals(description, option.getDescription());
	}
	
	@Test
	public void reactionMatrix() {
		String reactionMatrix = UUID.randomUUID().toString();
		option.setReactionMatrix(reactionMatrix);
		
		assertEquals(reactionMatrix, option.getReactionMatrix());
	}
}
