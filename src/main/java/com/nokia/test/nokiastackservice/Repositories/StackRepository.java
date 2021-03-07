package com.nokia.test.nokiastackservice.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nokia.test.nokiastackservice.Models.Stack;

@Repository
public interface StackRepository extends MongoRepository<Stack, String> {

}
