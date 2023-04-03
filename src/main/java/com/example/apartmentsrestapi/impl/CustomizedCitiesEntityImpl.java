package com.example.apartmentsrestapi.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomizedCitiesEntityImpl implements CustomizedCitiesEntity{
    @PersistenceContext
    private EntityManager em;
    @Override
    public List getCountHouseInCities() {

        return em.createQuery(" FROM CitiesEntity ce " +
                        "JOIN StreetsEntity se ON ce.id=se.city_id " +
                        "JOIN HousesEntity he ON se.id=he.street_id " )
                .getResultList();
    }
}
