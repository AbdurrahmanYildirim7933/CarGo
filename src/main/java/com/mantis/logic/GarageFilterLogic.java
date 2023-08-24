package com.mantis.logic;

import com.mantis.data.dto.GarageFilterDTO;
import com.mantis.data.dto.SessionDTO;
import com.mantis.data.dto.ShopFilterDTO;
import com.mantis.data.dto.UserDTO;
import com.mantis.data.entity.Garage;
import com.mantis.data.entity.Shop;
import com.mantis.data.entity.User;
import com.mantis.mapper.GarageMapper;
import com.mantis.mapper.UserMapper;
import com.mantis.repositories.GarageRepository;
import com.mantis.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GarageFilterLogic {

    @Autowired
    EntityManager em;

    @Autowired
    GarageRepository garageRepository;

     @Autowired
    UserRepository userRepository;

    UserMapper userMapper = new UserMapper();

    @Autowired
    AuthorizationLogic authorizationLogic;
    public Page<Garage> searchGarageByTerm(GarageFilterDTO garage, Pageable pageable) {
        UserDTO user = userMapper.toDTO(userRepository.findById(authorizationLogic.getSession().getId()).orElse(null));
        garage.setOwner(user);
        String sqlQuery= garage.getResultQuery();

        int pageNumber = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();

        int startPosition = pageNumber * pageSize;
        Query query = em.createNativeQuery(sqlQuery,Garage.class);
        query.setFirstResult(startPosition);
        query.setMaxResults(pageSize);
        garage.getResultQ(query);


        List<Garage> resultList = query.getResultList();

        // Fetch the total count for pagination
        Query countQuery = em.createNativeQuery(garage.getCountQuery(),Long.class);
        garage.getResultQ(countQuery);
        Long countValue = (Long) countQuery.getSingleResult();
        Integer totalCount = Long.valueOf(countValue).intValue();

        return new PageImpl<>(resultList,pageable,totalCount.longValue());
    }
}
