package com.br.gabriela.scrapingapi.dto;

import java.io.Serializable;
import java.util.List;

import com.br.gabriela.scrapingapi.entity.Noticia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoticiaResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Noticia> noticias;

}
