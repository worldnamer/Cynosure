package cynosure.conundrum.cryptogram;

import org.junit.*;

import static org.junit.Assert.*;

public class SymbolizerBaseTest 
{
	private SymbolizerBase m_sym;
	
	@Before
	public void setUp()
	{
		m_sym = new SymbolizerBase();
	}
	
	@Test
	public void constructor()
	{
		assertNotNull(m_sym);
	}

	@Test
	public void the()
	{
		assertEquals("012", m_sym.symbolize("the"));
	}
	
	@Test
	public void bee()
	{
		assertEquals("011", m_sym.symbolize("bee"));
	}
	
	@Test
	public void acta()
	{
		assertEquals("0120", m_sym.symbolize("acta"));
	}
	
	@Test
	public void agee()
	{
		assertEquals("0122", m_sym.symbolize("agee"));
	}
	
	@Test
	public void antidisestablishmentarianism()
	{
 		assertEquals("0123435652078359A6120B30135A", m_sym.symbolize("antidisestablishmentarianism"));
	}
	
	@Test
	public void absass()
	{
		assertEquals("012022", m_sym.symbolize("absass"));
	}
	
	@Test
	public void contraction()
	{
		assertEquals("012'3", m_sym.symbolize("don't"));
	}
	
	@Test
	@Ignore
	public void test1000000()
	{
		for (int i = 0; i < 1000000; i++)
		{
			m_sym.symbolize("abcdefgh");
		}
	}
}
