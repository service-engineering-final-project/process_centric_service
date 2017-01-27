package introsde.process.rest.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.ClientBuilder;
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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import introsde.process.rest.model.Goal;
import introsde.process.rest.model.Measurement;
import introsde.process.rest.model.Person;


/***
 * The resource class that implements our service endpoints for the Person.
 * 
 * @author alan
 *
 */

//@Stateless
//@LocalBean
@Path("/ws/person")
public class CollectionResource {
	@Context UriInfo uriInfo;	// allows to insert contextual objects (uriInfo) into the class
	@Context Request request;	// allows to insert contextual objects (request) into the class
	
	DocumentBuilder docBuilder;
	WebTarget webTarget;
	ObjectMapper mapper = new ObjectMapper();
	
	// Definition of some useful constants
	final String baseUrl = "http://storage-data-service-ar.herokuapp.com/rest/person";
	
	public CollectionResource() {
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
	public List<Person> getPeopleList() {
		Person person = null;
		Measurement m = null;
		Goal goal = null;
		List<Person> peopleList = null;
		List<Measurement> mList = null;
		List<Goal> goalsList = null;
		
		// Send the request and get the relative response
		Response response = webTarget.request().accept(MediaType.APPLICATION_JSON).get(Response.class);
		int statusCode = response.getStatus();
		
		// Check the HTTP status code
		if (statusCode==200) {
			try {
				JsonNode root = mapper.readTree(response.readEntity(String.class));
				peopleList = new ArrayList<Person>();
				mList = new ArrayList<Measurement>();
				goalsList = new ArrayList<Goal>();
				
				for (int i=0; i<root.size(); i++) {
					// Set the attributes of the quote
					person = new Person();
					person.setId(root.get(i).path("id").asInt());
					person.setFirstname(root.get(i).path("firstname").asText());
					person.setLastname(root.get(i).path("lastname").asText());
					person.setBirthdate(root.get(i).path("birthdate").asText());
					
					JsonNode hpRoot = root.path("health_profile").path("measure_type");
					for (int j=0; j<hpRoot.size(); j++) {
						m = new Measurement();
						m.setId(hpRoot.get(j).path("mid").asInt());
						m.setMeasureName(hpRoot.get(j).path("measure").asText());
						m.setMeasureValue(hpRoot.get(j).path("value").asText());
						m.setMeasureValueType(hpRoot.get(j).path("value_type").asText());
						m.setTime(hpRoot.get(j).path("created").asText());
						mList.add(m);
					}
					
					JsonNode gRoot = root.path("goals").path("goal");
					for (int k=0; k<gRoot.size(); k++) {
						goal = new Goal();
						goal.setId(gRoot.get(k).path("id").asInt());
						goal.setTitle(gRoot.get(k).path("title").asText());
						goal.setInitValue(gRoot.get(k).path("init_value").asText());
						goal.setFinalValue(gRoot.get(k).path("final_value").asText());
						goal.setTime(gRoot.get(k).path("created").asText());
						goal.setDeadline(gRoot.get(k).path("deadline").asText());
						goal.setAchieved(gRoot.get(k).path("achieved").asText());
						goal.setPerson(person);
						goalsList.add(goal);
					}
					
					person.setMeasurement(mList);
					person.setGoals(goalsList);
					
					peopleList.add(person);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new WebApplicationException(statusCode);
		}
		
		return peopleList;
	}
}