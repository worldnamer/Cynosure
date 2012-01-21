package cynosure.hypnosia.data;

import org.junit.*;
import static org.junit.Assert.*;

public class GridDTOTest 
{
	private GridDTO m_grid;
	
	@Before
	public void setUp()
	{
		m_grid = new GridDTO();
	}
	
	@Test
	public void constructor()
	{
		assertNotNull(m_grid);
	}
	
	@Test
	public void cellSizeStartsAtZero()
	{
		assertEquals(0, m_grid.getCellSize());
	}
	
	@Test
	public void setCellSize()
	{
		m_grid.setCellSize(10);
		
		assertEquals(10, m_grid.getCellSize());
	}
	
	@Test
	public void imageFileStartsNull()
	{
		assertNull(m_grid.getImageFile());
	}
	
	@Test
	public void setImageFile()
	{
		m_grid.setImageFile("test.png");
		
		assertEquals("test.png", m_grid.getImageFile());
	}
	
	@Test
	public void getSquareMetadataReturnsNullIfNoGridSetUp()
	{
		assertNull(m_grid.getSquareMetadata(0, 0));
	}

	@Test
	public void getGridSizeAtStart()
	{
		assertEquals(0, m_grid.getGridWidth());
		assertEquals(0, m_grid.getGridHeight());
	}
	
	@Test
	public void setGridSize()
	{
		m_grid.setGridSize(5, 7);
		
		assertEquals(5, m_grid.getGridWidth());
		assertEquals(7, m_grid.getGridHeight());
	}
	
	@Test
	public void setSquareMetadata()
	{
		m_grid.setGridSize(4, 4);
		SquareMetadataDTO dto = new SquareMetadataDTO();
		m_grid.setSquareMetadata(3, 2, dto);
		
		assertEquals(dto, m_grid.getSquareMetadata(3, 2));
	}
	
	@Test
	public void setTwoSquaresMetadata()
	{
		m_grid.setGridSize(4, 4);
		SquareMetadataDTO dto1 = new SquareMetadataDTO();
		SquareMetadataDTO dto2 = new SquareMetadataDTO();
		m_grid.setSquareMetadata(3, 2, dto1);
		m_grid.setSquareMetadata(0, 0, dto2);
		
		assertEquals(dto1, m_grid.getSquareMetadata(3, 2));
	}
}
