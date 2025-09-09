/**
 * 
 */
package com.yannickbrocart.genealogy.dao;

import com.yannickbrocart.genealogy.bean.enums.FactoryType;
import com.yannickbrocart.genealogy.dao.jdbc.GenealogyDaoJdbcImpl;
import com.yannickbrocart.genealogy.dao.xml.GenealogyDAOXmlImpl;
import com.yannickbrocart.genealogy.ddb.Ddb;

/**
 * 
 */
public class DAOFactory {

	/**
	 * @return GenealogyDAO
	 */
	public static GenealogyDAO getGenealogyDAO(FactoryType type){
		if (type.equals(FactoryType.MYSQL_DAO_FACTORY)) return new GenealogyDaoJdbcImpl(Ddb.getConnection());
		else if (type.equals(FactoryType.XML_DAO_FACTORY)) return new GenealogyDAOXmlImpl();
		else return null;
	}

}
