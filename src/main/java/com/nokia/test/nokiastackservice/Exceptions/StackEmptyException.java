package com.nokia.test.nokiastackservice.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StackEmptyException extends RuntimeException {

	public StackEmptyException(String arg0) {
		super(arg0);
	}

}
