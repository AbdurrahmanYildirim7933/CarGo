package com.mantis.logic;
import com.mantis.data.entity.Garage;
import com.mantis.data.entity.ProductShopRelation;
import com.mantis.data.entity.Shop;
import com.mantis.data.entity.User;
import com.mantis.repositories.ProductShopRelationRepository;
import com.mantis.repositories.ShopRepository;
import com.mantis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Component
public class ShopLogic {
    @Autowired
    UserRepository userRepository;
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
    public Page<Shop> getShops(Pageable pageable){
        return shopRepository.findAll(pageable);
    }
    public void deleteShop(Integer id){
        if (id == null || id == 0) {
            throw new RuntimeException("ID cannot be null");
        }
        shopRepository.deleteById(id);
    }



}