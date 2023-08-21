package com.indijanc.queryApp.service;

import com.indijanc.queryApp.controller.filter.*;
import com.indijanc.queryApp.data.model.VehicleTelemetry;
import com.indijanc.queryApp.data.repository.VehicleTelemetrySpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * Service for dynamic building of data retrieval operation
 */
@Service
public class FilterSpecification {

    /**
     * Method is used to translate the input filter definition into a specification for data retrieval
     *
     * @param filter Collection of filters from the GraphQL query
     * @return Specification<VehicleTelemetry> specification for data retrieval
     */
    // TODO: More investigation needed to possibly simplify this or make it more elegant with QueryDsl
    public Specification<VehicleTelemetry> build(TelemetryFilter filter) {
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
                    spec = spec.and(VehicleTelemetrySpecification.doubleKeyGte(
                            floatFilter.getFieldName(),
                            floatFilter.getGte()
                    ));
                }
                if (floatFilter.getLt() != null) {
                    spec = spec.and(VehicleTelemetrySpecification.doubleKeyLt(
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

            else if (fieldFilter instanceof BooleanFilter) {
                BooleanFilter booleanFilter = (BooleanFilter) fieldFilter;
                if (booleanFilter.getEquals() != null) {
                    spec = spec.and(VehicleTelemetrySpecification.booleanKeyEquals(
                            booleanFilter.getFieldName(),
                            booleanFilter.getEquals()
                    ));
                }
            }
        }

        return spec;
    }
}
