package com.example.apartmentsrestapi.repository;

import com.example.apartmentsrestapi.entity.ApartmentsEntity;
import com.example.apartmentsrestapi.entity.HousesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousesRepo extends JpaRepository<HousesEntity, Integer> {
}
