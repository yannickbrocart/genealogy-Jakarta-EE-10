package com.yannickbrocart.genealogy.bean.component;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class IndividualEventDetailTest {

	private IndividualEventDetail individualEventDetail;
	private Place place;
	
	/**
	 * Test method for {@link main.com.yannickbrocart.genealogy.bean.component.IndividualEventDetailDAO#IndividualEventDetail()}.
	 */
	@Test
	@DisplayName("Complete 'IndividualEventDetail' class test")
	void testIndividualEventDetail() {
		assertAll("Complete 'IndividualEventDetail' class test",
				() ->  {
					individualEventDetail = new IndividualEventDetail();
					place = new Place();
					place.setLatitude(47.466671);
					assertNotNull(individualEventDetail);
					assertNotNull(place);
		
					assertAll("Complete 'Id' var test", 
							() -> individualEventDetail.setId(5),
							() -> assertEquals(5, individualEventDetail.getId())
					);
					
					assertAll("Complete 'AgeAtEvent' var test", 
							() -> individualEventDetail.setAgeAtEvent("22"),
							() -> assertEquals("22", individualEventDetail.getAgeAtEvent())
					);
					
					assertAll("Complete 'Type' var test", 
							() -> individualEventDetail.setType("Death"),
							() -> assertEquals("Death", individualEventDetail.getType())
					);
					
					assertAll("Complete 'Date' var test", 
							() -> individualEventDetail.setDate(new Date()),
							() -> assertEquals(new Date(), individualEventDetail.getDate())
					);
					
					assertAll("Complete 'ResponsibleAgency' var test", 
							() -> individualEventDetail.setResponsibleAgency("Yannick Brocart"),
							() -> assertEquals("Yannick Brocart", individualEventDetail.getResponsibleAgency())
					);
					
					assertAll("Complete 'ReligiousAffiliation' var test", 
							() -> individualEventDetail.setReligiousAffiliation("Christian"),
							() -> assertEquals("Christian", individualEventDetail.getReligiousAffiliation())
					);
					
					assertAll("Complete 'Cause' var test", 
							() -> individualEventDetail.setCause("Age"),
							() -> assertEquals("Age", individualEventDetail.getCause())
					);
					
					assertAll("Complete 'Place' var test", 
							() -> individualEventDetail.setPlace(place),
							() -> assertEquals(47.466671, individualEventDetail.getPlace().getLatitude())
					);
				}
			);
		}
			
	}