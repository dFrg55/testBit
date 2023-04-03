package com.example.apartmentsrestapi.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="houses")
@Data
@NoArgsConstructor
public class HousesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private int id;

    @Column(name="number")
    private String number;

    @Column(name="street_id")
    private int street_id;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "house_id")
    private List<ApartmentsEntity> ApartmentsEntity;

//    @ManyToOne
//    private StreetsEntity streetsEntity;

}
