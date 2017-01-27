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
@XmlType(propOrder={"id","title","initValue","finalValue","time","deadline","achieved"})

public class Goal implements Serializable {
	private static final long serialVersionUID = 1L;

	/********************************************************************************
	 * DEFINITION OF ALL THE PRIVATE ATTRIBUTES OF THE CLASS AND THEIR MAPPING		*
	 ********************************************************************************/
	
	@XmlElement private int id;
	@XmlElement private String title;
	@XmlElement private String initValue;
	@XmlElement private String finalValue;
	@XmlElement private String deadline;
	@XmlElement private String time;
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
	 * @return the initValue
	 */
	public String getInitValue() {
		return initValue;
	}
	/**
	 * @return the finalValue
	 */
	public String getFinalValue() {
		return finalValue;
	}
	/**
	 * @return the deadline
	 */
	public String getDeadline() {
		return deadline;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
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
	 * @param initValue the initValue to set
	 */
	public void setInitValue(String initValue) {
		this.initValue = initValue;
	}
	/**
	 * @param finalValue the finalValue to set
	 */
	public void setFinalValue(String finalValue) {
		this.finalValue = finalValue;
	}
	/**
	 * @param deadline the deadline to set
	 */
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
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