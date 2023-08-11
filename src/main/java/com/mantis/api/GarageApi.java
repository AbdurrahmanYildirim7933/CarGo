package com.mantis.api;

import com.mantis.data.dto.GarageDTO;
import com.mantis.data.dto.UserDTO;
import com.mantis.data.entity.User;
import com.mantis.service.GarageService;
import com.mantis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/garage")
public class GarageApi {
@Autowired
    private UserService userService;
    @Autowired
    private GarageService garageService;

    @PostMapping("/create-garage")
    public ResponseEntity<GarageDTO> createGarage(@RequestBody GarageDTO garageDTO) {
        GarageDTO createdGarageDTO = garageService.createGarage(garageDTO);
        return ResponseEntity.ok(createdGarageDTO);
    }

    @GetMapping("/get-garage")
    public ResponseEntity<GarageDTO> getGarage(@RequestParam(name = "id", required = false) Integer id) {
        return ResponseEntity.ok(garageService.getGarage(id));
    }

    @DeleteMapping("/delete-garage/{id}")
    public ResponseEntity<String> deleteGarage(@PathVariable Integer id){
        garageService.deleteGarage(id);
        return ResponseEntity.ok("Garage has been deleted succesfully");
    }

    @PutMapping("/update-garage/{id}")
    public ResponseEntity<GarageDTO> updateGarage(@PathVariable Integer id,GarageDTO garageDTO){
        return ResponseEntity.ok(garageService.updateGarage(id,garageDTO));
    }

    @GetMapping("/users/{id}/garages")
    public ResponseEntity<List<GarageDTO>> getGarages(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(garageService.getGaragesByUserId(id));
    }


}
