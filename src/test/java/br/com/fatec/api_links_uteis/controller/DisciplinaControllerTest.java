package br.com.fatec.api_links_uteis.controller;

import br.com.fatec.api_links_uteis.model.Disciplina;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@WebMvcTest(DisciplinaController.class)
class DisciplinaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testListarTodas() throws Exception {
        mockMvc.perform(get("/api/disciplinas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))))
                .andExpect(jsonPath("$[*].nome", hasItem("Desenvolvimento Web I")))
                .andExpect(jsonPath("$[*].nome", hasItem("Banco de Dados")));
    }

    @Test
    void testBuscarPorIdExistente() throws Exception {
        mockMvc.perform(get("/api/disciplinas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Desenvolvimento Web I")))
                .andExpect(jsonPath("$.cargaHoraria", is(80)))
                .andExpect(jsonPath("$.professor", is("Prof. João Silva")));
    }

    @Test
    void testBuscarPorIdInexistente() throws Exception {
        mockMvc.perform(get("/api/disciplinas/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCriarDisciplina() throws Exception {
        Disciplina novaDisciplina = new Disciplina();
        novaDisciplina.setNome("Programação Orientada a Objetos");
        novaDisciplina.setCargaHoraria(80);
        novaDisciplina.setProfessor("Prof. Carlos Oliveira");

        mockMvc.perform(post("/api/disciplinas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(novaDisciplina)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", notNullValue()))
                .andExpect(jsonPath("$.nome", is("Programação Orientada a Objetos")))
                .andExpect(jsonPath("$.cargaHoraria", is(80)))
                .andExpect(jsonPath("$.professor", is("Prof. Carlos Oliveira")));
    }
}
