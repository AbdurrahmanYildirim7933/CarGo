package com.mantis.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.mantis.data.dto.*;
import com.mantis.data.entity.Car;
import com.mantis.data.entity.CarImage;
import com.mantis.data.entity.Garage;
import com.mantis.data.entity.User;
import com.mantis.service.GarageService;
import com.mantis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.data.web.JsonPath;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/garage")
public class GarageApi {

    @Autowired
    private GarageService garageService;

    ObjectMapper objectMapper = new ObjectMapper();

    @MutationMapping(name = "createGarage")
    public GarageDTO createGarage(@Argument(name = "dto") GarageDTO garageDTO) {
        GarageDTO createdGarage = garageService.createGarage(garageDTO);
        return createdGarage;
    }


    @GetMapping("/get-garage/{id}")
    public ResponseEntity<GarageDTO> getGarage(@PathVariable(name = "id", required = false) Integer id) {
        return ResponseEntity.ok(garageService.getGarage(id));
    }

    @DeleteMapping("/delete-garage/{id}")
    public ResponseEntity<GarageDTO> deleteGarage(@PathVariable Integer id){
        GarageDTO deletedGarage = garageService.getGarage(id);
        garageService.deleteGarage(id);
        return ResponseEntity.ok(deletedGarage);
    }

    private GarageDTO applyPatchToGarage(JsonPatch patch, GarageDTO targetGarage) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetGarage, JsonNode.class));
        return objectMapper.treeToValue(patched, GarageDTO.class);
    }
    @PatchMapping(path="/update-garage/{id}",consumes = "application/json-patch+json")
    public ResponseEntity<GarageDTO> updateGarage(@PathVariable  Integer id, @RequestBody JsonPatch patch) throws JsonPatchException, JsonProcessingException {
        GarageDTO garage = garageService.getGarage(id);
        GarageDTO patchedGarage = applyPatchToGarage(patch, garage);
        return ResponseEntity.ok(garageService.updateGarage(id,patchedGarage));
    }

    @PostMapping("/garages-by-active-user")
    public ResponseEntity<QueryModel> getGarages(
            @RequestParam(name = "page",defaultValue = "0") Integer page,
            @RequestParam(name = "size",defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "name",required = false) String sortBy,
            @RequestParam(name = "sort",defaultValue = "ASC",required = false) String sortDirection,
            @RequestBody GarageFilterDTO garageFilterDTO){
        Sort.Direction direction = Sort.Direction.ASC;

        if (sortDirection.equalsIgnoreCase("DESC")) {
            direction = Sort.Direction.DESC;
        }
        QueryModel garagesModel = garageService.getGaragesByUserId(garageFilterDTO,PageRequest.of(page,size, direction, sortBy));
        return  ResponseEntity.ok(garagesModel);
    }

    @QueryMapping("/garages")
    public List<GarageDTO> getAllGarages(){
        return garageService.getGarages();
    }
}
