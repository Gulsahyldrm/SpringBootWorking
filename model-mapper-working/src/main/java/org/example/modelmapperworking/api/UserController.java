package org.example.modelmapperworking.api;

import org.example.modelmapperworking.entity.User;
import org.example.modelmapperworking.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user){
        User resultUser = userService.createUser(user);
        return ResponseEntity.ok(resultUser);
    }
    @GetMapping("/getAll")
    public ResponseEntity <List<User>> getUsers(){
            List<User>users = userService.getUsers();
            return ResponseEntity.ok(users);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity <User> updateUser( @PathVariable Long id, @RequestBody User user){
        User userResult =userService.updateUser(id,user);
        return ResponseEntity.ok(userResult);
    }

    @DeleteMapping
    public ResponseEntity<User> deleteUser(@RequestBody User user){
         User resultUser=userService.deleteUser(user);
        return ResponseEntity.ok(resultUser);
    }

}
