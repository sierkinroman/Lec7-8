package dev.profitsoft.intern.controller;

import dev.profitsoft.intern.dto.UserInfoDto;
import dev.profitsoft.intern.model.User;
import dev.profitsoft.intern.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.hamcrest.Matchers.iterableWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerTest {

    private final MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    public UserControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void showUsersPage() throws Exception {
        Set<UserInfoDto> users = Set.of(
                new UserInfoDto("dru", "Andriy"),
                new UserInfoDto("roma", "Roma"),
                new UserInfoDto("dmtr", "Dmitro")
        );

        Mockito.doReturn(users)
                .when(userService)
                .findAll();

        User authUser = new User("roma", "123", "Roma");

        this.mockMvc.perform(get("/users").sessionAttr("authUser", authUser))
                .andExpect(status().isOk())
                .andExpect(request().sessionAttribute("authUser", authUser))
                .andExpect(model().attribute("users", iterableWithSize(users.size())))
                .andExpect(model().attribute("users", users))
                .andExpect(view().name("users"));
    }

}