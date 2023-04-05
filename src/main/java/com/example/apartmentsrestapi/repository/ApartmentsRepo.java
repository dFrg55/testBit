package com.example.apartmentsrestapi.repository;

import com.example.apartmentsrestapi.entity.ApartmentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentsRepo extends JpaRepository<ApartmentsEntity, Integer> {
}
