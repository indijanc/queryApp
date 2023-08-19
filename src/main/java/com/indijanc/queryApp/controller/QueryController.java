package com.indijanc.queryApp.controller;

import com.indijanc.queryApp.controller.filter.*;
import com.indijanc.queryApp.data.model.VehicleTelemetry;
import com.indijanc.queryApp.data.repository.VehicleTelemetrySpecification;
import com.indijanc.queryApp.data.repository.VehicleTelemetryRepository;
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

    @QueryMapping
    public List<VehicleTelemetry> telemetry(@Argument TelemetryFilter filter) {
        Specification<VehicleTelemetry> spec = Specification.where(null);

        if (filter != null) {
            spec = buildFilterSpecification(filter);
        }

        List<VehicleTelemetry> retList = vehicleTelemetryRepository.findAll(spec);
        log.info("returning {} entries", retList.size());
        return retList;
    }

    /**
     * Method is used to translate the input filter definition into a specification for data retrieval
     *
     * @param filter Collection of filters from the GraphQL query
     * @return Specification<VehicleTelemetry> specification for data retrieval
     */
    // TODO: More investigation needed to possibly simplify this or make it more elegant with QueryDsl
    // TODO: Possibly push this to a service class
    private Specification<VehicleTelemetry> buildFilterSpecification(TelemetryFilter filter) {
        Specification<VehicleTelemetry> spec = VehicleTelemetrySpecification.orderByDateTimeDesc();

        for (FieldFilter fieldFilter : filter.getAllFieldFilters()) {

            if (fieldFilter instanceof StringFilter) {
                StringFilter stringFilter = (StringFilter) fieldFilter;
                if (stringFilter.getContains() != null) {
                    spec = spec.and(VehicleTelemetrySpecification.stringKeyContains(
                            stringFilter.getFieldName(),
                            stringFilter.getContains()
                    ));
                }
                if (stringFilter.getEquals() != null) {
                    spec = spec.and(VehicleTelemetrySpecification.stringKeyEquals(
                            stringFilter.getFieldName(),
                            stringFilter.getEquals()
                    ));
                }
            }

            else if (fieldFilter instanceof IntFilter) {
                IntFilter intFilter = (IntFilter) fieldFilter;
                if (intFilter.getGte() != null) {
                    spec = spec.and(VehicleTelemetrySpecification.intKeyGte(
                            intFilter.getFieldName(),
                            intFilter.getGte()
                    ));
                }
                if (intFilter.getLt() != null) {
                    spec = spec.and(VehicleTelemetrySpecification.intKeyLt(
                            intFilter.getFieldName(),
                            intFilter.getLt()
                    ));
                }
            }

            else if (fieldFilter instanceof FloatFilter) {
                FloatFilter floatFilter = (FloatFilter) fieldFilter;
                if (floatFilter.getGte() != null) {
                    spec = spec.and(VehicleTelemetrySpecification.floatKeyGte(
                            floatFilter.getFieldName(),
                            floatFilter.getGte()
                    ));
                }
                if (floatFilter.getLt() != null) {
                    spec = spec.and(VehicleTelemetrySpecification.floatKeyLt(
                            floatFilter.getFieldName(),
                            floatFilter.getLt()
                    ));
                }
            }

            else if (fieldFilter instanceof DateTimeFilter) {
                DateTimeFilter dateTimeFilter = (DateTimeFilter) fieldFilter;
                if (dateTimeFilter.getGte() != null) {
                    spec = spec.and(VehicleTelemetrySpecification.dateTimeKeyGte(
                            dateTimeFilter.getFieldName(),
                            dateTimeFilter.getGte()
                    ));
                }
                if (dateTimeFilter.getLt() != null) {
                    spec = spec.and(VehicleTelemetrySpecification.dateTimeKeyLt(
                            dateTimeFilter.getFieldName(),
                            dateTimeFilter.getLt()
                    ));
                }
            }
        }

        return spec;
    }

}
