package cynosure.hypnosia.data;

import java.util.*;

public class OverlaySymbolDAO 
{
	private List<OverlaySymbolDTO> m_listSymbols;
	
	public OverlaySymbolDAO()
	{
		m_listSymbols = new ArrayList<OverlaySymbolDTO>();
	}
	
	public List<OverlaySymbolDTO> findAll() 
	{
		return m_listSymbols;
	}

	public void save(OverlaySymbolDTO _dto) 
	{
		m_listSymbols.add(_dto);
	}

	public OverlaySymbolDTO findById(int _nId) 
	{
		for (OverlaySymbolDTO dto : m_listSymbols)
			if (dto.getId() == _nId)
				return dto;
		
		return null;
	}
}
