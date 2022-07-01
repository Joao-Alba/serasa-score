package br.com.serasascore.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldSavePessoa() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        PostPessoa pessoa = new PostPessoa();

        mockMvc.perform(post("/pessoa")
                        .content(objectMapper.writeValueAsString(pessoa))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldSaveAndFindFirstPessoa() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        PostPessoa pessoa = new PostPessoa();

        mockMvc.perform(post("/pessoa")
                        .content(objectMapper.writeValueAsString(pessoa))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());

        mockMvc.perform(get("/pessoa/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome", is("nomePessoa")))
                .andExpect(jsonPath("$.scoreDescricao", is("Recomendável")));
    }

    @Test
    public void shouldNotFindPessoa() throws Exception {
        mockMvc.perform(get("/pessoa/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldSaveTwoPessoasAndFindBoth() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        PostPessoa pessoa = new PostPessoa();

        mockMvc.perform(post("/pessoa")
                        .content(objectMapper.writeValueAsString(pessoa))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());

        pessoa.setNome("nomePessoa2");
        pessoa.setScore(25);

        mockMvc.perform(post("/pessoa")
                        .content(objectMapper.writeValueAsString(pessoa))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());


        mockMvc.perform(get("/pessoa"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome", is("nomePessoa")))
                .andExpect(jsonPath("$[0].scoreDescricao", is("Recomendável")))
                .andExpect(jsonPath("$[1].nome", is("nomePessoa2")))
                .andExpect(jsonPath("$[1].scoreDescricao", is("Insuficiente")));
    }

    @Data
    @NoArgsConstructor
    private static class PostPessoa {
        public String nome = "nomePessoa";
        public String telefone = "telefone";
        public int idade = 1;
        public String cidade = "cidade";
        public String estado = "estado";
        public int score = 726;
    }
}