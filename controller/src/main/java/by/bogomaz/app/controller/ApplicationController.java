package by.bogomaz.app.controller;

import by.bogomaz.app.dto.EmployeeDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("")
    public String viewHomePage() {
        return "home";
    }

    @GetMapping("/add-employee")
    public String addEmployee(Model model){
        model.addAttribute("employeeDto", new EmployeeDto());
        return "add-employee";
    }

}
