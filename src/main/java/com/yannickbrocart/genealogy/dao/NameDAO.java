/**
 * 
 */
package com.yannickbrocart.genealogy.dao;

import java.util.List;
import java.util.Optional;

import com.yannickbrocart.genealogy.bean.component.Name;

/**
 * 
 */
public interface NameDAO {
	
	/**
	 * @return boolean
	 */
    public boolean createName(Name name);
	
    /**
	 * @return Optional<Name>
	 */
    public Optional<Name> findNameById(long id);
	
	/**
	 * @return List<Name>
	 */
	public List<Name> findNamesBy(String attribute);
	
	/**
	 * @return List<Name>
	 */
	public List<Name> findAllNames();
	
	/**
	 * @return boolean
	 */
	public boolean updateName(long id, Name name);
	
	/**
	 * @return boolean
	 */
	public boolean deleteName(long id);
	
}