package cynosure.arabian.data;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class ReactionMatrixTest
{
	private ReactionMatrix matrix;
	
	@Before
	public void before() {
		matrix = new ReactionMatrix();
	}
	
	@Test
	public void title() {
		String title = UUID.randomUUID().toString();
		matrix.setTitle(title);
		
		assertEquals(title, matrix.getTitle());
	}
	
	@Test
	public void headings() {
		String[] headings = new String [] {"Grovel", "Aid", "Avoid", "Bargain", "Attack", "Trick", "Hire"};
		matrix.setHeadings(headings);
		
		assertTrue(Arrays.equals(headings, matrix.getHeadings()));
	}
	
	@Test
	public void reaction() {
		String[] beautiful =      new String [] {"330", "2393", "1419", "845", "1655", "1468", "445"};
		String[] bloodthirsty =   new String [] {"344", "354", "1422", "281", "427", "343", "341"};
		String[] cold =           new String [] {"347", "354", "2344", "394", "418", "414", "447"};
		String[] crafty =         new String [] {"1465", "358", "381", "392", "529", "1411", "2321"};
		String[] mad =            new String [] {"338", "353", "515", "2201", "550", "2390", "341"};
		String[] mighty =         new String [] {"2376", "1638", "721", "280", "1432", "1445", "1649"};
		String[] practicalJoker = new String [] {"338", "2362", "382", "2364", "2367", "2370", "2373"};
		
		String[][] tales = new String[][] { beautiful, bloodthirsty, cold, crafty, mad, mighty, practicalJoker };
		matrix.setTales(tales);
		
		assertTrue(Arrays.deepEquals(tales, matrix.getTales()));
	}
	
	@Test
	public void adjectives() {
		String[] adjectives = new String [] {"Beautiful", "Bloodthirsty", "Cold", "Crafty", "Mad", "Mighty", "Practical Joker"};
		matrix.setAdjectives(adjectives);
		
		assertTrue(Arrays.equals(adjectives, matrix.getAdjectives()));		
	}
	
	@Test
	public void talesByAdjective() {
		String[] adjectives = new String [] {"Beautiful", "Bloodthirsty", "Cold", "Crafty", "Mad", "Mighty", "Practical Joker"};
		matrix.setAdjectives(adjectives);
		
		String[] beautiful =      new String [] {"330", "2393", "1419", "845", "1655", "1468", "445"};
		String[] bloodthirsty =   new String [] {"344", "354", "1422", "281", "427", "343", "341"};
		String[] cold =           new String [] {"347", "354", "2344", "394", "418", "414", "447"};
		String[] crafty =         new String [] {"1465", "358", "381", "392", "529", "1411", "2321"};
		String[] mad =            new String [] {"338", "353", "515", "2201", "550", "2390", "341"};
		String[] mighty =         new String [] {"2376", "1638", "721", "280", "1432", "1445", "1649"};
		String[] practicalJoker = new String [] {"338", "2362", "382", "2364", "2367", "2370", "2373"};
		
		String[][] tales = new String[][] { beautiful, bloodthirsty, cold, crafty, mad, mighty, practicalJoker };
		matrix.setTales(tales);

		assertTrue(Arrays.deepEquals(bloodthirsty, matrix.getTales("Bloodthirsty")));
	}
	
	@Test
	public void talesByAdjectiveCaseInsensitive() {
		String[] adjectives = new String [] {"Beautiful", "Bloodthirsty", "Cold", "Crafty", "Mad", "Mighty", "Practical Joker"};
		matrix.setAdjectives(adjectives);
		
		String[] beautiful =      new String [] {"330", "2393", "1419", "845", "1655", "1468", "445"};
		String[] bloodthirsty =   new String [] {"344", "354", "1422", "281", "427", "343", "341"};
		String[] cold =           new String [] {"347", "354", "2344", "394", "418", "414", "447"};
		String[] crafty =         new String [] {"1465", "358", "381", "392", "529", "1411", "2321"};
		String[] mad =            new String [] {"338", "353", "515", "2201", "550", "2390", "341"};
		String[] mighty =         new String [] {"2376", "1638", "721", "280", "1432", "1445", "1649"};
		String[] practicalJoker = new String [] {"338", "2362", "382", "2364", "2367", "2370", "2373"};
		
		String[][] tales = new String[][] { beautiful, bloodthirsty, cold, crafty, mad, mighty, practicalJoker };
		matrix.setTales(tales);

		assertTrue(Arrays.deepEquals(bloodthirsty, matrix.getTales("BLOODTHIRSTY")));
	}

	@Test
	public void stringConversion() {
		String[] adjectives = new String [] {"Beautiful", "Bloodthirsty", "Cold", "Crafty", "Mad", "Mighty", "Practical Joker"};
		matrix.setAdjectives(adjectives);
		
		String[] beautiful =      new String [] {"330", "2393", "1419", "845", "1655", "1468", "445"};
		String[] bloodthirsty =   new String [] {"344", "354", "1422", "281", "427", "343", "341"};
		String[] cold =           new String [] {"347", "354", "2344", "394", "418", "414", "447"};
		String[] crafty =         new String [] {"1465", "358", "381", "392", "529", "1411", "2321"};
		String[] mad =            new String [] {"338", "353", "515", "2201", "550", "2390", "341"};
		String[] mighty =         new String [] {"2376", "1638", "721", "280", "1432", "1445", "1649"};
		String[] practicalJoker = new String [] {"338", "2362", "382", "2364", "2367", "2370", "2373"};
		
		String[][] reactions = new String[][] { beautiful, bloodthirsty, cold, crafty, mad, mighty, practicalJoker };
		matrix.setTales(reactions);
		
		matrix.setTitle("O");

		assertEquals("{\"title\":\"O\",\"adjectives\":[\"Beautiful\",\"Bloodthirsty\",\"Cold\",\"Crafty\",\"Mad\",\"Mighty\",\"Practical Joker\"],\"tales\":[[\"330\",\"2393\",\"1419\",\"845\",\"1655\",\"1468\",\"445\"],[\"344\",\"354\",\"1422\",\"281\",\"427\",\"343\",\"341\"],[\"347\",\"354\",\"2344\",\"394\",\"418\",\"414\",\"447\"],[\"1465\",\"358\",\"381\",\"392\",\"529\",\"1411\",\"2321\"],[\"338\",\"353\",\"515\",\"2201\",\"550\",\"2390\",\"341\"],[\"2376\",\"1638\",\"721\",\"280\",\"1432\",\"1445\",\"1649\"],[\"338\",\"2362\",\"382\",\"2364\",\"2367\",\"2370\",\"2373\"]]}", matrix.toString());
	}
}
