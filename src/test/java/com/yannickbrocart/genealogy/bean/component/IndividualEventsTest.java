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
class IndividualEventsTest {

	private IndividualEvents individualEvents;
	private IndividualEventDetail birthDetail;
	private IndividualEventDetail deathDetail;
	
	/**
	 * Test method for {@link main.com.yannickbrocart.genealogy.bean.component.individualEvents#IndividualEvents()}.
	 */
	@Test
	@DisplayName("Complete 'IndividualEvents' class test")
	void testIndividualEvents() {
		assertAll("Complete 'IndividualEvents' class test",
				() ->  {
					individualEvents = new IndividualEvents();
					birthDetail = new IndividualEventDetail();
					deathDetail = new IndividualEventDetail();
					assertNotNull(individualEvents);
					assertNotNull(birthDetail);
					assertNotNull(deathDetail);
		
					assertAll("Complete 'Id' var test", 
							() -> individualEvents.setId(2),
							() -> assertEquals(2, individualEvents.getId())
					);
							
					assertAll("Complete 'BirthDetail' var test",
							() -> individualEvents.setBirthDetail(birthDetail),
							() -> assertEquals(birthDetail, individualEvents.getBirthDetail())
					);
					
					assertAll("Complete 'DeathDetail' var test",
							() -> individualEvents.setDeathDetail(deathDetail),
							() -> assertEquals(deathDetail, individualEvents.getDeathDetail())
					);
					
					assertAll("Complete 'Death' var test",
							() -> individualEvents.setDeath(true),
							() -> assertEquals(true, individualEvents.isDeath())
					);
				}
			);
		}
			
	}