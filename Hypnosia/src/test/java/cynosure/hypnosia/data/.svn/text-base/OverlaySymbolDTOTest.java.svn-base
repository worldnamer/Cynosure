package cynosure.hypnosia.data;

import org.junit.*;
import static org.junit.Assert.*;

public class OverlaySymbolDTOTest 
{
	private OverlaySymbolDTO m_dtoSymbol;
	
	@Before
	public void setUp()
	{
		m_dtoSymbol = new OverlaySymbolDTO();
	}
	
	@Test
	public void constructor()
	{
		assertNotNull(m_dtoSymbol);
	}
	
	@Test
	public void getImageFileIsInitiallyNull()
	{
		assertNull(m_dtoSymbol.getImageFile());
	}
	
	@Test
	public void setImageFile()
	{
		String sImageFile = "test_image.png";
		m_dtoSymbol.setImageFile(sImageFile);
		
		assertEquals(sImageFile, m_dtoSymbol.getImageFile());
	}
	
	@Test
	public void intialIdIsZero()
	{
		assertEquals(0, m_dtoSymbol.getId());
	}
	
	@Test
	public void setId()
	{
		m_dtoSymbol.setId(10);
		
		assertEquals(10, m_dtoSymbol.getId());
	}
}
