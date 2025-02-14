package org.example.serversidepagination.api;

import org.example.serversidepagination.dto.UserDto;
import org.example.serversidepagination.entity.User;
import org.example.serversidepagination.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> create(@RequestBody UserDto user){
        UserDto resultUser = userService.createUser(user);
        return ResponseEntity.ok(resultUser);
    }
    @GetMapping("/getAll")
    public ResponseEntity <List<UserDto>> getUsers(){
            List<UserDto> users = userService.getUsers();
            return ResponseEntity.ok(users);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity <UserDto> updateUser( @PathVariable Long id, @RequestBody UserDto user){
        UserDto userResult =userService.updateUser(id,user);
        return ResponseEntity.ok(userResult);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id){
                Boolean status = userService.deleteUser(id);
                return ResponseEntity.ok(status);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<User>>pagination(@RequestParam int currentPage, @RequestParam int pageSize){
        return ResponseEntity.ok(userService.pagination(currentPage,pageSize));
    }

}
