package com.br.gabriela.scrapingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.gabriela.scrapingapi.entity.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long>{
	

}
