package com.mantis.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.mantis.data.dto.*;
import com.mantis.data.entity.CarImage;
import com.mantis.data.entity.Model;
import com.mantis.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/car")
public class CarApi {
    @Autowired
    CarService carService;
    ObjectMapper objectMapper = new ObjectMapper();
    @PostMapping("/{id}/cars")
    public ResponseEntity<QueryModel> getCars(
            @PathVariable Integer id,
            @RequestParam(name = "page",defaultValue = "0") Integer page,
            @RequestParam(name = "size",defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "id",required = false) String sortBy,
            @RequestParam(name = "sort",defaultValue = "ASC",required = false) String sortDirection,
            @RequestBody CarFilterDTO carFilterDTO) {
        Sort.Direction direction = Sort.Direction.ASC;
        if (sortDirection.equalsIgnoreCase("DESC")) {
            direction = Sort.Direction.DESC;
        }
        QueryModel carsModel = carService.getCarsByGarageId(carFilterDTO,id, PageRequest.of(page,size, direction, sortBy));
        return  ResponseEntity.ok(carsModel);
    }
    @GetMapping("/get-car/{id}")
    public ResponseEntity<CarDTO> getCar(@PathVariable(name = "id", required = false) Integer id) {
        return ResponseEntity.ok(carService.getCar(id));
    }

    @GetMapping("/get-images/{id}")
    public ResponseEntity<List<CarImageDTO>> getImagesByCar(@PathVariable(name = "id", required = false) Integer id) {
        return ResponseEntity.ok(carService.getImagesByCar(id));
    }
    @PostMapping("/create-images/{id}")
    public ResponseEntity<List<CarImageDTO>> uploadImage(@RequestBody List<CarImageDTO> carImageDTOList,@PathVariable(name = "id", required = false) Integer id) throws IOException {
        return ResponseEntity.ok(carService.uploadImages(carImageDTOList,id));
    }
    @PostMapping("/{id}/create-car")
    public ResponseEntity<CarDTO> createGarage(@RequestBody CarDTO carDTO,@PathVariable Integer id) {
        return ResponseEntity.ok(carService.createCar(id,carDTO));
    }
    @DeleteMapping("/delete-car/{id}")
    public ResponseEntity<String> deleteGarage(@PathVariable Integer id){
        carService.deleteGarage(id);
        return ResponseEntity.ok("Garage has been deleted succesfully");
    }

    @PatchMapping(path="/update-car/{id}",consumes = "application/json-patch+json")
    public ResponseEntity<CarDTO> updateGarage(@PathVariable  Integer id, @RequestBody JsonPatch patch) throws JsonPatchException, JsonProcessingException {

        return ResponseEntity.ok(carService.updateCar(id,patch));
    }

    @GetMapping("/brands")
    public ResponseEntity<List<BrandDTO>> getBrands(){
        return ResponseEntity.ok(carService.getBrands());
    }

    @GetMapping("/get-brand/{id}")
    public ResponseEntity<BrandDTO> getBrand(@PathVariable Integer id){
        return ResponseEntity.ok(carService.getBrand(id));
    }

    @GetMapping(path = "/{id}/models")
    public ResponseEntity<List<ModelDTO>> getModelsByBrand(@PathVariable Integer id){
        return ResponseEntity.ok(carService.getModelsByBrand(id));
    }
    @GetMapping("/get-model/{id}")
    public ResponseEntity<ModelDTO> getModel(@PathVariable Integer id){
        return ResponseEntity.ok(carService.getModel(id));
    }


}
