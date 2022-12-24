package dev.profitsoft.intern.controller;

import dev.profitsoft.intern.model.User;
import dev.profitsoft.intern.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showLoginPage() {
        return "login";
    }

    @PostMapping
    public ModelAndView login(HttpServletRequest request) {
        String username = request.getParameter("username");

        Optional<User> persistedUserOptional = userService.findByUsername(username);
        if (persistedUserOptional.isPresent()) {
            String password = request.getParameter("password");
            User persistedUser = persistedUserOptional.get();

            if (persistedUser.getPassword().equals(password)) {
                request.getSession().setAttribute("authUser", persistedUser);
                return new ModelAndView("redirect:/hello");
            }
        }

        return new ModelAndView("login")
                .addObject("isBadCredentials", true);
    }
}
