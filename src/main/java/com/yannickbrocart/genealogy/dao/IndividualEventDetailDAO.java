/**
 * 
 */
package com.yannickbrocart.genealogy.dao;

import java.util.List;
import java.util.Optional;

import com.yannickbrocart.genealogy.bean.component.IndividualEventDetail;

/**
 * 
 */
public interface IndividualEventDetailDAO {
	
	/**
	 * @return boolean
	 */
    public boolean createIndividualEventDetail(IndividualEventDetail individualEventDetail);
	
    /**
	 * @return Optional<IndividualEventDetail>
	 */
    public Optional<IndividualEventDetail> findIndividualEventDetailById(long id);
	
	/**
	 * @return List<IndividualEventDetail>
	 */
	public List<IndividualEventDetail> findIndividualEventDetailsBy(String attribute);
	
	/**
	 * @return List<IndividualEventDetail>
	 */
	public List<IndividualEventDetail> findAllIndividualEventDetails();
	
	/**
	 * @return boolean
	 */
	public boolean updateIndividualEventDetail(long id, IndividualEventDetail individualEventDetail);
	
	/**
	 * @return boolean
	 */
	public boolean deleteIndividualEventDetail(long id);
	
}