package br.com.fatec.api_links_uteis.controller;

import br.com.fatec.api_links_uteis.model.Disciplina;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class DisciplinaControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testFluxoCompleto() throws Exception {
        // 1. Listar disciplinas iniciais
        mockMvc.perform(get("/api/disciplinas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))));

        // 2. Buscar uma disciplina específica
        mockMvc.perform(get("/api/disciplinas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome", is("Desenvolvimento Web I")));

        // 3. Criar nova disciplina
        Disciplina novaDisciplina = new Disciplina();
        novaDisciplina.setNome("Engenharia de Software");
        novaDisciplina.setCargaHoraria(80);
        novaDisciplina.setProfessor("Prof. Ana Costa");

        String response = mockMvc.perform(post("/api/disciplinas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(novaDisciplina)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", notNullValue()))
                .andExpect(jsonPath("$.nome", is("Engenharia de Software")))
                .andReturn()
                .getResponse()
                .getContentAsString();

        // 4. Buscar a disciplina criada
        Disciplina disciplinaCriada = objectMapper.readValue(response, Disciplina.class);
        mockMvc.perform(get("/api/disciplinas/" + disciplinaCriada.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome", is("Engenharia de Software")));
    }

    @Test
    void testBuscarDisciplinaInexistente() throws Exception {
        mockMvc.perform(get("/api/disciplinas/9999"))
                .andExpect(status().isNotFound());
    }
}
