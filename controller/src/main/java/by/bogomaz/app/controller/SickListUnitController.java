package by.bogomaz.app.controller;

import by.bogomaz.app.EmployeeService;
import by.bogomaz.app.dto.SickListUnitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import by.bogomaz.app.SickListUnitService;

import java.util.List;

@Controller
@RequestMapping("/sicklist")
public class SickListUnitController {

    private SickListUnitService sickListService;
    private EmployeeService employeeService;

    @PostMapping("/add")
    public String addSickListUnit(SickListUnitDto sickListUnitDto, Model model) {
        sickListUnitDto.setEmployee(employeeService.findByFullName(sickListUnitDto.getEmployee().getFullName()));
        sickListService.save(sickListUnitDto);

        return getAllSickList(model);
    }

    @GetMapping("/add")
    public String addSickListUnit(Model model) {
        model.addAttribute("sickListUnitDto", new SickListUnitDto());
        model.addAttribute("employees", employeeService.findAll());

        return "add-sicklist";
    }

    @GetMapping
    public String getAllSickList(Model model) {
        List<SickListUnitDto> sickList = sickListService.findAll();
        sickList.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
        model.addAttribute("sicklist", sickList);

        return "sicklist";
    }

    @PostMapping("/delete/{id}")
    public String deleteSickListUnit(@PathVariable Long id, Model model) {
        sickListService.delete(id);

        return getAllSickList(model);
    }

    @PostMapping("/edit/{id}")
    public String updateSickListUnit(SickListUnitDto sickListUnitDto, @PathVariable long id) {
        sickListUnitDto.setId(id);
        sickListService.update(sickListUnitDto);

        return "add-sicklist";
    }

    @Autowired
    public void setSickListService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setSickListService(SickListUnitService sickListService) {
        this.sickListService = sickListService;
    }
}
