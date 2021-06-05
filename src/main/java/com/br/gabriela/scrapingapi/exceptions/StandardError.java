package com.br.gabriela.scrapingapi.exceptions;

import java.io.Serializable;
import java.util.Calendar;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandardError implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long timeStamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	public StandardError(HttpStatus httpStatus, String msg, String path) {
		super();
		this.status = httpStatus.value();
		this.error = httpStatus.name();
		this.timeStamp = Calendar.getInstance().getTimeInMillis();
		this.message = msg;
		this.path = path;
	}
	
	

}
