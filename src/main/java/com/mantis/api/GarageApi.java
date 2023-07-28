package com.mantis.api;

import com.mantis.data.dto.GarageDTO;
import com.mantis.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/garage")
public class GarageApi {

    @Autowired
    private GarageService garageService;

    @PostMapping("/create-garage")
    public ResponseEntity<GarageDTO> createGarage(@RequestBody GarageDTO garageDTO)
    {
        GarageDTO createdGarageDTO = garageService.createGarage(garageDTO);
        return ResponseEntity.ok(createdGarageDTO);
    }

}
