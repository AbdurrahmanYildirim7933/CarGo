package com.mantis.logic;
import com.mantis.data.entity.ProductShopRelation;
import com.mantis.data.entity.Shop;
import com.mantis.repositories.ProductShopRelationRepository;
import com.mantis.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ShopLogic {
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    ProductShopRelationRepository productShopRelationRepository;

    public Shop createShop(Shop shop) {

        return shopRepository.save(shop);
    }
    public ProductShopRelation createProductShopRelation(ProductShopRelation productShopRelation) {
        return productShopRelationRepository.save(productShopRelation);
    }
}