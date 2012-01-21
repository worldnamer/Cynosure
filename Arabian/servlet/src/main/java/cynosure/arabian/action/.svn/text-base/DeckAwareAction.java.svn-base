package cynosure.arabian.action;

import java.util.Map;

import javax.naming.*;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import cynosure.arabian.ejbs.DeckBeanLocal;

public class DeckAwareAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = -4964009074707965845L;
	private DeckBeanLocal deckBean;

	public String execute()
	{
		return SUCCESS;
	}
	
	public DeckBeanLocal getDeck()
	{
		return deckBean;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		if (!session.containsKey("deckBean"))
		{
			try
			{
				InitialContext ctx = new InitialContext();
				deckBean = new SynchronizedDeckBean((DeckBeanLocal) ctx.lookup("ear-1.0-SNAPSHOT/DeckBean/local"));
				session.put("deckBean", deckBean);
			}
			catch (NamingException ex)
			{
				ex.printStackTrace();
			}
		}
		else
		{
			deckBean = (DeckBeanLocal) session.get("deckBean");
		}
	}
}
