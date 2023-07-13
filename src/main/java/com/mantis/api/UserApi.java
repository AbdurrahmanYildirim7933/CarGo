package com.mantis.api;

import com.mantis.data.dto.UserDTO;
import com.mantis.data.entity.User;
import com.mantis.mapper.UserMapper;
import com.mantis.repositories.UserRepository;
import com.mantis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserApi {
    @Autowired
    private UserService userService = new UserService();
    private UserMapper userMapper= new UserMapper();
    UserRepository userRepository;
    @GetMapping("/get-user")
    public ResponseEntity<UserDTO> getUser(@RequestParam(name = "id", required=false) Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/create-user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO)
    {
        UserDTO createdUserDTO = userService.createUser(userDTO);
        return ResponseEntity.ok(createdUserDTO);
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUserDTO = userService.updateUser(id, userDTO);
        return ResponseEntity.ok(updatedUserDTO);
    }


}
