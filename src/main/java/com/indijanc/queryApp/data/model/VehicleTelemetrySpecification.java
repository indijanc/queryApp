package com.indijanc.queryApp.data.model;

import org.springframework.data.jpa.domain.Specification;

/**
 * Helper class for building the JPA specification from the filters
 */
public class VehicleTelemetrySpecification {
    public static Specification<VehicleTelemetry> stringKeyContains(String key, String value) {
        return (root, query, builder) -> {
            return builder.like(root.get(key), "%" + value + "%");
        };
    }

    public static Specification<VehicleTelemetry> stringKeyEquals(String key, String value) {
        return (root, query, builder) -> {
            return builder.like(root.get(key), value);
        };
    }

    public static Specification<VehicleTelemetry> floatKeyGte(String key, float value) {
        return (root, query, builder) -> {
            return builder.greaterThanOrEqualTo(root.get(key), value);
        };
    }

    public static Specification<VehicleTelemetry> floatKeyLt(String key, float value) {
        return (root, query, builder) -> {
            return builder.lt(root.get(key), value);
        };
    }
    public static Specification<VehicleTelemetry> intKeyGte(String key, int value) {
        return (root, query, builder) -> {
            return builder.ge(root.get(key), value);
        };
    }

    public static Specification<VehicleTelemetry> intKeyLt(String key, int value) {
        return (root, query, builder) -> {
            return builder.lt(root.get(key), value);
        };
    }
}
