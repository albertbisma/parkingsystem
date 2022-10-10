package com.apps.parkingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apps.parkingsystem.entity.VehicleTypes;

@Transactional
@Repository
public interface VehicleTypesRepository extends JpaRepository<VehicleTypes, Integer> {

}
