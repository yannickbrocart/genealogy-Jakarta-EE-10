/**
 * 
 */
package com.yannickbrocart.genealogy.dao;

import java.util.List;
import java.util.Optional;

import com.yannickbrocart.genealogy.bean.Individual;

/**
 * IndividualDAO
 */
public interface IndividualDAO {

	/**
	 * @return boolean
	 */
    public boolean createIndividual(Individual individual);
	
    /**
	 * @return Optional<Individual>
	 */
    public Optional<Individual> findIndividualById(long id);
	
	/**
	 * @return List<Individual>
	 */
	public List<Individual> findIndividualsBy(String attribute);
	
	/**
	 * @return List<Individual>
	 */
	public List<Individual> findAllIndividuals();
	
	/**
	 * @return boolean
	 */
	public boolean updateIndividual(long id, Individual individual);
	
	/**
	 * @return boolean
	 */
	public boolean deleteIndividual(long id);
	
}