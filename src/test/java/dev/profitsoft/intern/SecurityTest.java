package dev.profitsoft.intern;

import dev.profitsoft.intern.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SecurityTest {

    private final MockMvc mockMvc;

    @Autowired
    public SecurityTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void accessDenied_helloPage() throws Exception {
        this.mockMvc.perform(get("/hello"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }

    @Test
    public void accessAllowed_helloPage() throws Exception {
        this.mockMvc.perform(get("/hello").sessionAttr("authUser", getAuthUser()))
                .andExpect(status().isOk())
                .andExpect(request().sessionAttribute("authUser", getAuthUser()))
                .andExpect(view().name("hello"));
    }

    private static User getAuthUser() {
        return new User("roma", "123", "Roma");
    }

    @Test
    public void accessDenied_usersPage() throws Exception {
        this.mockMvc.perform(get("/users"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }

    @Test
    public void accessAllowed_usersPage() throws Exception {
        this.mockMvc.perform(get("/users").sessionAttr("authUser", getAuthUser()))
                .andExpect(status().isOk())
                .andExpect(request().sessionAttribute("authUser", getAuthUser()))
                .andExpect(view().name("users"));
    }

    @Test
    public void accessDenied_toLoginPage_ifAuthenticated() throws Exception {
        this.mockMvc.perform(get("/login").sessionAttr("authUser", getAuthUser()))
                .andExpect(status().isForbidden());
    }

    @Test
    public void accessDenied_toUsersPage_afterLogout() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("authUser", getAuthUser());

        this.mockMvc.perform(post("/logout").session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(request().sessionAttributeDoesNotExist(("authUser")))
                .andExpect(redirectedUrl("/login"))
                .andDo(result ->
                        this.mockMvc.perform(get("/users").session(session))
                                .andExpect(status().is3xxRedirection())
                                .andExpect(request().sessionAttributeDoesNotExist(("authUser")))
                                .andExpect(redirectedUrl("/login"))
                );
    }

}
