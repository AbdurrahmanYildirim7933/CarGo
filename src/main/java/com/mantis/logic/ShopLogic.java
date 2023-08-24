package com.mantis.logic;
import com.mantis.data.dto.ShopFilterDTO;
import com.mantis.data.entity.Garage;
import com.mantis.data.entity.ProductShopRelation;
import com.mantis.data.entity.Shop;
import com.mantis.repositories.ProductShopRelationRepository;
import com.mantis.repositories.ShopRepository;
import com.mantis.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;


@Component
public class ShopLogic {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    ProductShopRelationRepository productShopRelationRepository;
    @Autowired
    EntityManager entityManager;
    @Autowired ShopFilterLogic shopFilterLogic;
    @Autowired
    AuthorizationLogic authorizationLogic;

    public Shop createShop(Shop shop) {

        return shopRepository.save(shop);
    }
    public ProductShopRelation createProductShopRelation(ProductShopRelation productShopRelation) {
        return productShopRelationRepository.save(productShopRelation);
    }
    public Page<Shop> getShops(ShopFilterDTO shopFilterDTO, Pageable pageable){
        return shopFilterLogic.searchShopByTerm(shopFilterDTO,pageable);
    }
    public Shop getShop(Integer id){
        return shopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shop cannot found"));
    }
    public void deleteShop(Integer id){
        if (id == null || id == 0) {
            throw new RuntimeException("ID cannot be null");
        }
        shopRepository.deleteById(id);
    }
    public Shop updateShop(Integer id,Shop newShop){
        Shop oldShop =shopRepository.findById(id).orElseThrow(()-> new RuntimeException("Shop cannot found"));

        oldShop.setName(newShop.getName());
        oldShop.setAddress(newShop.getAddress());
        oldShop.setPhone(newShop.getPhone());
        oldShop.setOwner(oldShop.getOwner());
        shopRepository.save(oldShop);
        return oldShop;
    }
    public List<Shop> findByName(String name) {

        return shopRepository.findShopByName(name);
    }
    public Shop findById(Integer id) {

        return shopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shop not found"));
    }

    public List<Shop> searchShopByTerm(Shop shop){
        return null;
    }







}