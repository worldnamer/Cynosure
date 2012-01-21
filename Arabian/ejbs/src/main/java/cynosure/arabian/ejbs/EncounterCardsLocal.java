package cynosure.arabian.ejbs;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.*;

import cynosure.arabian.data.EncounterCard;

@Local
@Path("/cards")
public interface EncounterCardsLocal
{
	@GET
	@Path("/")
	@Produces({"application/json", "application/xml"})
	List<EncounterCard> getCards();

	@GET
	@Path("/{title}")
	@Produces({"application/json", "application/xml"})
	EncounterCard getCard(@PathParam("title") String title);
}