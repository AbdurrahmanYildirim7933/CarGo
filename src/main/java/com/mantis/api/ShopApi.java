package com.mantis.api;

import com.mantis.data.dto.GarageDTO;
import com.mantis.data.dto.ProductShopRelationDTO;
import com.mantis.data.dto.ShopDTO;
import com.mantis.data.entity.Shop;
import com.mantis.logic.ShopLogic;
import com.mantis.service.ProductService;
import com.mantis.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("api/v1/shop")

public class ShopApi {

    @Autowired
    ShopService shopService;
    @Autowired
    ShopLogic shopLogic;



    @PostMapping("/create-shop")
    public ResponseEntity<ShopDTO> createShop(@RequestBody ShopDTO shopDTO)
    {

        ShopDTO createdShopDTO = shopService.createShop(shopDTO);
        return ResponseEntity.ok(createdShopDTO);
    }

    @PostMapping("/create-product_shop_relation")
    public ResponseEntity<ProductShopRelationDTO> createProductShopRelation(@RequestBody ProductShopRelationDTO productShopRelationDTO) {
        ProductShopRelationDTO createdProductShopRelationDTO = shopService.createProductShopRelation(productShopRelationDTO);
        return ResponseEntity.ok(createdProductShopRelationDTO);
    }
    @GetMapping("get-shop")
    public ResponseEntity<List<ShopDTO>> getShop(
            @RequestParam(name = "page",defaultValue = "0") Integer page,
            @RequestParam(name = "size",defaultValue = "10") Integer size,
                    @RequestParam(defaultValue = "name",required = false) String sortBy,
            @RequestParam(name = "sort",defaultValue = "ASC",required = false) String sortDirection){
        Sort.Direction direction = Sort.Direction.ASC;

        if (sortDirection.equalsIgnoreCase("DESC")) {
            direction = Sort.Direction.DESC;
        }
        Page<ShopDTO> shopsPage = shopService.getShops(PageRequest.of(page,size, direction, sortBy));
        List<ShopDTO> shops= shopsPage.getContent();
        return  ResponseEntity.ok(shops);

    }

    @DeleteMapping("/delete-shop/{id}")
    public ResponseEntity<String> deleteShop(@PathVariable Integer id){
        shopService.deleteShop(id);
        return ResponseEntity.ok("Shop has been deleted succesfully");
    }


}

