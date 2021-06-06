package com.br.gabriela.scrapingapi.service;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.gabriela.scrapingapi.dto.NoticiaDTO;
import com.br.gabriela.scrapingapi.dto.NoticiaRequestDTO;
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
	
	@Autowired
	private ScrapingService scrapingService;

	public NoticiaResponseDTO buscarNoticiaByConteudo(String palavraChave) {
		NoticiaResponseDTO noticias = new NoticiaResponseDTO();
		noticias.setNoticias(noticiaRepository.findByConteudoContaining(palavraChave));
		return noticias;
	}

	public NoticiaResponseDTO listarNoticias() {		
		NoticiaResponseDTO noticias = new NoticiaResponseDTO();
		noticias.setNoticias(noticiaRepository.findAll());		
		return noticias;
	}

	public Noticia cadastrarNoticia(NoticiaRequestDTO noticia) {
		String url = noticia.getUrl();
		boolean exists = noticiaRepository.existsByUrl(url);
		if(exists) {
			throw new BadRequestException("URL já cadastrada");
		}
		NoticiaDTO noticiaDto = scrapingService.scrapingNoticia(url);
		Noticia noticiaSalvar = modelMapper.map(noticiaDto, Noticia.class);
		return noticiaRepository.save(noticiaSalvar);
	}
	

}
