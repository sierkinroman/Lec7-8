package dev.profitsoft.intern.controller;

import dev.profitsoft.intern.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class LogoutControllerTest {

    private final MockMvc mockMvc;

    @Autowired
    LogoutControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void correctLogout() throws Exception {
        User authUser = new User("roma", "123", "Roma");

        this.mockMvc.perform(post("/logout").sessionAttr("authUser", authUser))
                .andExpect(status().is3xxRedirection())
                .andExpect(request().sessionAttributeDoesNotExist(("authUser")))
                .andExpect(redirectedUrl("/login"));
    }

}