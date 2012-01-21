package cynosure.arabian.data.dao;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.util.Arrays;

import org.junit.Test;

import cynosure.arabian.data.*;

public class ReactionMatrixDAOImplTest
{
	@Test
	public void getMatrixByTitle() {
		StringReader rd = new StringReader("{\"title\":\"O\",\"adjectives\":[\"Beautiful\",\"Bloodthirsty\",\"Cold\",\"Crafty\",\"Mad\",\"Mighty\",\"Practical Joker\"],\"headings\":[\"Grovel\",\"Aid\",\"Avoid\",\"Bargain\",\"Attack\",\"Trick\",\"Hire\"],\"tales\":[[\"330\",\"2393\",\"1419\",\"845\",\"1655\",\"1468\",\"445\"],[\"344\",\"354\",\"1422\",\"281\",\"427\",\"343\",\"341\"],[\"347\",\"354\",\"2344\",\"394\",\"418\",\"414\",\"447\"],[\"1465\",\"358\",\"381\",\"392\",\"529\",\"1411\",\"2321\"],[\"338\",\"353\",\"515\",\"2201\",\"550\",\"2390\",\"341\"],[\"2376\",\"1638\",\"721\",\"280\",\"1432\",\"1445\",\"1649\"],[\"338\",\"2362\",\"382\",\"2364\",\"2367\",\"2370\",\"2373\"]]}");
		ReactionMatrixDAO dao = new ReactionMatrixDAOImpl(rd);
		
		ReactionMatrix matrix = dao.getMatrix("O"); 
		assertNotNull(matrix);
		assertEquals("O", matrix.getTitle());
		assertTrue(Arrays.deepEquals(new String[] { "Grovel","Aid","Avoid","Bargain","Attack","Trick","Hire"}, matrix.getHeadings()));
	}
}
