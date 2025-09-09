package com.yannickbrocart.genealogy.bean;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class UserTest {

	private User user;

	/**
	 * Test method for {@link main.com.yannickbrocart.genealogy.bean.User#User()}.
	 */
	@Test
	@DisplayName("Complete 'User' class test")
	void testUser() {
		assertAll("Complete 'User' class test", 
				() -> {
			user = new User();
			assertNotNull(user);

			assertAll("Complete 'Id' var test", 
					() -> user.setId(1), 
					() -> assertEquals(1, user.getId()));

			assertAll("Complete 'FirstName' var test", 
					() -> user.setFirstName("Yannick"),
					() -> assertEquals("Yannick", user.getFirstName()));

			assertAll("Complete 'LastName' var test", 
					() -> user.setLastName("Brocart"),
					() -> assertEquals("Brocart", user.getLastName()));

			assertAll("Complete 'Login' var test", 
					() -> user.setLogin("yannickbrocart"), 
					() -> assertEquals("yannickbrocart", user.getLogin()));

			assertAll("Complete 'Email' var test", 
					() -> user.setEmail("mail@yannickbrocart.com"), 
					() -> assertEquals("mail@yannickbrocart.com", user.getEmail()));

			assertAll("Complete 'RegistrationDate' var test", 
					() -> user.setRegistrationDate(LocalDateTime.of(2025, 06, 10, 14, 33, 48)),
					() -> assertEquals(LocalDateTime.of(2025, 06, 10, 14, 33, 48), user.getRegistrationDate()));
		});
	}

}