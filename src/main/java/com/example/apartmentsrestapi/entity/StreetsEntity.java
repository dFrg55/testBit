package com.example.apartmentsrestapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

@Table(name="streets")
@NoArgsConstructor
public class StreetsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="city_id")
    private int city_id;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "street_id")
    private List<HousesEntity> HousesEntity;




}
