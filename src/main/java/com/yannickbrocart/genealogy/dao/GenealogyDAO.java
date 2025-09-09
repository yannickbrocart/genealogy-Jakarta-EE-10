/**
 * 
 */
package com.yannickbrocart.genealogy.dao;

import java.util.List;
import java.util.Optional;

import com.yannickbrocart.genealogy.bean.Genealogy;

/**
 * GenealogyDAO
 */
public interface GenealogyDAO {

	/**
	 * @return boolean
	 */
    public boolean createGenealogy(Genealogy genealogy);
	
    /**
	 * @return Optional<Genealogy>
	 */
    public Optional<Genealogy> findGenealogyById(long id);
	
	/**
	 * @return List<Genealogy>
	 */
	public List<Genealogy> findGenealogiesBy(String attribute);
	
	/**
	 * @return List<Genealogy>
	 */
	public List<Genealogy> findAllGenealogies();
	
	/**
	 * @return boolean
	 */
	public boolean updateGenealogy(long id, Genealogy genealogy);
	
	/**
	 * @return boolean
	 */
	public boolean deleteGenealogy(long id);
	
}