package com.thoughtworks.parkinglot.configcontext.adapter.repository.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author gitqh
 */
@Entity
//@Table("parking_manager")
public class ParkingManagerConfigEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
