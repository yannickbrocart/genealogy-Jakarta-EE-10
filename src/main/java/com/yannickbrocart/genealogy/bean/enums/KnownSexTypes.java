/**
 * 
 */
package com.yannickbrocart.genealogy.bean.enums;

/**
 * Known sex types enumeration
 */
public enum KnownSexTypes {
	
	M("Male"),
	F("Female"),
	U("Unknown"),
	X("Intersex"),
	N("Not recorded");
	
	private String sexType;
	
	private KnownSexTypes(String sexType) {
		this.sexType = sexType;
	}

	public String getSexType() {
		return sexType;
	}
}