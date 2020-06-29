package it.contrader.service;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.contrader.dto.UserDTO;
import it.contrader.main.TestUtils;
import it.contrader.model.User;
import it.contrader.service.UserService;

import org.junit.Assert;

public class UserServiceTest {

	private UserDTO userTest;
	private UserService userService;
	private int userIdTest;
	
	@Before
	public void setUp() throws Exception {
		userTest = new UserDTO("AdminTest", "admin", "password", "name", "surname", "address");
		userService = new UserService();
		userService.insert(userTest);
		userIdTest = TestUtils.getLastInsertedID("user");
		userTest.setUserId(userIdTest);
	}

	@After
	public void tearDown() throws Exception {
		userService.delete(userIdTest);
	}

	@Test
	public void testInsertUser() {
		UserDTO userInsertTest = new UserDTO("insertTest","admin", "password", "name", "surname", "address");
		
		//userService.insertUser(userInsertTest);
		boolean userInsertedCheck = userService.insert(userInsertTest);
		
		int userInsertTestId = TestUtils.getLastInsertedID("user");
		userService.delete(userInsertTestId);
		
		Assert.assertTrue(userInsertedCheck);
	}

	@Test
	public void testReadtUser() {
		UserDTO DBuser=userService.read(userIdTest);
		Assert.assertTrue(DBuser.equals(userTest));
	}

	@Test
	public void testUpdateUser() {
		userTest.setUsername("Usernamemodificata");
		userService.update(userTest);
		UserDTO DBUser = userService.read(userIdTest);
		Assert.assertTrue(DBUser.getUsername().equals("Usernamemodificata"));
	}

	@Test
	public void testDeleteUser() {
		userService.delete(userIdTest);
	}

}
