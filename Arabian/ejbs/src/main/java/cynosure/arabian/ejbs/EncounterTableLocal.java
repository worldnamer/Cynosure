package cynosure.arabian.ejbs;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.*;

import cynosure.arabian.data.EncounterTable;

@Local
@Path("/tables")
public interface EncounterTableLocal
{
	@GET
	@Path("/")
	@Produces({"application/json", "application/xml"})
	List<EncounterTable> getTables();

	@GET
	@Path("/{title}")
	@Produces({"application/json", "application/xml"})
	EncounterTable getTable(@PathParam("title") String title);
}