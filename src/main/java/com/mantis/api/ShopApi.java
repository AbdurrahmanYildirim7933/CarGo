package com.mantis.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.mantis.data.dto.GarageDTO;
import com.mantis.data.dto.ProductShopRelationDTO;
import com.mantis.data.dto.ShopDTO;
import com.mantis.data.dto.ShopFilterDTO;
import com.mantis.logic.ShopLogic;
import com.mantis.repositories.ShopRepository;
import com.mantis.service.ShopFilterService;
import com.mantis.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/shop")

public class ShopApi {

    @Autowired
    ShopService shopService;
    @Autowired
    ShopLogic shopLogic;
    @Autowired
    ShopRepository shopRepository;

    @Autowired
    ShopFilterService shopFilterService;


    @PostMapping("/create-shop")
    public ResponseEntity<ShopDTO> createShop(@RequestBody ShopDTO shopDTO)
    {

        ShopDTO createdShopDTO = shopService.createShop(shopDTO);
        return ResponseEntity.ok(createdShopDTO);
    }
    @PostMapping("/filter")
    public ResponseEntity<List<ShopFilterDTO>> searchShops(@RequestBody ShopFilterDTO shopFilterDTO) {
        List<ShopFilterDTO> shops = shopService.searchShopByTerm(shopFilterDTO);
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }


    @PostMapping("/create-product_shop_relation")
    public ResponseEntity<ProductShopRelationDTO> createProductShopRelation(@RequestBody ProductShopRelationDTO productShopRelationDTO) {
        ProductShopRelationDTO createdProductShopRelationDTO = shopService.createProductShopRelation(productShopRelationDTO);
        return ResponseEntity.ok(createdProductShopRelationDTO);
    }
    @PostMapping ("/get-shop")
    public ResponseEntity<List<ShopDTO>> getShop(
            @RequestParam(name = "page",defaultValue = "0") Integer page,
            @RequestParam(name = "size",defaultValue = "10") Integer size,
                    @RequestParam(defaultValue = "name",required = false) String sortBy,
            @RequestParam(name = "sort",defaultValue = "ASC",required = false) String sortDirection,
            @RequestBody ShopFilterDTO shopFilterDTO){
        Sort.Direction direction = Sort.Direction.ASC;

        if (sortDirection.equalsIgnoreCase("DESC")) {
            direction = Sort.Direction.DESC;
        }
        Page<ShopDTO> shopsPage = shopService.getShops(shopFilterDTO,PageRequest.of(page,size, direction, sortBy));
        List<ShopDTO> shops= shopsPage.getContent();
        return  ResponseEntity.ok(shops);

    }
    @GetMapping("/get-shop/{id}")
    public ResponseEntity<ShopDTO> getShop(@PathVariable(name = "id", required = false) Integer id) {
        return ResponseEntity.ok(shopService.getShop(id));
    }

    @DeleteMapping("/delete-shop/{id}")
    public ResponseEntity<String> deleteShop(@PathVariable Integer id){
        shopService.deleteShop(id);
        return ResponseEntity.ok("Shop has been deleted succesfully");
    }

    @GetMapping("/find-shop-name")
    public List<ShopDTO> findByName(@RequestParam String name){
        return shopService.findByName(name);

    }
    @PatchMapping("/update-shop")
    public ResponseEntity<ShopDTO> updateShop(@RequestBody JsonPatch patch,@RequestParam(name = "id") Integer id)
            throws JsonPatchException, JsonProcessingException {
        return ResponseEntity.ok(shopService.updateShop(patch,id));
    }
    @GetMapping("/check/{time}")
    public Boolean checkPromise(@PathVariable int time){
        try {
            Thread.sleep(time*1000);
        return true;
        }catch (Exception e){
          e.printStackTrace();
        }
        return false;
    }


}

