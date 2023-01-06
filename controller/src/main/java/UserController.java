import dto.UserDto;
import entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto){
        userService.save(userDto);
        return new ResponseEntity<>("User save successfully", OK);
    }

    @GetMapping("")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserByName(@PathVariable String name){
        return userService.findByName(name);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateUser(@RequestBody UserDto userDto, @PathVariable Long id){
        userService.update(userDto, id);
        return new ResponseEntity<>("User update successfully", OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>("User delete successfully",OK);
    }
}
