package com.indijanc.queryApp.data.model;

import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

/**
 * Helper class for building the JPA specification from the filters
 */
public class VehicleTelemetrySpecification {
    public static Specification<VehicleTelemetry> stringKeyContains(String key, String value) {
        return (root, query, builder) -> builder.like(root.get(key), "%" + value + "%");
    }

    public static Specification<VehicleTelemetry> stringKeyEquals(String key, String value) {
        return (root, query, builder) -> builder.like(root.get(key), value);
    }

    public static Specification<VehicleTelemetry> floatKeyGte(String key, float value) {
        return (root, query, builder) -> builder.ge(root.get(key), value);
    }

    public static Specification<VehicleTelemetry> floatKeyLt(String key, float value) {
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
}
