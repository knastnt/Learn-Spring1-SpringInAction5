package ru.knasys.springinactioon5;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(HomeController.class) /*Веб-тест для HomeController*/
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;   /*Внедряет MockMvc*/

    @Test
    public void testHomePage() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/"))     /*Выполняет GET */
            .andExpect(MockMvcResultMatchers.status().isOk())    /*-Ожидает HTTP 200*/
            .andExpect(MockMvcResultMatchers.view().name("home"))    /*Ожидает home*/
            .andExpect(MockMvcResultMatchers.content().string(
                    Matchers.containsString("Хэлло, эт домашняя страница"))  /* содержится "Хэлло, эт домашняя страница"*/
            );
    }
}
