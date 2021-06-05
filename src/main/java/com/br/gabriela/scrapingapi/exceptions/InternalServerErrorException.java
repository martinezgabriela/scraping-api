package com.br.gabriela.scrapingapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InternalServerErrorException() {
		super();
	}
	
	public InternalServerErrorException(String m) {
		super(m);
	}
	
	public InternalServerErrorException(Throwable cause) {
		super(cause);
	}
	
	public InternalServerErrorException(String m, Throwable cause) {
		super(m, cause);
	}
	
	

}
