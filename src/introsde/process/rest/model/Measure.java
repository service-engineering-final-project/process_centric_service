package introsde.process.rest.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The JAVA class for the "measure" model.
 * 
 * @author alan
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement			// make it the root element

public class Measure implements Serializable {
	private static final long serialVersionUID = 1L;

	/********************************************************************************
	 * DEFINITION OF ALL THE PRIVATE ATTRIBUTES OF THE CLASS AND THEIR MAPPING		*
	 ********************************************************************************/
	
	@XmlElement private int id;
	@XmlElement private String measureName;
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
}