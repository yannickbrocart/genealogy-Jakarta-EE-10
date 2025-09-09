/**
 * 
 */
package com.yannickbrocart.genealogy.dao;

import java.util.List;
import java.util.Optional;

import com.yannickbrocart.genealogy.bean.component.Place;

/**
 * PlaceDAO
 */
public interface PlaceDAO {
	
	/**
	 * @return boolean
	 */
    public boolean createPlace(Place place);
	
    /**
	 * @return Optional<Place>
	 */
    public Optional<Place> findPlaceById(long id);
	
	/**
	 * @return List<Place>
	 */
	public List<Place> findPlacesBy(String attribute);
	
	/**
	 * @return List<Place>
	 */
	public List<Place> findAllPlaces();
	
	/**
	 * @return boolean
	 */
	public boolean updatePlace(long id, Place place);
	
	/**
	 * @return boolean
	 */
	public boolean deletePlace(long id);
	
}