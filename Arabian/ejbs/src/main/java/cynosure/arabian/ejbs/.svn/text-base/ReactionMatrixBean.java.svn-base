package cynosure.arabian.ejbs;

import java.io.InputStreamReader;

import javax.ejb.Stateless;

import cynosure.arabian.data.*;
import cynosure.arabian.data.dao.*;

@Stateless
public class ReactionMatrixBean implements ReactionMatrixLocal
{
	ReactionMatrixDAO dao;

	public void createDAO()
	{
		InputStreamReader in = new InputStreamReader(
				EncounterCardsBean.class.getResourceAsStream("/reactionMatricies.txt"));

		dao = new ReactionMatrixDAOImpl(in);
	}

	public void setDAO(ReactionMatrixDAO dao)
	{
		this.dao = dao;
	}

	@Override
	public ReactionMatrix getMatrix(String title)
	{
		if (dao == null)
		{
			createDAO();
		}

		return this.dao.getMatrix(title);
	}

	@Override
	public String getTale(String title, String adjective, String reaction)
	{
		if (dao == null)
		{
			createDAO();
		}

		ReactionMatrix matrix = this.dao.getMatrix(title);
		String[] headings = matrix.getHeadings();
		int i = 0;
		for (; i < headings.length; i++)
		{
			if (headings[i].equalsIgnoreCase(reaction))
			{
				break;
			}
		}

		String[] tales = matrix.getTales(adjective);
		
		if (i < tales.length)
			return tales[i];
		
		return null;
	}

	@Override
	public String[] getTales(String title, String adjective)
	{
		if (dao == null)
		{
			createDAO();
		}

		ReactionMatrix matrix = this.dao.getMatrix(title);
		return matrix.getTales(adjective);
	}
}
