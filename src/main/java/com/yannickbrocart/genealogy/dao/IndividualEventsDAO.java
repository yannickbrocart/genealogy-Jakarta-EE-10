/**
 * 
 */
package com.yannickbrocart.genealogy.dao;

import java.util.List;
import java.util.Optional;

import com.yannickbrocart.genealogy.bean.component.IndividualEvents;

/**
 * 
 */
public interface IndividualEventsDAO {

	/**
	 * @return boolean
	 */
    public boolean createGenealogy(IndividualEvents individualEvents);
	
    /**
	 * @return Optional<IndividualEvents>
	 */
    public Optional<IndividualEvents> findIndividualEventsById(long id);
	
	/**
	 * @return List<IndividualEvents>
	 */
	public List<IndividualEvents> findIndividualEventsBy(String attribute);
	
	/**
	 * @return List<IndividualEvents>
	 */
	public List<IndividualEvents> findAllIndividualEvents();
	
	/**
	 * @return boolean
	 */
	public boolean updateIndividualEvents(long id, IndividualEvents individualEvents);
	
	/**
	 * @return boolean
	 */
	public boolean deleteIndividualEvents(long id);
	
}