package com.example.unittestingapp;




import com.example.unittestingapp.service.MyService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(value = Restapi.class)
class Tests {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private MyService service;

    @Test
    public void testGreetings() throws Exception{
        BDDMockito.given(service.welcome("Joan")).willReturn("Welcome Joan");
        mvc.perform(get("/api/Joan")).andExpect(content().string("WELCOME JOAN"));
    }
}
