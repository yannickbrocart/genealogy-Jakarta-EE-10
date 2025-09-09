/**
 * 
 */
package com.yannickbrocart.genealogy.bean;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.yannickbrocart.genealogy.bean.enums.KnownSexTypes;

/**
 * 
 */
class FamilyTest {

	private Family family;
	private Individual person1;
	private Individual person2;
	private Individual child1;
	private Individual child2;
	private List<Individual> childs;
	
	/**
	 * Test method for {@link main.com.yannickbrocart.genealogy.bean.Family#Family()}.
	 */
	@Test
	@DisplayName("Complete 'Family' class test")
	void testFamily() {
		assertAll("Complete 'Family' class test",
			() ->  {
				family = new Family();
				person1 = new Individual();
				person2 = new Individual();
				child1 = new Individual();
				child2 = new Individual();
				childs = new ArrayList<Individual>();
				childs.add(child1);
				childs.add(child2);
				family.setPerson1(person1);
				family.setPerson2(person2);
				family.setChilds(childs);
				assertNotNull(family);
				assertNotNull(person1);
				assertNotNull(person2);
				assertNotNull(child1);
				assertNotNull(child2);
				assertNotNull(childs);
					
				assertAll("Complete 'Id' var test",
						() -> family.setId(1),
						() -> assertEquals(1, family.getId())
				);
					
				assertAll("Complete 'Person1' var test",
						() -> family.getPerson1().setPrivate(false),
						() -> assertEquals(false, family.getPerson1().getPrivate())
				);
					
				assertAll("Complete 'Person2' var test",
						() -> family.getPerson2().setId(2),
						() -> assertEquals(2, family.getPerson2().getId())
				);
					
				assertAll("Complete 'Childs' var test",
						() -> childs.get(childs.size()-1).setSex(KnownSexTypes.M),
						() -> assertEquals(KnownSexTypes.M, family.getChilds().get(childs.size()-1).getSex())
				);
			}
		);
	}
			
}