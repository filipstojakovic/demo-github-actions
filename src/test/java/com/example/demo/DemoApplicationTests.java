package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DemoApplication.class)
class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void hello() throws Exception {
        // given
        String expectedResult = "hello";

        // when
        ResultActions result = mockMvc.perform(get("/hi"));

        // then
        result.andExpect(status().isOk());
        String responseContent = result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        assertThat(responseContent).isEqualTo(expectedResult);
    }
}
