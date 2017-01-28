package introsde.process.rest.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The JAVA class for the "person" model.
 * 
 * @author alan
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement			// make it the root element

// The content order in the generated schema type
@XmlType(propOrder={"id","firstname","lastname","birthdate","healthProfile","goals"})

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	/********************************************************************************
	 * DEFINITION OF ALL THE PRIVATE ATTRIBUTES OF THE CLASS AND THEIR MAPPING		*
	 ********************************************************************************/
	
	@XmlElement private int id;
	@XmlElement private String firstname;
	@XmlElement private String lastname;
	@XmlElement private String birthdate;
	@XmlElement private List<Measurement> health_profile;
	@XmlElement private List<MeasurementHistory> mHistory;
	@XmlElement private List<Goal> goals;
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @return the birthdate
	 */
	public String getBirthdate() {
		return birthdate;
	}
	/**
	 * @return the measurement
	 */
	public List<Measurement> getHealthProfile() {
		return health_profile;
	}
	/**
	 * @return the mHistory
	 */
	public List<MeasurementHistory> getmHistory() {
		return mHistory;
	}
	/**
	 * @return the goal
	 */
	public List<Goal> getGoals() {
		return goals;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	/**
	 * @param measurement the measurement to set
	 */
	public void setMeasurement(List<Measurement> health_profile) {
		this.health_profile = health_profile;
	}
	/**
	 * @param mHistory the mHistory to set
	 */
	public void setmHistory(List<MeasurementHistory> mHistory) {
		this.mHistory = mHistory;
	}
	/**
	 * @param goal the goal to set
	 */
	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}
}