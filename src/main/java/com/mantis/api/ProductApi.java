package com.mantis.api;

import com.mantis.data.dto.DutyDTO;
import com.mantis.data.dto.ProductDTO;
import com.mantis.data.dto.ProductShopRelationDTO;
import com.mantis.data.dto.RepairShopDutyDTO;
import com.mantis.service.DutyService;
import com.mantis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
public class ProductApi {

    @Autowired
    ProductService productService;

    @PostMapping("/create-product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO)
    {
        ProductDTO createdProductDTO = productService.createProduct(productDTO);
        return ResponseEntity.ok(createdProductDTO);
    }


}
