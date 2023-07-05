package com.mantis.api;

import com.mantis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserApi {
    @Autowired
    UserService userService;


    @GetMapping("/get-user")
    public ResponseEntity getUser(@RequestParam(name = "id", required = false) Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    /*@PostMapping("/get-user")
    public ResponseEntity getUserPost(@RequestBody UserDTO user){
        System.out.println(user.getName() +" "+user.getLastName());
        user.setId(123);
        return ResponseEntity.ok(user);
    }
     */

}
