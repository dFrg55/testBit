package com.example.apartmentsrestapi.repository;

import com.example.apartmentsrestapi.entity.HousesEntity;
import com.example.apartmentsrestapi.entity.StreetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetsRepo extends JpaRepository<StreetsEntity, Integer> {


}
