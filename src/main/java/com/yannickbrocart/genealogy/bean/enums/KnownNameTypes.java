/**
 * 
 */
package com.yannickbrocart.genealogy.bean.enums;

/**
 * Known name types
 */
public enum KnownNameTypes {

	AKA("Aka"),
	BIRTH("Birth"),
	IMMIGRANT("Immigrant"),
	MAIDEN("Maiden"),
	USER_DEFINED("User defined"),
	MARRIED("Married");
	
	private String nameType;
	
	private KnownNameTypes(String nameType) {
		this.nameType= nameType;
	}
	
	public String getNameType() {
		return this.nameType;
	}

}
