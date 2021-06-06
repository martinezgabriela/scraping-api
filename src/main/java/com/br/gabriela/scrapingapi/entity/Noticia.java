package com.br.gabriela.scrapingapi.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="noticia")
public class Noticia implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_noticia")
	private Long id;
	
	@Column(name="url")
	private String url;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="subtitulo")
	private String subtitulo;
	
	@Column(name="autor")
	private String autor;
	
	//@ApiModelProperty (example = "dd/MM/yyyy HH:mm" )
	//@JsonFormat (pattern= "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data")
	private String data;
	
	@Column(name="conteudo", columnDefinition="LONGTEXT")
	private String conteudo;

}
