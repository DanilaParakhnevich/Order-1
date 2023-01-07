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
//@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("")
    public String viewHomePage() {
        return "home";
    }

    @PostMapping("")
    public ResponseEntity<String> saveUser(@RequestBody EmployeeDto userDto){
        employeeService.save(userDto);
        return new ResponseEntity<>("User save successfully", OK);
    }

    @GetMapping("/all")
    public String getAllEmployees(Model model){
        List<EmployeeDto> listUsers = employeeService.findAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeByFullName(@PathVariable String fullName){
        return employeeService.findByFullName(fullName);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDto userDto, @PathVariable Long id){
        employeeService.update(userDto, id);
        return new ResponseEntity<>("User update successfully", OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.delete(id);
        return new ResponseEntity<>("User delete successfully",OK);
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
