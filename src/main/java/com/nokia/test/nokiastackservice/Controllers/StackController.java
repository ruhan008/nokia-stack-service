package com.nokia.test.nokiastackservice.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nokia.test.nokiastackservice.Models.Stack;
import com.nokia.test.nokiastackservice.Services.StackService;

@RestController
@RequestMapping("/nokia-stack-service")
public class StackController {

	@Autowired
	private StackService service;

	@RequestMapping("/hello")
	public String sayHello() {
		return "Welcome to Nokia Stack Service";
	}

	@PostMapping("/push")
	public ResponseEntity<Stack> addUser(@RequestBody Stack stack) {
		Stack createdUser = service.addUserMethod(stack);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(createdUser);
	}

	@DeleteMapping("/pop")
	public ResponseEntity<Stack> deleteLastAddedUser() {
		service.deleteUserMethod();
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/getAllUsers")
	public List<Stack> getAllUsers() {
		return service.getAllUsersMethod();
	}
}
