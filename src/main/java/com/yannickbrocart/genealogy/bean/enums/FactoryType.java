/**
 * 
 */
package com.yannickbrocart.genealogy.bean.enums;

/**
 * Factory types
 */
public enum FactoryType {
    
	MYSQL_DAO_FACTORY("MySQL_DAO_factory"),
	POSTGRESQL_DAO_FACTORY("PostgreSQL_DAO_factory"),
	XML_DAO_FACTORY("XML_DAO_factory");

    private String type;

    private FactoryType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
