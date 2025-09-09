/**
 * 
 */
package com.yannickbrocart.genealogy.bean.component;

import java.io.Serializable;
import java.util.Date;

/**
 * Individual event detail
 */
public class IndividualEventDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String ageAtEvent;
	private String type;
	private Date date;
	private String responsibleAgency;
	private String religiousAffiliation;
	private String cause;
	private Place place;
	
	public IndividualEventDetail() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAgeAtEvent() {
		return ageAtEvent;
	}

	public void setAgeAtEvent(String ageAtEvent) {
		this.ageAtEvent = ageAtEvent;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getResponsibleAgency() {
		return responsibleAgency;
	}

	public void setResponsibleAgency(String responsibleAgency) {
		this.responsibleAgency = responsibleAgency;
	}

	public String getReligiousAffiliation() {
		return religiousAffiliation;
	}

	public void setReligiousAffiliation(String religiousAffiliation) {
		this.religiousAffiliation = religiousAffiliation;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "IndividualEventDetail [id=" + id + ", ageAtEvent=" + ageAtEvent + ", type=" + type + ", date=" + date
				+ ", responsibleAgency=" + responsibleAgency + ", religiousAffiliation=" + religiousAffiliation
				+ ", cause=" + cause + ", place=" + place + "]";
	}
	
}
