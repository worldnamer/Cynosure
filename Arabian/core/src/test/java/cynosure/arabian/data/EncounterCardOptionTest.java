package cynosure.arabian.data;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.*;

public class EncounterCardOptionTest
{
	@Test
	public void type() {
		EncounterCardOption option = new EncounterCardOption();
		
		String type = UUID.randomUUID().toString();
		option.setType(type);
		
		assertEquals(type, option.getType());
	}
	
	@Test
	public void value() {
		EncounterCardOption option = new EncounterCardOption();
		
		String value = UUID.randomUUID().toString();
		option.setValue(value);
		
		assertEquals(value, option.getValue());
	}
}
