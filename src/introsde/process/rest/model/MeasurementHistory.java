package introsde.process.rest.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The JAVA class for the "measurement history" model.
 * 
 * @author alan
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement			// make it the root element

public class MeasurementHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlElement private int mid;
	@XmlElement private String measure;
	@XmlElement private String value;
	@XmlElement private String valueType;
	@XmlElement private String created;
	@XmlElement private Person person;
	
	
	/**
	 * @return the mid
	 */
	public int getMid() {
		return mid;
	}
	/**
	 * @return the measure
	 */
	public String getMeasure() {
		return measure;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @return the valueType
	 */
	public String getValueType() {
		return valueType;
	}
	/**
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}
	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}
	/**
	 * @param mid the mid to set
	 */
	public void setMid(int mid) {
		this.mid = mid;
	}
	/**
	 * @param name the measure to set
	 */
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @param valueType the valueType to set
	 */
	public void setValueType(String valueType) {
		this.valueType = valueType;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(String created) {
		this.created = created;
	}
	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
}