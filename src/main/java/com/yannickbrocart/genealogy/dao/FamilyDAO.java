/**
 * 
 */
package com.yannickbrocart.genealogy.dao;

import java.util.List;
import java.util.Optional;

import com.yannickbrocart.genealogy.bean.Family;

/**
 * FamilyDAO
 */
public interface FamilyDAO {

	/**
	 * @return boolean
	 */
    public boolean createFamily(Family family);
	
    /**
	 * @return Optional<Family>
	 */
    public Optional<Family> findFamilyById(long id);
	
	/**
	 * @return List<Family>
	 */
	public List<Family> findFamiliesBy(String attribute);
	
	/**
	 * @return List<Family>
	 */
	public List<Family> findAllFamilies();
	
	/**
	 * @return boolean
	 */
	public boolean updateFamily(long id, Family family);
	
	/**
	 * @return boolean
	 */
	public boolean deleteFamily(long id);
	
}