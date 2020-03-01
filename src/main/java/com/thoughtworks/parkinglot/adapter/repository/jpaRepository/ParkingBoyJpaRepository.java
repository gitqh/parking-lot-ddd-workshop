package com.thoughtworks.parkinglot.adapter.repository.jpaRepository;

import com.thoughtworks.parkinglot.domain.parkingBoy.model.GraduateParkingBoy;
import com.thoughtworks.parkinglot.domain.parkingBoy.model.ParkingBoyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author gitqh
 */
@Repository
public interface ParkingBoyJpaRepository extends JpaRepository<GraduateParkingBoy, ParkingBoyId> {

}
