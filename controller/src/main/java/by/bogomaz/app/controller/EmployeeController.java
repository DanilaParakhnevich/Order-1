package by.bogomaz.app.controller;

import by.bogomaz.app.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import by.bogomaz.app.EmployeeService;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping("/add")
    public String saveEmployee(EmployeeDto employeeDto, Model model){
        employeeService.save(employeeDto);
        return getAllEmployees(model);
    }

    @GetMapping("/add")
    public String addEmployee(Model model){
        model.addAttribute("employeeDto", new EmployeeDto());
        return "add-employee.html";
    }

    @GetMapping("")
    public String getAllEmployees(Model model){
        List<EmployeeDto> listUsers = employeeService.findAll();
        listUsers.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));

        model.addAttribute("employeeList", listUsers);
        return "employees.html";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, Model model){
        employeeService.delete(id);
        return getAllEmployees(model);
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

}
