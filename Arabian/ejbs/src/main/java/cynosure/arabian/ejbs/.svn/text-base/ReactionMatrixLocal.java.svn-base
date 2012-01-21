package cynosure.arabian.ejbs;

import javax.ejb.Local;
import javax.ws.rs.*;

import cynosure.arabian.data.ReactionMatrix;

@Local
@Path("/reactionMatricies")
public interface ReactionMatrixLocal
{
	@GET
	@Path("/{title}")
	@Produces(
	{
		"application/json", "application/xml"
	})
	ReactionMatrix getMatrix(@PathParam("title") String title);

	@GET
	@Path("/{title}/{adjective}/{reaction}")
	@Produces(
	{
		"application/json", "application/xml"
	})
	String getTale(@PathParam("title") String title, @PathParam("adjective") String adjective,
			@PathParam("reaction") String reaction);
	
	@GET
	@Path("/{title}/{adjective}")
	@Produces(
	{
		"application/json", "application/xml"
	})
	String[] getTales(@PathParam("title") String title, @PathParam("adjective") String adjective);
}