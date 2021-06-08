package com.br.gabriela.scrapingapi.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class NoticiaControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldTestCreateAndReturn201() throws Exception {
		URI uri = new URI("/api/v1/noticias");
		String json = "{ \"url\": \"https://www.infomoney.com.br/mercados/acoes-de-azul-e-gol-disparam-em-dia-movimentado-para-o-setor-e-eletrobras-avanca-3-vale-ameniza-baixa/\"}";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(201));
	}

	@Test
	public void shouldTestSearchAndReturn200() throws Exception {
		URI uri = new URI("/api/v1/noticias/?conteudo=azul");
		mockMvc.perform(MockMvcRequestBuilders.get(uri).content("azul").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	public void shouldTestFindAllAndReturn200() throws Exception {
		URI uri = new URI("/api/v1/noticias/");
		mockMvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().is(200));
	}

}
