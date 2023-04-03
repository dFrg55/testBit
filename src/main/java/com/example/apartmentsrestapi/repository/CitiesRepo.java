package com.example.apartmentsrestapi.repository;

import com.example.apartmentsrestapi.entity.CitiesEntity;
import com.example.apartmentsrestapi.impl.CustomizedCitiesEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CitiesRepo extends JpaRepository<CitiesEntity, Integer>  {

    @Query(" SELECT ce.name , count (ce.name)  FROM CitiesEntity ce " +
            "JOIN StreetsEntity se ON ce.id=se.city_id " +
            "JOIN HousesEntity he ON se.id=he.street_id " +
            "GROUP BY ce.name"
    )
   List findAllHouse();
}
