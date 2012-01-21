package cynosure.conundrum.polyhedra;

import java.util.Random;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class SpaceVectorTest {

	static double epsilon = 0.001;

	private SpaceVector m_vect;
	private SpaceVector m_zero;

	@Before
	public void setUp()
	{
		m_vect = new SpaceVector();
		m_zero = new SpaceVector(0.0, 0.0, 0.0);
	}

	@Test
	public void constructor()
	{
		assertNotNull(m_vect);
	}

	@Test
	public void constructZeroVector()
	{
		assertEquals(0.0, m_zero.xComponent(), epsilon);
		assertEquals(0.0, m_zero.yComponent(), epsilon);
		assertEquals(0.0, m_zero.zComponent(), epsilon);
	}

	@Test
	public void AddVector()
	{
		Random rnd = new Random();
		double ux = (double) rnd.nextInt();
		double uy = (double) rnd.nextInt();
		double uz = (double) rnd.nextInt();
		double vx = (double) rnd.nextInt();
		double vy = (double) rnd.nextInt();
		double vz = (double) rnd.nextInt();
		SpaceVector u = new SpaceVector(ux, uy, uz);
		SpaceVector v = new SpaceVector(vx, vy, vz);
		double sumx = ux + vx;
		double sumy = uy + vy;
		double sumz = uz + vz;
		u.add(v);
		assertEquals(sumx, u.xComponent(), epsilon);
		assertEquals(sumy, u.yComponent(), epsilon);
		assertEquals(sumz, u.zComponent(), epsilon);
	}

	@Test
	public void SubtractVectors()
	{
		Random rnd = new Random();
		double ux = (double) rnd.nextInt();
		double uy = (double) rnd.nextInt();
		double uz = (double) rnd.nextInt();
		double vx = (double) rnd.nextInt();
		double vy = (double) rnd.nextInt();
		double vz = (double) rnd.nextInt();
		SpaceVector u = new SpaceVector(ux, uy, uz);
		SpaceVector v = new SpaceVector(vx, vy, vz);
		SpaceVector difference = SpaceVector.subtract(u, v);
		assertEquals(ux - vx, difference.xComponent(), epsilon);
		assertEquals(uy - vy, difference.yComponent(), epsilon);
		assertEquals(uz - vz, difference.zComponent(), epsilon);
	}
}

