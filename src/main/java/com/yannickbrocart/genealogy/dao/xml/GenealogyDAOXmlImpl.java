/**
 * 
 */
package com.yannickbrocart.genealogy.dao.xml;

import java.util.List;
import java.util.Optional;

import com.yannickbrocart.genealogy.bean.Genealogy;
import com.yannickbrocart.genealogy.dao.GenealogyDAO;

/**
 * 
 */
public class GenealogyDAOXmlImpl  implements GenealogyDAO {

	@Override
	public boolean createGenealogy(Genealogy genealogy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Genealogy> findGenealogyById(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Genealogy> findGenealogiesBy(String attribute) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Genealogy> findAllGenealogies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateGenealogy(long id, Genealogy genealogy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGenealogy(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
