import dto.SickListDto;
import entity.SickList;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.SickListService;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping("/sick-list")
public class SickListController {

    private final SickListService sickListService;

    @PostMapping("")
    public ResponseEntity<String> saveSickList(@RequestBody SickListDto sickListDto){
        sickListService.save(sickListDto);
        return new ResponseEntity<>("Sick list post successfully", OK);
    }

    @GetMapping("")
    public List<SickList> getAllSickLists(){
        return sickListService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<SickList> getSickListById(@PathVariable Long id){
        return sickListService.findById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateSickList(@RequestBody SickListDto sickListDto, @PathVariable Long id){
        sickListService.update(sickListDto, id);
        return new ResponseEntity<>("Sick list update successfully", OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSickList(@PathVariable Long id){
        sickListService.delete(id);
        return new ResponseEntity<>("Sick list delete successfully",OK);
    }
}
