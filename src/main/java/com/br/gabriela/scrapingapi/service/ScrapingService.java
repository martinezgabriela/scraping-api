package com.br.gabriela.scrapingapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.gabriela.scrapingapi.dto.NoticiaDTO;
import com.br.gabriela.scrapingapi.utils.ScrapingUtil;

@Service
public class ScrapingService {
	
	@Autowired
	private ScrapingUtil scrapingUtil;
	
	
	public NoticiaDTO scrapingNoticia(String url) {
		return scrapingUtil.obtemDadosNoticia(url);
	}
	

}
