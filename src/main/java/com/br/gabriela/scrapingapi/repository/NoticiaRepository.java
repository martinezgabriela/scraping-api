package com.br.gabriela.scrapingapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.gabriela.scrapingapi.entity.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long>{
	
	public Optional<Noticia> findByUrl(String url);
	public boolean existsByUrl(String url);

}
