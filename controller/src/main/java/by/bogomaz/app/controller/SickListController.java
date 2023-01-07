package by.bogomaz.app.controller;

import by.bogomaz.app.dto.SickListUnitDto;
import by.bogomaz.app.entity.SickListUnit;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import by.bogomaz.app.SickListService;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/sick-list")
public class SickListController {

    private SickListService sickListService;

    @PostMapping("")
    public ResponseEntity<String> saveSickList(@RequestBody SickListUnitDto sickListDto){
        sickListService.save(sickListDto);
        return new ResponseEntity<>("Sick list post successfully", OK);
    }

    @GetMapping("")
    public List<SickListUnitDto> getAllSickLists(){
        return sickListService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<SickListUnitDto> getSickListById(@PathVariable Long id){
        return sickListService.findById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateSickList(@RequestBody SickListUnitDto sickListDto, @PathVariable Long id){
        sickListService.update(sickListDto, id);
        return new ResponseEntity<>("Sick list update successfully", OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSickList(@PathVariable Long id){
        sickListService.delete(id);
        return new ResponseEntity<>("Sick list delete successfully",OK);
    }

    @Autowired
    public void setSickListService(SickListService sickListService) {
        this.sickListService = sickListService;
    }
}
