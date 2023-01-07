package by.bogomaz.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/home")
    public String viewHomePage() {
        return "home.html";
    }

}
