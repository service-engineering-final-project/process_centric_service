package introsde.process.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

import introsde.process.rest.model.Goal;
import introsde.process.rest.model.Measurement;
import introsde.process.rest.model.Person;
import introsde.process.rest.model.MeasurementHistory;


/***
 * The resource class that implements our service endpoints for the Person.
 * 
 * @author alan
 *
 */

//@Stateless
//@LocalBean
@Path("/person")
public class PersonResource {
	@Context UriInfo uriInfo;	// allows to insert contextual objects (uriInfo) into the class
	@Context Request request;	// allows to insert contextual objects (request) into the class
	
	DocumentBuilder docBuilder;
	WebTarget webTarget;
	ObjectMapper mapper = new ObjectMapper();
	
	// Definition of some useful constants
	final String baseUrl = "http://storage-data-service-ar.herokuapp.com/rest/person";
	
	public PersonResource() {
		try {
			docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		webTarget = ClientBuilder.newClient(
				new ClientConfig()).target(UriBuilder.fromUri(baseUrl).build()
		);
	}
	
	/***
	 * A method that lists all the people in the database.
	 * @return all the people in the database
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getPeopleList() {
		try {
			return getResponse(webTarget, MediaType.APPLICATION_JSON);
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that gives all the information of a person identified by {id}.
	 * @param id: the identifier
	 * @return the person identified by {id}
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}")
	public Response getPerson(@PathParam("id") Long id) {
		WebTarget pathTarget = webTarget.path(id.toString());
		
		try {
			return getResponse(pathTarget, MediaType.APPLICATION_JSON);
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that updates the information of a person identified by {id}
	 * (i.e. only the person's information, not the measures of the health profile).
	 * @param p: the person to update
	 * @param id: the identifier of the person to update
	 * @return the person updated
	 */
	@PUT
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}")
	public Response updatePerson(Person p, @PathParam("id") Long id) {
		WebTarget pathTarget = webTarget.path(id.toString());
		
		try {
			return putResponse(pathTarget, p, MediaType.APPLICATION_JSON);
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that creates a new person and returns it with its assigned id
	 * (i.e. if a health profile is included, also its measurements will be created).
	 * @param p: the person to create
	 * @return the person created
	 */
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response createPerson(Person p) {
		try {
			return postResponse(webTarget, p, MediaType.APPLICATION_JSON);
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that deletes the person identified by {id} from the system.
	 * @param id: the identifier of the person to delete
	 */
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}")
	public Response deletePerson(@PathParam("id") Long id) {
		WebTarget pathTarget = webTarget.path(id.toString());
		
		try {
			return pathTarget.request().delete();
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that returns the list of values (the history) of {measureType}
	 * (e.g. weight) for a person identified by {id}.
	 * @param id: the identifier of the person
	 * @param measureType: the measure of interest
	 * @return the list of all the measurements of a particular measure relative to a person
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/{measure_type}")
	public Response readPersonHistory(
			@PathParam("id") Long id,
			@PathParam("measure_type") String measureType
	) {
		WebTarget pathTarget = webTarget.path(id.toString()).path(measureType);
		
		try {
			return getResponse(pathTarget, MediaType.APPLICATION_JSON);
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that returns the value of {measureType} (e.g. weight)
	 * identified by {mid} for a person identified by {id}.
	 * @param id: the identifier of the person
	 * @param measureType: the measure of interest
	 * @param mid: the measure identifier
	 * @return the value of the measure with a particular identifier relative to a person
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/{measure_type}/{mid}")
	public Response readPersonMeasure(
			@PathParam("id") Long id,
			@PathParam("measure_type") String measureType,
			@PathParam("mid") Long mid
	) {
		WebTarget pathTarget = webTarget.path(id.toString()).path(measureType).path(mid.toString());
		
		try {
			return getResponse(pathTarget, MediaType.APPLICATION_JSON);
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that saves a new measure object {m} (e.g. weight)
	 * for a person identified by {id} and archives the old value in the history.
	 * @param m: the measurement of interest
	 * @param id: the identifier of the person
	 * @param name: the name of the measure of interest
	 * @return the saved measurement
	 */
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/{measure_type}")
	public Response savePersonMeasure(
			Measurement m,
			@PathParam("id") Long id,
			@PathParam("measure_type") String name
	) {
		WebTarget pathTarget = webTarget.path(id.toString()).path(name);
		
		try {
			return postResponse(pathTarget, m, MediaType.APPLICATION_JSON);
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that updates the measure (e.g. weight) identified
	 * with {m.mid} for a person identified by {id}.
	 * @param m: the measurement history of interest
	 * @param id: the identifier of the person
	 * @param mid: the identifier of the measurement
	 * @param name: the name of the measure of interest
	 * @return the saved measurement
	 */
	@PUT
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/{measure_type}/{mid}")
	public Response updatePersonMeasure(
			MeasurementHistory m,
			@PathParam("id") Long id,
			@PathParam("mid") Long mid,
			@PathParam("measure_type") String name
	) {
		WebTarget pathTarget = webTarget.path(id.toString()).path(name).path(mid.toString());
		
		try {
			return putResponse(pathTarget, m, MediaType.APPLICATION_JSON);
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that gives all the information of a goal identified by {gId} for a particular person {id}.
	 * @param id: the identifier of the person
	 * @param gId: the identifier of the goal
	 * @return the goal identified by {id}
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/goal/{gId}")
	public Response getPersonGoalById(
			@PathParam("id") Long id,
			@PathParam("gId") Long gId) {
		WebTarget pathTarget = webTarget.path(id.toString()).path("goal").path(gId.toString());
		
		try {
			return getResponse(pathTarget, MediaType.APPLICATION_JSON);
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that creates a goal identified by {gId} for a particular person {id}.
	 * @param id: the identifier of the person
	 * @return the created goal identified by {id}
	 */
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/goal")
	public Response createPersonGoal(
			Goal g,
			@PathParam("id") Long id) {
		WebTarget pathTarget = webTarget.path(id.toString()).path("goal");
		
		try {
			return postResponse(pathTarget, g, MediaType.APPLICATION_JSON);
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that updates the information of a goal identified by {gId} for a particular person {id}.
	 * @param id: the identifier of the person
	 * @param gId: the identifier of the goal
	 * @return the updated goal identified by {id}
	 */
	@PUT
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/goal/{gId}")
	public Response updatePersonGoal(
			Goal g,
			@PathParam("id") Long id,
			@PathParam("gId") Long gId) {
		WebTarget pathTarget = webTarget.path(id.toString()).path("goal").path(gId.toString());
		
		try {
			return putResponse(pathTarget, g, MediaType.APPLICATION_JSON);
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that deletes the goal identified by {id} from the system.
	 * @param id: the identifier of the person
	 * @param gId: the identifier of the goal to delete
	 */
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{id}/goal/{gId}")
	public Response deletePersonGoal(
			@PathParam("id") Long id,
			@PathParam("gId") Long gId) {
		WebTarget pathTarget = webTarget.path(id.toString()).path("goal").path(gId.toString());
		
		try {
			return pathTarget.request().delete();
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that gives all the goals for a particular person {id}.
	 * @param id: the identifier of the person
	 * @return the list of goals for the person identified by {id}
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/goal")
	public Response getPersonGoals(@PathParam("id") Long id) {
		WebTarget pathTarget = webTarget.path(id.toString()).path("goal");
		
		try {
			return getResponse(pathTarget, MediaType.APPLICATION_JSON);
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that gives all the information of a goal identified by {title} for a particular person {id}.
	 * @param id: the identifier of the person
	 * @param title: the title of the goal
	 * @return the goal identified by {title}
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/goal/find")
	public Response getPersonGoalFiltered(
			@PathParam("id") Long id,
			@QueryParam("title") String title,
			@QueryParam("status") String status) {
		WebTarget pathTarget = webTarget.path(id.toString()).path("goal").path("find");
		
		if (title != null) pathTarget = pathTarget.queryParam("title", title);
		if (status != null) pathTarget = pathTarget.queryParam("status", status);
		
		try {
			return getResponse(pathTarget, MediaType.APPLICATION_JSON);
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	private Response getResponse(WebTarget webTarget, String mediaType) {
		return webTarget.request().accept(mediaType).get();
	}
	
	private Response putResponse(WebTarget webTarget, Object payload, String mediaType) {
		return webTarget.request().accept(mediaType).put(Entity.entity(payload, mediaType));
	}
	
	private Response postResponse(WebTarget webTarget, Object payload, String mediaType) {
		return webTarget.request().accept(mediaType).post(Entity.entity(payload, mediaType));
	}
}