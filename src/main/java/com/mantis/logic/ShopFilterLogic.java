package com.mantis.logic;

import com.mantis.data.dto.ShopFilterDTO;
import com.mantis.data.entity.Shop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;
@Component
public class ShopFilterLogic {
    @Autowired EntityManager em;
  public Page<Shop> searchShopByTerm(ShopFilterDTO shop, Pageable pageable) {

        String sqlQuery= shop.getResultQuery();

      int pageNumber = pageable.getPageNumber();
      int pageSize = pageable.getPageSize();

      int startPosition = pageNumber * pageSize;
        Query query = em.createNativeQuery(sqlQuery,Shop.class);
      query.setFirstResult(startPosition);
      query.setMaxResults(pageSize);
      shop.getResultQ(query);


      List<Shop> resultList = query.getResultList();

      // Fetch the total count for pagination
      Query countQuery = em.createNativeQuery(shop.getCountQuery(),Long.class);
      shop.getResultQ(countQuery);
      Long countValue = (Long) countQuery.getSingleResult();
      Integer totalCount = Long.valueOf(countValue).intValue();
       /* return em.createNativeQuery(sqlQuery, Shop.class)
                .setParameter("shop", shop.getName())
                .getResultList();*/
      return new PageImpl<>(resultList,pageable,totalCount.longValue());
    }
  /*public List<Shop> searchShopByTerm(Shop shop) {

  return null ;

}*/
}

