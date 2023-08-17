package com.indijanc.queryApp.data.repository;

import com.indijanc.queryApp.data.model.VehicleTelemetry;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface VehicleTelemetryRepository extends JpaRepository<VehicleTelemetry, Long>, JpaSpecificationExecutor<VehicleTelemetry> {
    List<VehicleTelemetry> findBySerialNumber(String serialNumber);
    List<VehicleTelemetry> findAll(Specification<VehicleTelemetry> spec);
}
