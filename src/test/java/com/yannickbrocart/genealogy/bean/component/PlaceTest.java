/**
 * 
 */
package com.yannickbrocart.genealogy.bean.component;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class PlaceTest {
	
	private Place place;
	
	/**
	 * Test method for {@link main.com.yannickbrocart.genealogy.bean.component.Place#Place()}.
	 */
	@Test
	@DisplayName("Complete 'Place' class test")
	void testPlace() {
		assertAll("Complete 'Place' class test",
			() ->  {
				place = new Place();
				assertNotNull(place);
			
				assertAll("Complete 'Id' var test",
						() -> place.setId(1),
						() -> assertEquals(1, place.getId())
				);
				
				assertAll("Complete 'Town' var test",
						() -> place.setTown("Angers"),
						() -> assertEquals("Angers", place.getTown())
				);
				
				assertAll("Complete 'InseeCode' var test",
						() -> place.setInseeCode("49007"),
						() -> assertEquals("49007", place.getInseeCode())
				);
				
				assertAll("Complete 'PostalCode' var test",
						() -> place.setPostalCode("49000"),
						() -> assertEquals("49000", place.getPostalCode())
				);
				
				assertAll("Complete 'Department' var test",
						() -> place.setDepartment("Maine-et-Loire"),
						() -> assertEquals("Maine-et-Loire", place.getDepartment())
				);
				
				assertAll("Complete 'Region' var test",
						() -> place.setRegion("Pays-de-la-Loire"),
						() -> assertEquals("Pays-de-la-Loire", place.getRegion())
				);
				
				assertAll("Complete 'Country' var test",
						() -> place.setCountry("France"),
						() -> assertEquals("France", place.getCountry())
				);
				
				assertAll("Complete 'Latitude' var test",
						() -> place.setLatitude(47.466671),
						() -> assertEquals(47.466671, place.getLatitude())
				);
				
				assertAll("Complete 'Longitude' var test",
						() -> place.setLongitude(-0.55),
						() -> assertEquals(-0.55, place.getLongitude())
				);
			}
		);
	}
		
}