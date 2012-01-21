package cynosure.hypnosia.data;

import org.junit.*;
import static org.junit.Assert.*;

public class SquareMetadataDTOTest 
{
	private SquareMetadataDTO m_dto;
	
	@Before
	public void setUp()
	{
		m_dto = new SquareMetadataDTO();
	}
	
	@Test
	public void constructor()
	{
		assertNotNull(m_dto);
	}
	
	@Test
	public void overlaySymbolIsInitiallyNone()
	{
		assertEquals(null, m_dto.getOverlaySymbol());
	}
	
	@Test
	public void setOverlaySymbol()
	{
		OverlaySymbolDTO dtoSymbol = new OverlaySymbolDTO();
		m_dto.setOverlaySymbol(dtoSymbol);
		
		assertEquals(dtoSymbol, m_dto.getOverlaySymbol());
	}
}