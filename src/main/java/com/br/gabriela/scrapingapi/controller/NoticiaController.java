package com.br.gabriela.scrapingapi.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.gabriela.scrapingapi.dto.NoticiaResponseDTO;
import com.br.gabriela.scrapingapi.entity.Noticia;
import com.br.gabriela.scrapingapi.exceptions.StandardError;
import com.br.gabriela.scrapingapi.service.NoticiaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("API de notícias")
@RestController
@RequestMapping("/api/v1/noticias")
public class NoticiaController {
	
	@Autowired
	private NoticiaService noticiaService;
	
	
	@ApiOperation(value = "Buscar notícia por palavra-chave")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Noticia.class),
		@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
		@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
		@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
		@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
		@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class)
	})
	@GetMapping("/search")
	public ResponseEntity<NoticiaResponseDTO> buscarNoticiaPorPalavraChave(@RequestParam(required=true) String palavraChave){
		return ResponseEntity.ok().body(noticiaService.buscarNoticiaByConteudo(palavraChave));
	}
	
	@ApiOperation(value = "Listar todas as notícias cadastradas.")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = NoticiaResponseDTO.class),
		@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
		@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
		@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
		@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
		@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class)
	})
	@GetMapping
	public ResponseEntity<NoticiaResponseDTO> listarNoticias(){
		return ResponseEntity.ok().body(noticiaService.listarNoticias());
		
	}
	
	@ApiOperation(value = "Cadastrar notícia")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Noticia.class),
		@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
		@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
		@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
		@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
		@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class)
	})
	@PostMapping
	public ResponseEntity<Noticia> cadastrarNoticia(@Valid @RequestBody String url){
		Noticia noticia = noticiaService.cadastrarNoticia(url);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(noticia.getId()).toUri();
		return ResponseEntity.created(uri).body(noticia);
		
	} 

}
