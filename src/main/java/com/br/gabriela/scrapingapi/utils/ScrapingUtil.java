package com.br.gabriela.scrapingapi.utils;

import java.io.IOException;
import java.util.Calendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.br.gabriela.scrapingapi.dto.NoticiaDTO;

@Service
public class ScrapingUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScrapingUtil.class);

	private static final String TITULO_NOTICIA = "h1[class=page-title-1]";
	private static final String SUBTITULO_NOTICA = "p[class=article-lead]";
	private static final String AUTOR_NOTICIA = "span[class=author-name]";
	private static final String DATA_PUBLICACAO = "span[class=posted-on]";
	private static final String CONTEUDO = "div[class=col-md-9 col-lg-8 col-xl-6  m-sm-auto m-lg-0 article-content]";

	public NoticiaDTO obtemDadosNoticia(String url) {
		Document document = null;
		NoticiaDTO noticiaDto = new NoticiaDTO();

		try {
			// conexão ao site
			document = Jsoup.connect(url).get();

			// seta URL
			noticiaDto.setUrl(url);

			// recupera informações
			String titulo = obtemTituloNoticia(document, TITULO_NOTICIA);
			noticiaDto.setTitulo(titulo);
			String subtitulo = obtemSubTituloNoticia(document, SUBTITULO_NOTICA);
			noticiaDto.setSubtitulo(subtitulo);
			String autor = obtemSubTituloNoticia(document, AUTOR_NOTICIA);
			noticiaDto.setAutor(autor);
			String data = obtemDataPublicacao(document, DATA_PUBLICACAO);
			noticiaDto.setData(data);
			String conteudo = obtemConteudo(document, CONTEUDO);
			noticiaDto.setConteudo(conteudo);

		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}

		return noticiaDto;

	}

	public String obtemTituloNoticia(Document document, String itemHtml) {
		Element elementTitulo = document.select(itemHtml).first();
		String titulo = elementTitulo.text();
		return titulo;
	}

	public String obtemSubTituloNoticia(Document document, String itemHtml) {
		Element elementSubTitulo = document.select(itemHtml).first();
		if (elementSubTitulo == null) {
			return "";
		}
		String titulo = elementSubTitulo.text();
		return titulo;
	}

	public String obtemAutorNoticia(Document document, String itemHtml) {
		Element elementAutor = document.selectFirst(itemHtml);
		String autor = elementAutor.select("a").first().text();
		return autor;
	}

	public String obtemDataPublicacao(Document documet, String itemHtml) {
		Element elementDate = documet.selectFirst(itemHtml);
		System.out.println(elementDate);
		String data = elementDate.select("time").attr("datetime");
		System.out.println(data);
		return data;
	}

	public String obtemConteudo(Document documet, String itemHtml) {
		Element elementContent = documet.selectFirst(itemHtml);
		String conteudo = elementContent.select("p").text();
		return conteudo;
	}

}
