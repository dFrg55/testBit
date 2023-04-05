package com.example.apartmentsrestapi.repository;

import com.example.apartmentsrestapi.entity.CitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CitiesRepo extends JpaRepository<CitiesEntity, Integer>  {


}
