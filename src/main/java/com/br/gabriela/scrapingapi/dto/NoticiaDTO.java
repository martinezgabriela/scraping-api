package com.br.gabriela.scrapingapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoticiaDTO {
	
	private String url;	
	private String titulo;
	private String subtitulo;
	private String autor;
	private String data;
	private String conteudo;

}
