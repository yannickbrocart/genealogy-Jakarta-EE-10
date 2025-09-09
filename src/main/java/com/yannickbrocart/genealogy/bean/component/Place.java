/**
 * 
 */
package com.yannickbrocart.genealogy.bean.component;

import java.io.Serializable;

/**
 * 
 */
public class Place implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private long id;
	private String town;
	private String inseeCode;
	private String postalCode;
	private String department;
	private String region;
	private String country;
	private Double latitude;
	private Double longitude;
	
	public Place() {}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getInseeCode() {
		return inseeCode;
	}

	public void setInseeCode(String inseeCode) {
		if (inseeCode.length() == 5 && inseeCode.matches(".*\\d.*"))
			this.inseeCode = inseeCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		if (postalCode.length() == 5 && postalCode.matches(".*\\d.*"))
			this.postalCode = postalCode;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		if (latitude >= -90 && latitude <= 90)
			this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		if (longitude >= -180 && longitude <= 180)
			this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Place [id=" + id + ", town=" + town + ", inseeCode=" + inseeCode + ", postalCode=" + postalCode
				+ ", department=" + department + ", region=" + region + ", country=" + country + ", latitude="
				+ latitude + ", longitude=" + longitude + "]";
	}
	
}
