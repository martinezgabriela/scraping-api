package com.br.gabriela.scrapingapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BadRequestException() {
		super();
	}
	
	public BadRequestException(String m) {
		super(m);
	}
	
	public BadRequestException(Throwable cause) {
		super(cause);
	}
	
	public BadRequestException(String m, Throwable cause) {
		super(m, cause);
	}
	
	

}
