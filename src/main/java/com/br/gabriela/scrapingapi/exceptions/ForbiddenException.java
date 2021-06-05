package com.br.gabriela.scrapingapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ForbiddenException() {
		super();
	}
	
	public ForbiddenException(String m) {
		super(m);
	}
	
	public ForbiddenException(Throwable cause) {
		super(cause);
	}
	
	public ForbiddenException(String m, Throwable cause) {
		super(m, cause);
	}
	
	

}
