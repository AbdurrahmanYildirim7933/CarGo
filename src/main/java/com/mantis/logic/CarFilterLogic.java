package com.mantis.logic;

import com.mantis.data.dto.CarFilterDTO;
import com.mantis.data.dto.GarageDTO;
import com.mantis.data.dto.GarageFilterDTO;
import com.mantis.data.dto.UserDTO;
import com.mantis.data.entity.Car;
import com.mantis.data.entity.Garage;
import com.mantis.mapper.GarageMapper;
import com.mantis.mapper.UserMapper;
import com.mantis.repositories.CarRepository;
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
public class CarFilterLogic {
    @Autowired
    EntityManager em;

    @Autowired
    GarageRepository garageRepository;

    @Autowired
    CarRepository carRepository;

    GarageMapper garageMapper = new GarageMapper();

    @Autowired
    AuthorizationLogic authorizationLogic;
    public Page<Car> searchGarageByTerm(CarFilterDTO car, Integer garageId, Pageable pageable) {
        GarageDTO garage = garageMapper.toDTO(garageRepository.findById(garageId).orElse(null));
        car.setGarage(garage);
        String sqlQuery= car.getResultQuery();

        int pageNumber = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();

        int startPosition = pageNumber * pageSize;
        Query query = em.createNativeQuery(sqlQuery,Car.class);
        query.setFirstResult(startPosition);
        query.setMaxResults(pageSize);
        car.getResultQ(query);


        List<Car> resultList = query.getResultList();

        // Fetch the total count for pagination
        Query countQuery = em.createNativeQuery(car.getCountQuery(),Long.class);
        car.getResultQ(countQuery);
        Long countValue = (Long) countQuery.getSingleResult();
        Integer totalCount = Long.valueOf(countValue).intValue();


        return new PageImpl<>(resultList,pageable,totalCount.longValue());
    }
}
