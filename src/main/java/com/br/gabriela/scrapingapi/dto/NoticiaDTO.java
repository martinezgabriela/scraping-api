package com.br.gabriela.scrapingapi.dto;

import java.io.Serializable;
import java.util.Calendar;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoticiaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String url;	
	private String titulo;
	private String subtitulo;
	private String autor;
	@ApiModelProperty(example = "dd/mm/yyyy hh:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "America/São_Paulo" )
	private String data;
	private String conteudo;

}
