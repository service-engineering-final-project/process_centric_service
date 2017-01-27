package introsde.process.rest.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The JAVA class for the "measurement" model.
 * 
 * @author alan
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement			// make it the root element

public class Measurement implements Serializable {
	private static final long serialVersionUID = 1L;

	/********************************************************************************
	 * DEFINITION OF ALL THE PRIVATE ATTRIBUTES OF THE CLASS AND THEIR MAPPING		*
	 ********************************************************************************/
	
	@XmlElement private int id;
	@XmlElement private String measureName;
	@XmlElement private String measureValue;
	@XmlElement private String measureValueType;
	@XmlElement private String time;
	@XmlElement private Person person;
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the measureName
	 */
	public String getMeasureName() {
		return measureName;
	}
	/**
	 * @return the measureValue
	 */
	public String getMeasureValue() {
		return measureValue;
	}
	/**
	 * @return the measureValueType
	 */
	public String getMeasureValueType() {
		return measureValueType;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
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
	 * @param measureName the measureName to set
	 */
	public void setMeasureName(String measureName) {
		this.measureName = measureName;
	}
	/**
	 * @param measureValue the measureValue to set
	 */
	public void setMeasureValue(String measureValue) {
		this.measureValue = measureValue;
	}
	/**
	 * @param measureValueType the measureValueType to set
	 */
	public void setMeasureValueType(String measureValueType) {
		this.measureValueType = measureValueType;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
}