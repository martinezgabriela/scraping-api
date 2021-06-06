package com.br.gabriela.scrapingapi.service;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.gabriela.scrapingapi.dto.NoticiaDTO;
import com.br.gabriela.scrapingapi.dto.NoticiaResponseDTO;
import com.br.gabriela.scrapingapi.entity.Noticia;
import com.br.gabriela.scrapingapi.exceptions.BadRequestException;
import com.br.gabriela.scrapingapi.exceptions.NotFoundException;
import com.br.gabriela.scrapingapi.repository.NoticiaRepository;

@Service
public class NoticiaService {
	
	@Autowired
	private NoticiaRepository noticiaRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public Noticia buscarNoticiaById(Long id) {
		return noticiaRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Nenhuma notícia encontrada com o id: " + id));
	}

	public NoticiaResponseDTO listarNoticias() {		
		NoticiaResponseDTO noticias = new NoticiaResponseDTO();
		noticias.setNoticias(noticiaRepository.findAll());		
		return noticias;
	}

	public Noticia cadastrarNoticia(NoticiaDTO noticiaDto) {
		boolean exists = noticiaRepository.existsByUrl(noticiaDto.getUrl());
		if(exists) {
			throw new BadRequestException("URL já cadastrada");
		}
		Noticia noticia = modelMapper.map(noticiaDto, Noticia.class);
		return noticiaRepository.save(noticia);
	}
	

}
