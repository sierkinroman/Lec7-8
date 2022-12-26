package dev.profitsoft.intern.controller;

import dev.profitsoft.intern.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class LoginControllerTest {

    private final MockMvc mockMvc;

    @Autowired
    public LoginControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void showLoginPage() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void correctLogin() throws Exception {
        this.mockMvc.perform(post("/login").param("username", "roma").param("password", "123"))
                .andExpect(status().is3xxRedirection())
                .andExpect(request().sessionAttribute("authUser", new User("roma", "123", "Roma")))
                .andExpect(redirectedUrl("/hello"));
    }

    @Test
    public void badCredentials() throws Exception {
        this.mockMvc.perform(post("/login").param("username", "123").param("password", "123"))
                .andExpect(status().isUnauthorized())
                .andExpect(request().sessionAttributeDoesNotExist("authUser"))
                .andExpect(view().name("login"));
    }

}