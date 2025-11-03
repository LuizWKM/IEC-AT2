package br.com.fatec.api_links_uteis.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(returnNameController.class)
public class returnNameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloEndpointShouldReturnName() throws Exception {
    mockMvc.perform(get("/api/returnName"))
               .andExpect(status().isOk())
               .andExpect(content().string("Luiz Ricardo Wandenkolk Medina"));
    }
}