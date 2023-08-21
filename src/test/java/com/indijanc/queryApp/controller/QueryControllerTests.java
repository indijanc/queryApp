package com.indijanc.queryApp.controller;

import com.indijanc.queryApp.data.model.VehicleTelemetry;
import com.indijanc.queryApp.data.repository.VehicleTelemetryRepository;
import com.indijanc.queryApp.service.CsvVehicleTelemetryInsertionService;
import com.indijanc.queryApp.service.FilterSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.graphql.test.tester.GraphQlTester;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@GraphQlTest
public class QueryControllerTests {

    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    VehicleTelemetryRepository vehicleTelemetryRepositoryMock;

    @MockBean
    FilterSpecification filterSpecificationMock;

    @MockBean
    CsvVehicleTelemetryInsertionService csvVehicleTelemetryInsertionServiceMock;

    @Test
    @DisplayName("No entries returns empty list")
    void emptyList() {
        graphQlTester
                .document("{ telemetry { serialNumber } }")
                .execute()
                .errors()
                .verify()
                .path("telemetry")
                .entityList(VehicleTelemetry.class)
                .hasSize(0);
    }

    @Test
    @DisplayName("Response contains correct fields")
    void correctResponseFields() {
        String serialNumber = "A";
        Double gpsLongitude = 24.123;
        Double groundSpeed = 50.0;
        List<VehicleTelemetry> list = List.of(
                VehicleTelemetry.builder()
                        .serialNumber(serialNumber)
                        .dateTime(LocalDateTime.now())
                        .gpsLongitude(gpsLongitude)
                        .groundSpeed(groundSpeed)
                        .build()
        );
        Mockito.when(vehicleTelemetryRepositoryMock.findAll((Specification<VehicleTelemetry>) any())).thenReturn(list);

        graphQlTester
                .document("{ telemetry { dateTime, serialNumber, gpsLongitude, gpsLatitude, groundSpeed } }")
                .execute()
                .errors()
                .verify()

                .path("telemetry")
                .entityList(VehicleTelemetry.class)
                .hasSize(1)

                .path("telemetry[0].serialNumber")
                .entity(String.class)
                .isEqualTo(serialNumber)

                .path("telemetry[0].gpsLongitude")
                .entity(Double.class)
                .isEqualTo(gpsLongitude)

                .path("telemetry[0].groundSpeed")
                .entity(Double.class)
                .isEqualTo(groundSpeed)

                .path("telemetry[0].fuelConsumption")
                .pathDoesNotExist()

                .path("telemetry[0].frontAttachment")
                .pathDoesNotExist()

                .path("telemetry[0].separationLosses")
                .pathDoesNotExist();
    }

    @Test
    @DisplayName("Response contains correct number of entries")
    void correctNumberOfEntries() {
        List<VehicleTelemetry> list = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        int dataSize = 100;
        for (int i = 0; i < dataSize; i++) {
            list.add(VehicleTelemetry.builder()
                    .serialNumber("Serial " + i)
                    .dateTime(now.plusSeconds(i))
                    .build());
        }

        Mockito.when(vehicleTelemetryRepositoryMock.findAll((Specification<VehicleTelemetry>) any())).thenReturn(list);

        graphQlTester
                .document("{ telemetry { dateTime, serialNumber } }")
                .execute()
                .errors()
                .verify()

                .path("telemetry")
                .entityList(VehicleTelemetry.class)
                .hasSize(dataSize);
    }
}
