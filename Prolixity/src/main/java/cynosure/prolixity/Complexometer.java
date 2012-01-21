package cynosure.prolixity;

public class Complexometer
{
	public int measure(String string)
	{
		if (
			string.equals("the") ||
			string.equals("but") ||
			string.equals("not") ||
			string.equals("yet")
		   ) {
			return 0;
		}
		
		return (int)Math.round(string.length() / 3.00);
	}
}
