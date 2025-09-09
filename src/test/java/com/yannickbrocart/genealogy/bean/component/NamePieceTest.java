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
class NamePieceTest {

	private NamePiece namePiece;
		
	/**
	 * Test method for {@link main.com.yannickbrocart.genealogy.bean.component.NamePieceDAO#NamePiece()}.
	 */
	@Test
	@DisplayName("Complete 'NamePiece' class test")
	void testNamePiece() {
		assertAll("Complete 'NamePiece' class test",
				() ->  {
					namePiece = new NamePiece();
					assertNotNull(namePiece);
		
					assertAll("Complete 'Id' var test", 
							() -> namePiece.setId(1),
							() -> assertEquals(1, namePiece.getId())
					);
							
					assertAll("Complete 'Prefix' var test",
							() -> namePiece.setPrefix("Sr"),
							() -> assertEquals("Sr", namePiece.getPrefix())
					);
					
					assertAll("Complete 'Given' var test",
							() -> namePiece.setGiven("Juan"),
							() -> assertEquals("Juan", namePiece.getGiven())
					);
					
					assertAll("Complete 'Nickname' var test",
							() -> namePiece.setNickname("Juanito"),
							() -> assertEquals("Juanito", namePiece.getNickname())
					);
					
					assertAll("Complete 'SurnamePrefix' var test",
							() -> namePiece.setSurnamePrefix("de la"),
							() -> assertEquals("de la", namePiece.getSurnamePrefix())
					);
					
					assertAll("Complete 'Surname' var test",
							() -> namePiece.setSurname("Cruz"),
							() -> assertEquals("Cruz", namePiece.getSurname())
					);
					assertAll("Complete 'Suffix' var test",
							() -> namePiece.setSuffix("p"),
							() -> assertEquals("p", namePiece.getSuffix())
					);
				}
			);
		}
			
	}