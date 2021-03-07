package com.nokia.test.nokiastackservice.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nokia.test.nokiastackservice.Models.Stack;
import com.nokia.test.nokiastackservice.Repositories.StackRepository;

@Service
public class StackService {

	@Autowired
	private StackRepository repo;

	public Stack addUserMethod(Stack stack) {
		return repo.save(stack);
	}

	public void deleteUserMethod() {
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		List<Stack> list = repo.findAll(sort).subList(0, 1);
		String deletionId = list.get(0).getId();
		repo.deleteById(deletionId);
	}

	public List<Stack> getAllUsersMethod() {
		return repo.findAll();
	}

}
