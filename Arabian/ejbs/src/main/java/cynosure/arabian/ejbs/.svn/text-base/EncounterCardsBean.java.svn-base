package cynosure.arabian.ejbs;

import java.io.InputStreamReader;
import java.util.List;

import javax.ejb.Stateless;

import cynosure.arabian.data.EncounterCard;
import cynosure.arabian.data.dao.*;

@Stateless
public class EncounterCardsBean implements EncounterCardsLocal
{
	private EncounterCardDAO dao;
	
	public void createDAO() {
		InputStreamReader in = new InputStreamReader(EncounterCardsBean.class.getResourceAsStream("/encounterCards.txt"));

		dao = new EncounterCardDAOImpl(in); 
	}

	@Override
	public List<EncounterCard> getCards()
	{
		if (dao == null) {
			createDAO();
		}

		return dao.getCards();
	}
	
	@Override
	public EncounterCard getCard(String title)
	{
		// JWLL: Incidentally, this basically happens on every invocation. This is one of the first things I should fix.
		if (dao == null) {
			createDAO();
		}
		
		EncounterCard card = dao.getCard(title);
		
		if (card != null) {
			return card;
		}
		
		return null;
	}

	public void setDAO(EncounterCardDAO dao)
	{
		this.dao = dao;
	}
}
