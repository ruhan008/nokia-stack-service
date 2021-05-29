package com.nokia.test.nokiastackservice.Controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.nokia.test.nokiastackservice.Models.Stack;

import com.nokia.test.nokiastackservice.Services.StackService;

@SpringBootTest
class StackControllerTest {

	@Mock
	private StackService service;

	@InjectMocks
	private StackController controller;

	@Test
	public void sayHelloTest() {
		assertEquals("Welcome to Nokia Stack Service", controller.sayHello());
	}

	@Test
	public void addUserTest() {
		Stack user = new Stack("123", "ruhan", 24);
		Mockito.when(service.addUserMethod(user)).thenReturn(user);
		assertEquals(user.getId(), controller.addUser(user).getBody().getId());
	}

	@Test
	public void deleteLastAddedUserTest() {
		controller.deleteLastAddedUser();
		verify(service, times(1)).deleteUserMethod();
	}

	@Test
	public void getAllUsersTest() {
		Mockito.when(service.getAllUsersMethod())
				.thenReturn(Stream
						.of(new Stack("10", "Ruhan", 24), new Stack("11", "Farhan", 20), new Stack("12", "Afsah", 20))
						.collect(Collectors.toList()));
		assertEquals(3, controller.getAllUsers().size());
	}

}
