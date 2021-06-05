package com.br.gabriela.scrapingapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NotFoundException() {
		super();
	}
	
	public NotFoundException(String m) {
		super(m);
	}
	
	public NotFoundException(Throwable cause) {
		super(cause);
	}
	
	public NotFoundException(String m, Throwable cause) {
		super(m, cause);
	}
	
	

}
