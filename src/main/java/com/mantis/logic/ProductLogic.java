package com.mantis.logic;

import com.mantis.data.entity.Duty;
import com.mantis.data.entity.Product;
import com.mantis.data.entity.ProductShopRelation;
import com.mantis.data.entity.RepairShopDutyRelation;
import com.mantis.repositories.DutyRepository;
import com.mantis.repositories.ProductRepository;
import com.mantis.repositories.ProductShopRelationRepository;
import com.mantis.repositories.RepairShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductLogic {

    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product) {

        return productRepository.save(product);
    }

}
