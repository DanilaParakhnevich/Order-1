package by.bogomaz.app.controller;

import by.bogomaz.app.dto.EmployeeDto;
import by.bogomaz.app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import by.bogomaz.app.EmployeeService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<String> saveEmployee(EmployeeDto employeeDto){
        employeeService.save(employeeDto);
        return new ResponseEntity<>("Employee save successfully", OK);
    }

    @GetMapping("")
    public String getAllEmployees(Model model){
        List<EmployeeDto> listUsers = employeeService.findAll();
        model.addAttribute("employeeList", listUsers);
        return "employees";
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
