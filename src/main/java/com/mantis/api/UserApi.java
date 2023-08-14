package com.mantis.api;

import com.mantis.data.dto.GarageDTO;
import com.mantis.data.dto.SessionDTO;
import  com.mantis.data.dto.UserDTO;
import com.mantis.service.GarageService;
import com.mantis.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserApi {

    @Autowired
    private UserService userService;

    @Autowired
    private GarageService garageService;



    @Autowired
    private HttpServletRequest request;




    @GetMapping("/get-client-ip")
    public ResponseEntity<Object> getIP(HttpServletRequest request) {
        String clientIP = getClientIP(request);
        IPResponse response = new IPResponse(clientIP);
        return ResponseEntity.ok(response);
    }

    private String getClientIP(HttpServletRequest request) {
        String clientIP = request.getHeader("X-Forwarded-For");

        if (clientIP == null || clientIP.isEmpty() || "unknown".equalsIgnoreCase(clientIP)) {
            // If X-Forwarded-For header is not available or has a "unknown" value,
            // fall back to the remote address provided by the request.
            clientIP = request.getRemoteAddr();
        } else {
            // The X-Forwarded-For header can contain a comma-separated list of IP addresses.
            // In this case, the client IP is the first address in the list.
            int indexOfFirstComma = clientIP.indexOf(",");
            if (indexOfFirstComma != -1) {
                clientIP = clientIP.substring(0, indexOfFirstComma);
            }
        }

        return clientIP;
    }

    // A simple class to represent the JSON response
    private static class IPResponse {
        private final String clientIP;

        public IPResponse(String clientIP) {
            this.clientIP = clientIP;
        }

        public String getClientIP() {
            return clientIP;
        }
    }



    @GetMapping("/get-user")
    public ResponseEntity<UserDTO> getUser(@RequestParam(name = "id", required=false) Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/create-user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) throws MessagingException {

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

    @PostMapping("user-verify-by-code")
    @ResponseBody
    public UserDTO userVerifyByCode(@RequestBody UserDTO user){
        return userService.verifyByUser(user);
    }


}
