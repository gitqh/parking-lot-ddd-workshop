package com.thoughtworks.parkinglot.configcontext.adapter.repository;

import com.thoughtworks.parkinglot.configcontext.adapter.repository.entity.ParkingBoyConfigEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingBoyConfigJpaRepository extends JpaRepository<ParkingBoyConfigEntity, String> {
    Optional<ParkingBoyConfigEntity> findById(String id);
}
