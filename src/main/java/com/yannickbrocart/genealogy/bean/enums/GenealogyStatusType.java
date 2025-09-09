/**
 * 
 */
package com.yannickbrocart.genealogy.bean.enums;

/**
 * Genealogy status types
 */
public enum GenealogyStatusType {
	
	CREATED("created"),
	IN_PROGRESS("in_progress"),
	PENDING("pending"),
	ENDED("ended"),
	CANCELED("canceled");

	private String description;
	
	private GenealogyStatusType(String description) {
		this.description = description;
	}
	
	public String getDescription() {
			return description;
	}
	 
	@Override
	public String toString() {
		return description;
	}
}
