package cynosure.prolixity;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComplexometerTest
{
	@Test
	public void lowestComplexity() {
		Complexometer meter = new Complexometer();
		
		assertEquals(0, meter.measure("the"));
	}

	@Test
	public void basicComplexity() {
		Complexometer meter = new Complexometer();
		
		assertEquals(1, meter.measure("test"));
	}

	@Test
	public void advancedComplexity() {
		Complexometer meter = new Complexometer();
		
		assertEquals(3, meter.measure("powerful"));
	}
}
