package com.yannickbrocart.genealogy.bean.component;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.yannickbrocart.genealogy.bean.enums.KnownNameTypes;

class NameTest {

	private NamePiece namePiece1;
	private NamePiece namePiece2;
	private NamePiece namePiece3;
	private List<NamePiece> namePieces;
	private Name name;
	
	/**
	 * Test method for {@link main.com.yannickbrocart.genealogy.bean.component.Name#Name()}.
	 */
	@Test
	@DisplayName("Complete 'Name' class test")
	void testName() {
		assertAll("Complete 'Name' class test",
				() ->  {
					LocalDate localDate = LocalDate.of(2025, 03, 11);
					namePiece1 = new NamePiece();
					namePiece2 = new NamePiece();
					namePiece3 = new NamePiece();
					namePiece1.setId(1);
					namePiece2.setId(2);
					namePiece3.setId(3);					
					namePieces = new ArrayList<NamePiece>(Arrays.asList(namePiece1, namePiece2, namePiece3));
					name = new Name();
					name.setType(KnownNameTypes.BIRTH);
					name.setNamePieces(namePieces);
					assertNotNull(namePiece1);
					assertNotNull(namePiece2);
					assertNotNull(namePiece3);
					assertNotNull(namePieces);
					assertNotNull(name);
				
					assertAll("Complete 'Id' var test",
							() -> name.setId(1),
							() -> assertEquals(1, name.getId())
					);
					
					assertAll("Complete 'Type' var test",
							() -> name.setType(KnownNameTypes.BIRTH),
							() -> assertEquals(KnownNameTypes.BIRTH, name.getType())
					);
					
					assertAll("Complete 'Nickname' var test",
							() -> name.getNamePieces().get(namePieces.size()-1).setNickname("Le Bel"),
							() -> assertEquals("Le Bel", name.getNamePieces().get(namePieces.size()-1).getNickname())
					);
					
					assertAll("Complete 'Date' var test",
							() -> name.setDate(localDate),
							() -> assertEquals(LocalDate.of(2025, 03, 11), name.getDate())
							);
				}
			);
		}
			
	}