package com.thoughtworks.parkinglot.adapter.repository.jpaRepository;

import com.thoughtworks.parkinglot.domain.parkingBoy.model.LicensePlate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicensePlateJpaRepository extends JpaRepository<LicensePlate, String> {

}
