package com.example.apartmentsrestapi.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="cities")
@NoArgsConstructor
@AllArgsConstructor

public class CitiesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "city_id")

    private List<StreetsEntity> StreetsEntity;


}
