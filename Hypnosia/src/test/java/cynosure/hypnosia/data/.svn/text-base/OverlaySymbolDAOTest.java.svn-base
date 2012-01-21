package cynosure.hypnosia.data;

import java.util.List;

import org.junit.*;
import static org.junit.Assert.*;

public class OverlaySymbolDAOTest 
{
	@Test
	public void constructor()
	{
		OverlaySymbolDAO daoOverlay = new OverlaySymbolDAO();
		
		assertNotNull(daoOverlay);
	}

	@Test
	public void findAllInitiallyReturnsEmpty()
	{
		OverlaySymbolDAO daoOverlay = new OverlaySymbolDAO();
		
		List<OverlaySymbolDTO> listSymbols = daoOverlay.findAll();
		
		assertNotNull(listSymbols);
		assertEquals(0, listSymbols.size());
	}

	@Test
	public void findAllReturnsAResult()
	{
		OverlaySymbolDAO daoOverlay = new OverlaySymbolDAO();
		OverlaySymbolDTO dto = new OverlaySymbolDTO();
		daoOverlay.save(dto);
		
		List<OverlaySymbolDTO> listSymbols = daoOverlay.findAll();
		
		assertNotNull(listSymbols);
		assertEquals(1, listSymbols.size());
		assertTrue(listSymbols.contains(dto));
	}

	@Test
	public void findAllReturnsTwoResults()
	{
		OverlaySymbolDAO daoOverlay = new OverlaySymbolDAO();
		OverlaySymbolDTO dto1 = new OverlaySymbolDTO();
		OverlaySymbolDTO dto2 = new OverlaySymbolDTO();
		daoOverlay.save(dto1);
		daoOverlay.save(dto2);
		
		List<OverlaySymbolDTO> listSymbols = daoOverlay.findAll();
		
		assertNotNull(listSymbols);
		assertEquals(2, listSymbols.size());
		assertTrue(listSymbols.contains(dto1));
		assertTrue(listSymbols.contains(dto2));
	}
	
	@Test
	public void findByIdReturnsNoResult()
	{
		OverlaySymbolDAO daoOverlay = new OverlaySymbolDAO();
		
		OverlaySymbolDTO dtoFound = daoOverlay.findById(3);
		
		assertNull(dtoFound);
	}
	
	@Test
	public void findByIdReturnsOneResult()
	{
		OverlaySymbolDAO daoOverlay = new OverlaySymbolDAO();
		OverlaySymbolDTO dto1 = new OverlaySymbolDTO();
		dto1.setId(3);
		OverlaySymbolDTO dto2 = new OverlaySymbolDTO();
		dto2.setId(7);
		daoOverlay.save(dto1);
		daoOverlay.save(dto2);
		
		OverlaySymbolDTO dtoFound = daoOverlay.findById(3);
		assertEquals(dto1, dtoFound);
	}
}
