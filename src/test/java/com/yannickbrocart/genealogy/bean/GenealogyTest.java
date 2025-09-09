package com.yannickbrocart.genealogy.bean;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.yannickbrocart.genealogy.bean.enums.GenealogyStatusType;

/**
 * 
 */
class GenealogyTest {

	private User creator;
	private User modifier;
	private Genealogy genealogy;
	
	/**
	 * Test method for {@link main.com.yannickbrocart.genealogy.bean.Genealogy#Genealogy()}.
	 */
	@Test
	@DisplayName("Complete 'Genealogy' class test")
	void testGenealogy() {
		assertAll("Complete 'Genealogy' class test", 
			() -> {
				creator = new User();
				creator.setFirstName("Yannick");
				modifier = new User();
				modifier.setEmail("luz@cerezobrocart.com");
				genealogy = new Genealogy();
				assertNotNull(creator);
				assertNotNull(modifier);
				assertNotNull(genealogy);
	
				assertAll("Complete 'Id' var test", 
						() -> genealogy.setId(1), 
						() -> assertEquals(1, genealogy.getId()));
	
				assertAll("Complete 'Name' var test", 
						() -> genealogy.setName("My genealogy"),
						() -> assertEquals("My genealogy", genealogy.getName()));
	
				assertAll("Complete 'CreationTime' var test", 
						() -> genealogy.setCreationTime(LocalDateTime.of(2025, 03, 11, 21, 04, 22)),
						() -> assertEquals(LocalDateTime.of(2025, 03, 11, 21, 04, 22), genealogy.getCreationTime()));
	
				assertAll("Complete 'LastAccessTime' var test", 
						() -> genealogy.setLastAccessTime(LocalDateTime.of(2025, 06, 10, 14, 33, 48)),
						() -> assertEquals(LocalDateTime.of(2025, 06, 10, 14, 33, 48), genealogy.getLastAccessTime()));
	
				assertAll("Complete 'LastModifiedTime' var test", 
						() -> genealogy.setLastModifiedTime(LocalDateTime.of(2025, 04, 25, 19, 11, 59)),
						() -> assertEquals(LocalDateTime.of(2025, 04, 25, 19, 11, 59), genealogy.getLastModifiedTime()));
	
				assertAll("Complete 'CreatedBy' var test", 
						() -> genealogy.setCreatedBy(creator),
						() -> assertEquals("Yannick", genealogy.getCreatedBy().getFirstName()));
	
				assertAll("Complete 'LastModifiedBy' var test", 
						() -> genealogy.setLastModifiedBy(modifier),
						() -> assertEquals("luz@cerezobrocart.com", genealogy.getLastModifiedBy().getEmail()));
	
				assertAll("Complete 'Status' var test", 
						() -> genealogy.setStatus(GenealogyStatusType.IN_PROGRESS),
						() -> assertEquals(GenealogyStatusType.IN_PROGRESS, genealogy.getStatus()));
	
				assertAll("Complete 'Individuals' var test", 
						() -> genealogy.setIndividuals(new ArrayList<Individual>()),
						() -> assertEquals(new ArrayList<Individual>(), genealogy.getIndividuals()));
	
				assertAll("Complete 'Families' var test", 
						() -> genealogy.setFamilies(new ArrayList<Family>()),
						() -> assertEquals(new ArrayList<Family>(), genealogy.getFamilies())
				);
			}
		);
	}
			
}