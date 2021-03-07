package com.nokia.test.nokiastackservice.Services;

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
import org.springframework.data.domain.Sort;

import com.nokia.test.nokiastackservice.Models.Stack;
import com.nokia.test.nokiastackservice.Repositories.StackRepository;

@SpringBootTest
class StackServiceTest {

	@Mock
	private StackRepository repository;

	@InjectMocks
	private StackService service;

	@Test
	public void addUserMethodTest() {
		Stack user = new Stack("10", "Ruhan", 24);
		Mockito.when(repository.save(user)).thenReturn(user);
		assertEquals(user.getName(), service.addUserMethod(user).getName());
	}

	@Test
	public void deleteUserMethodTest() {
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		Mockito.when(repository.findAll(sort))
				.thenReturn(Stream.of(new Stack("123", "Ruhan", 24)).collect(Collectors.toList()));
		service.deleteUserMethod();
		verify(repository, times(1)).deleteById("123");
	}

	@Test
	public void getAllUsersMethodTest() {
		Mockito.when(repository.findAll())
				.thenReturn(Stream.of(new Stack("10", "Ruhan", 24), new Stack("11", "Farhan", 20),
						new Stack("12", "Afsah", 20), new Stack("13", "Saumya", 25)).collect(Collectors.toList()));
		assertEquals(4, service.getAllUsersMethod().size());
	}

}
