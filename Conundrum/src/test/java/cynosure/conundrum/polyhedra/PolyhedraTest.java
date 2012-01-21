package cynosure.conundrum.polyhedra;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class PolyhedraTest
{
	private Polyhedron m_poly;

	@Before
	public void setUp()
	{
		m_poly = new Polyhedron();
	}

	@Test
	public void constructor()
	{
		assertNotNull(m_poly);
	}
}
