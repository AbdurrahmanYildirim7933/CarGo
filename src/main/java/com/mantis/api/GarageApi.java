package com.mantis.api;

import com.mantis.data.dto.GarageDTO;
import com.mantis.data.dto.ShopDTO;
import com.mantis.data.dto.UserDTO;
import com.mantis.data.entity.Garage;
import com.mantis.data.entity.User;
import com.mantis.service.GarageService;
import com.mantis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/get-garage/{id}")
    public ResponseEntity<GarageDTO> getGarage(@PathVariable(name = "id", required = false) Integer id) {
        return ResponseEntity.ok(garageService.getGarage(id));
    }

    @DeleteMapping("/delete-garage/{id}")
    public ResponseEntity<String> deleteGarage(@PathVariable Integer id){
        garageService.deleteGarage(id);
        return ResponseEntity.ok("Garage has been deleted succesfully");
    }

    @PatchMapping("/update-garage/{id}")
    public ResponseEntity<GarageDTO> updateGarage(@PathVariable Integer id,@RequestBody GarageDTO garageDTO){
        return ResponseEntity.ok(garageService.updateGarage(id,garageDTO));
    }

    @GetMapping("/garages-by-active-user")
    public ResponseEntity<List<GarageDTO>> getGarages(
            @RequestParam(name = "page",defaultValue = "0") Integer page,
            @RequestParam(name = "size",defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "name",required = false) String sortBy,
            @RequestParam(name = "sort",defaultValue = "ASC",required = false) String sortDirection) {
        Sort.Direction direction = Sort.Direction.ASC;

        if (sortDirection.equalsIgnoreCase("DESC")) {
            direction = Sort.Direction.DESC;
        }
        Page<GarageDTO> garagesPage = garageService.getGaragesByUserId(PageRequest.of(page,size, direction, sortBy));
        List<GarageDTO> garages= garagesPage.getContent();
        return  ResponseEntity.ok(garages);

    }




}
