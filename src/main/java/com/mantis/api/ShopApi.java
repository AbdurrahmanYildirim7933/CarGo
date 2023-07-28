package com.mantis.api;

import com.mantis.data.dto.ProductShopRelationDTO;
import com.mantis.data.dto.ShopDTO;
import com.mantis.service.ProductService;
import com.mantis.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/shop")
public class ShopApi {

    @Autowired
    ShopService shopService;


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

}