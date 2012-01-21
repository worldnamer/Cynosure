package cynosure.hypnosia.data;

public class GridDTO 
{
	private int m_nCellSize;
	private String m_sImageFile;
	private SquareMetadataDTO m_aSquares[][];
	
	public int getCellSize() 
	{
		return m_nCellSize;
	}

	public void setCellSize(int _nCellSize) 
	{
		m_nCellSize = _nCellSize;
	}

	public String getImageFile() 
	{
		return m_sImageFile;
	}

	public void setImageFile(String _sImageFile) 
	{
		m_sImageFile = _sImageFile;
	}

	public SquareMetadataDTO getSquareMetadata(int _nX, int _nY) 
	{
		if (m_aSquares == null)
			return null;
		
		return m_aSquares[_nX][_nY];
	}

	public void setSquareMetadata(int _nX, int _nY, SquareMetadataDTO _dtoSquare) 
	{
		if ((m_aSquares != null) && (_nX < m_aSquares.length) && (_nY < m_aSquares[0].length))
			m_aSquares[_nX][_nY] = _dtoSquare;
	}

	public void setGridSize(int _nWidth, int _nHeight) 
	{
		m_aSquares = new SquareMetadataDTO[_nWidth][_nHeight];
	}

	public int getGridWidth() 
	{
		if (m_aSquares != null)
			return m_aSquares.length;
		else
			return 0;
	}

	public int getGridHeight() 
	{
		if (m_aSquares != null)
			return m_aSquares[0].length;
		else
			return 0;
	}
}
