package cynosure.conundrum.sandbox;

import java.util.Random;

import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTest 
{
	private Calculator m_calc;
	
	@Before
	public void setUp()
	{
		m_calc = new Calculator();
	}
	
	@Test
	public void constructor()
	{
		assertNotNull(m_calc);
	}
	
	@Test
	public void addTwoNumbers()
	{
		assertEquals(3, m_calc.add(1, 2));
	}

	@Test
	public void addTwoRandomNumbers()
	{
		Random rnd = new Random();
		int a = rnd.nextInt();
		int b = rnd.nextInt();
		assertEquals(a + b, m_calc.add(a, b));
	}
	
	@Test
	public void divideTwoNumbers() throws Exception
	{
		assertEquals(0.5, m_calc.divide(1, 2), 0.000001);
	}
	
	@Test
	public void divideTwoRandomNumbers() throws Exception
	{
		Random rnd = new Random();
		int a = rnd.nextInt();
		int b = rnd.nextInt();
		
		assertEquals((double)a / (double)b, m_calc.divide(a, b), 0.000001);
	}
	
	@Test(expected=ArithmeticException.class)
	public void divideByZero() throws Exception
	{
		m_calc.divide(1, 0);
	}
}
