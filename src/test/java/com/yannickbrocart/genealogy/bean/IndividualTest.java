package com.yannickbrocart.genealogy.bean;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.yannickbrocart.genealogy.bean.component.IndividualEvents;
import com.yannickbrocart.genealogy.bean.component.Name;
import com.yannickbrocart.genealogy.bean.enums.KnownSexTypes;

/**
 * 
 */
class IndividualTest {

	private Individual individual;
	private Family family;
	private Individual spouse;
	private Name name1;
	private Name name2;
	private List<Name> names;
	private IndividualEvents individualEvents;
	
	/**
	 * Test method for {@link main.com.yannickbrocart.genealogy.bean.individualEvents#IndividualEvents()}.
	 */
	@Test
	@DisplayName("Complete 'Individual' class test")
	void testIndividual() {
		assertAll("Complete 'Individual' class test",
				() ->  {
					individual = new Individual();
					family = new Family();
					spouse = new Individual();
					name1 = new Name();
					name2 = new Name();
					names = new ArrayList<Name>(Arrays.asList(name1, name2));
					individualEvents = new IndividualEvents();
					assertNotNull(individual);
					assertNotNull(family);
					assertNotNull(spouse);
					assertNotNull(name1);
					assertNotNull(name2);
					assertNotNull(names);
					assertNotNull(individualEvents);
					
					assertAll("Complete 'Id' var test",
							() -> individual.setId(1),
							() -> assertEquals(1, individual.getId())
					);
					
					assertAll("Complete 'Sex' var test",
							() -> individual.setSex(KnownSexTypes.F),
							() -> assertEquals(KnownSexTypes.F, individual.getSex())
					);
					
					assertAll("Complete 'Names' var test",
							() -> individual.setNames(names),
							() -> assertEquals(names, individual.getNames())
					);
					
					assertAll("Complete 'IndividualEvents' var test",
							() -> individual.setIndividualEvents(individualEvents),
							() -> assertEquals(individualEvents, individual.getIndividualEvents())
					);
					
					assertAll("Complete 'ChildToFamily' var test",
							() -> individual.setChildToFamily(family.getId()),
							() -> assertEquals(family.getId(), individual.getChildToFamily())
					);
					
					assertAll("Complete 'SpouseToFamily' var test",
							() -> individual.setSpouseToFamily(spouse.getId()),
							() -> assertEquals(spouse.getId(), individual.getSpouseToFamily())
					);
					
					assertAll("Complete 'IsPrivate' var test",
							() -> individual.setPrivate(false),
							() -> assertEquals(false, individual.getPrivate())
					);
				}
			);
		}
			
	}