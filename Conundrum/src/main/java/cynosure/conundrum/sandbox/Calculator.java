package cynosure.conundrum.sandbox;

public class Calculator
{
    public int add(int a, int b)
    {
    	return a + b;
    }

	public double divide(int a, int b) throws ArithmeticException 
	{
		if (b == 0)
			throw new ArithmeticException("Divide by Zero");
		else
			
		return (double)a/(double)b;
	}
}
