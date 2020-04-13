package com.thoughtworks.parkinglot.configcontext.adapter.repository;

import com.thoughtworks.parkinglot.configcontext.adapter.repository.entity.ParkingManagerConfigEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingManagerConfigJpaRepository extends JpaRepository<ParkingManagerConfigEntity, String> {
    Optional<ParkingManagerConfigEntity> findById(String id);
}
