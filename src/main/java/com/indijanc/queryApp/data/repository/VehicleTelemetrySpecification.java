package com.indijanc.queryApp.data.repository;

import com.indijanc.queryApp.data.model.VehicleTelemetry;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

import static com.indijanc.queryApp.data.model.FieldName.DATE_TIME;

/**
 * Helper class for building the JPA specification from the filters
 */
public class VehicleTelemetrySpecification {
    public static Specification<VehicleTelemetry> orderByDateTimeDesc() {
        return (root, query, builder) -> {
            query.orderBy(builder.desc(root.get(DATE_TIME)));
            return null;
        };
    }

    public static Specification<VehicleTelemetry> stringKeyContains(String key, String value) {
        return (root, query, builder) -> builder.like(root.get(key), "%" + value + "%");
    }

    public static Specification<VehicleTelemetry> stringKeyEquals(String key, String value) {
        return (root, query, builder) -> builder.like(root.get(key), value);
    }

    public static Specification<VehicleTelemetry> doubleKeyGte(String key, Double value) {
        return (root, query, builder) -> builder.ge(root.get(key), value);
    }

    public static Specification<VehicleTelemetry> doubleKeyLt(String key, Double value) {
        return (root, query, builder) -> builder.lt(root.get(key), value);
    }

    public static Specification<VehicleTelemetry> intKeyGte(String key, int value) {
        return (root, query, builder) -> builder.ge(root.get(key), value);
    }

    public static Specification<VehicleTelemetry> intKeyLt(String key, int value) {
        return (root, query, builder) -> builder.lt(root.get(key), value);
    }

    public static Specification<VehicleTelemetry> dateTimeKeyGte(String key, LocalDateTime value) {
        return ((root, query, builder) -> builder.greaterThanOrEqualTo(root.<LocalDateTime>get(key), value));
    }

    public static Specification<VehicleTelemetry> dateTimeKeyLt(String key, LocalDateTime value) {
        return ((root, query, builder) -> builder.lessThan(root.<LocalDateTime>get(key), value));
    }

    public static Specification<VehicleTelemetry> booleanKeyEquals(String key, Boolean value) {
        return ((root, query, builder) -> builder.equal(root.get(key), value));
    }
}
