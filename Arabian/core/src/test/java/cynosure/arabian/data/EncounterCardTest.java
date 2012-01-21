package cynosure.arabian.data;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class EncounterCardTest
{
	private EncounterCard card;
	
	@Before
	public void before() {
		card = new EncounterCard();
	}
	
	@Test
	public void title() {
		String title = UUID.randomUUID().toString();
		card.setTitle(title);
		
		assertEquals(title, card.getTitle());
	}
	
	@Test
	public void type() {
		String type = UUID.randomUUID().toString();
		card.setType(type);
		
		assertEquals(type, card.getType());
	}
	
	@Test
	public void optionsBeforeSetIsNotNull() {
		assertNotNull(card.getOptions());
	}
	
	@Test
	public void options() {
		EncounterCardOption option = new EncounterCardOption();
		
		card.setOptions(Arrays.asList(new EncounterCardOption[] { option }));
		
		assertEquals(1, card.getOptions().size());
		assertTrue(card.getOptions().contains(option));
	}
	
	@Test
	public void optionOrder() {
		EncounterCardOption morning = new EncounterCardOption();
		morning.setType("morning");
		morning.setValue("97");
		
		EncounterCardOption noon = new EncounterCardOption();
		noon.setType("noon");
		noon.setValue("92");
		
		EncounterCardOption night = new EncounterCardOption();
		night.setType("night");
		night.setValue("106");
		
		card.setOptions(Arrays.asList(new EncounterCardOption[] { morning, noon, night }));
		
		assertEquals(3, card.getOptions().size());
		assertEquals(morning, card.getOptions().get(0));
		assertEquals(noon, card.getOptions().get(1));
		assertEquals(night, card.getOptions().get(2));
	}
	
	@Test
	public void stringConversion() {
		EncounterCardOption morning = new EncounterCardOption();
		morning.setType("morning");
		morning.setValue("97");
		
		EncounterCardOption noon = new EncounterCardOption();
		noon.setType("noon");
		noon.setValue("92");
		
		EncounterCardOption night = new EncounterCardOption();
		night.setType("night");
		night.setValue("106");
		
		card.setOptions(Arrays.asList(new EncounterCardOption[] { morning, noon, night }));
		card.setTitle("THIEF");
		card.setType("CHARACTER");
		
		assertEquals("{\"title\":\"THIEF\",\"type\":\"CHARACTER\",\"options\":[{\"type\":\"morning\",\"value\":\"97\"},{\"type\":\"noon\",\"value\":\"92\"},{\"type\":\"night\",\"value\":\"106\"}]}", card.toString());
	}
}
