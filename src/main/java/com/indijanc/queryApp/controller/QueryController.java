package com.indijanc.queryApp.controller;

import com.indijanc.queryApp.controller.filter.*;
import com.indijanc.queryApp.data.model.VehicleTelemetry;
import com.indijanc.queryApp.data.repository.VehicleTelemetrySpecification;
import com.indijanc.queryApp.data.repository.VehicleTelemetryRepository;
import com.indijanc.queryApp.service.FilterSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Controller for the GraphQL query.
 */
@Controller
public class QueryController {

    private static final Logger log = LoggerFactory.getLogger(QueryController.class);

    @Autowired
    VehicleTelemetryRepository vehicleTelemetryRepository;

    @Autowired
    FilterSpecification filterSpecification;

    @QueryMapping
    public List<VehicleTelemetry> telemetry(@Argument TelemetryFilter filter) {
        Specification<VehicleTelemetry> spec = filterSpecification.build(filter);

        List<VehicleTelemetry> retList = vehicleTelemetryRepository.findAll(spec);
        log.info("returning {} entries", retList.size());
        return retList;
    }
}
