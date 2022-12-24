package dev.profitsoft.intern.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/hello", "/"})
public class HelloController {

    @GetMapping
    public ModelAndView showHelloPage(HttpServletRequest request) {
        return new ModelAndView("hello")
                .addObject("authUser", request.getSession().getAttribute("authUser"));
    }
}
