package introsde.process.rest.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The JAVA class for the "goal" model.
 * 
 * @author alan
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement			// make it the root element

// The content order in the generated schema type
@XmlType(propOrder={"id","title","init_value","final_value","created","deadline","achieved"})

public class Goal implements Serializable {
	private static final long serialVersionUID = 1L;

	/********************************************************************************
	 * DEFINITION OF ALL THE PRIVATE ATTRIBUTES OF THE CLASS AND THEIR MAPPING		*
	 ********************************************************************************/
	
	@XmlElement private int id;
	@XmlElement private String title;
	@XmlElement private String init_value;
	@XmlElement private String final_value;
	@XmlElement private String created;
	@XmlElement private String deadline;
	@XmlElement private String achieved;
	@XmlElement private Person person;
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the init_value
	 */
	public String getInit_value() {
		return init_value;
	}
	/**
	 * @return the final_value
	 */
	public String getFinal_value() {
		return final_value;
	}
	/**
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}
	/**
	 * @return the deadline
	 */
	public String getDeadline() {
		return deadline;
	}
	/**
	 * @return the achieved
	 */
	public String getAchieved() {
		return achieved;
	}
	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @param init_value the init_value to set
	 */
	public void setInit_value(String init_value) {
		this.init_value = init_value;
	}
	/**
	 * @param final_value the final_value to set
	 */
	public void setFinal_value(String final_value) {
		this.final_value = final_value;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(String created) {
		this.created = created;
	}
	/**
	 * @param deadline the deadline to set
	 */
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	/**
	 * @param achieved the achieved to set
	 */
	public void setAchieved(String achieved) {
		this.achieved = achieved;
	}
	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
}