package by.bogomaz.app.controller;

import by.bogomaz.app.dto.SickListUnitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import by.bogomaz.app.SickListService;

import java.util.List;

@Controller
@RequestMapping("/sicklist")
public class SickListController {

    private SickListService sickListService;

    @PostMapping("/add")
    public String saveSickList(SickListUnitDto sickListUnitDto, Model model){
        sickListService.save(sickListUnitDto);
        return getAllSickList(model);
    }

    @GetMapping("/add")
    public String SickList(Model model){
        model.addAttribute("sickListUnit", new SickListUnitDto());
        return "add-sicklist";
    }

    @GetMapping("")
    public String getAllSickList(Model model){
        List<SickListUnitDto> listUnitDtos = sickListService.findAll();
        listUnitDtos.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));

        model.addAttribute("sicklist", listUnitDtos);
        return "sicklist";
    }

    @PostMapping("/delete/{id}")
    public String deleteSickList(@PathVariable Long id, Model model){
        sickListService.delete(id);
        return getAllSickList(model);
    }

    @PostMapping("/edit/")
    public String update(SickListUnitDto sickListUnitDto){
        sickListService.update(sickListUnitDto);
        return "add-sicklist";
    }

    @Autowired
    public void setSickListService(SickListService sickListService) {
        this.sickListService = sickListService;
    }
}
