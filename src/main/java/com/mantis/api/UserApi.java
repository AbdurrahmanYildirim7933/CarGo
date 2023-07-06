package com.mantis.api;

import com.mantis.data.entity.User;
import com.mantis.mapper.UserMapper;
import com.mantis.repositories.UserRepository;
import com.mantis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserApi {
    @Autowired
    UserService userService;
    private UserMapper userMapper= new UserMapper();
    UserRepository userRepository;
    @GetMapping("/get-user")
    public ResponseEntity getUser(@RequestParam(name = "id", required = false) Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User createdUser = userMapper.toEntity(userService.createUser(user));
        return ResponseEntity.ok(createdUser);
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }


    /*@PostMapping("/get-user")
    public ResponseEntity getUserPost(@RequestBody UserDTO user){
        System.out.println(user.getName() +" "+user.getLastName());
        user.setId(123);
        return ResponseEntity.ok(user);
    }
     */

}
