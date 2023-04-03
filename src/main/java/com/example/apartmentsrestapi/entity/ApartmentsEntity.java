package com.example.apartmentsrestapi.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Table(name="apartments")
@NoArgsConstructor
public class ApartmentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private int id;

    @Column(name="area")
    private float area;

    @Column(name="house_id")
    private int house_id;

}
