package com.indijanc.queryApp.data.repository;

import com.indijanc.queryApp.controller.filter.*;
import com.indijanc.queryApp.data.model.VehicleTelemetry;
import com.indijanc.queryApp.service.FilterSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(FilterSpecification.class)
public class VehicleTelemetryRepositoryTests {

    @Autowired
    VehicleTelemetryRepository vehicleTelemetryRepository;

    @Autowired
    FilterSpecification filterSpecification;

    private List<VehicleTelemetry> testData;
    private static final String TEST_SERIAL_NUMBER = "A5304997";
    private static final int TEST_ENGINE_SPEED = 753;
    private static final String TEST_DATETIME = "2023-03-31T05:54:27";

    @BeforeEach
    void setUp() {
        createTestFixture();
        vehicleTelemetryRepository.saveAll(testData);
    }

    @Test
    @DisplayName("Repository without additional specification should return all entries")
    void returnAllEntries () {
        List<VehicleTelemetry> verifyList = vehicleTelemetryRepository.findAll();

        assertThat(verifyList.size()).isEqualTo(testData.size());
    }

    @Test
    @DisplayName("Filter for one serial number should return correct entries")
    void filterBySerialNumber () {
        TelemetryFilter filter = new TelemetryFilter();
        filter.setSerialNumberFilter(StringFilter.builder().equals(TEST_SERIAL_NUMBER).build());
        Specification<VehicleTelemetry> spec = filterSpecification.build(filter);

        List<VehicleTelemetry> verifyList = vehicleTelemetryRepository.findAll(spec);

        assertThat(verifyList.size()).isEqualTo(2);
        assertThat(verifyList.get(0).getSerialNumber()).isEqualTo(TEST_SERIAL_NUMBER);
        assertThat(verifyList.get(1).getSerialNumber()).isEqualTo(TEST_SERIAL_NUMBER);
    }

    @Test
    @DisplayName("Filter for one serial number and greater than or equal engine speed should return correct entries")
    void filterBySerialByEngineSpeed () {
        TelemetryFilter filter = new TelemetryFilter();
        filter.setSerialNumberFilter(StringFilter.builder().equals(TEST_SERIAL_NUMBER).build());
        filter.setEngineSpeedFilter(IntFilter.builder().gte(TEST_ENGINE_SPEED).build());
        Specification<VehicleTelemetry> spec = filterSpecification.build(filter);

        List<VehicleTelemetry> verifyList = vehicleTelemetryRepository.findAll(spec);

        assertThat(verifyList.size()).isEqualTo(1);
        assertThat(verifyList.get(0).getSerialNumber()).isEqualTo(TEST_SERIAL_NUMBER);
        assertThat(verifyList.get(0).getEngineSpeed()).isEqualTo(TEST_ENGINE_SPEED);
    }

    @Test
    @DisplayName("Filter for chopper should return correct entries")
    void filterByChopper () {
        TelemetryFilter filter = new TelemetryFilter();
        filter.setChopperFilter(BooleanFilter.builder().equals(false).build());
        Specification<VehicleTelemetry> spec = filterSpecification.build(filter);

        List<VehicleTelemetry> verifyList = vehicleTelemetryRepository.findAll(spec);

        assertThat(verifyList.size()).isEqualTo(1);
        assertThat(verifyList.get(0).getChopper()).isEqualTo(false);
    }

    @Test
    @DisplayName("Complex filter should return correct entries")
    void FilterByDateTimeByLongitudeByEngineLoad () {
        double testLongitude = 20.1759684;
        double testEnginLoadGte = 20.0;
        double testEngineLoadLt = 50.0;
        TelemetryFilter filter = new TelemetryFilter();
        filter.setDateTimeFilter(DateTimeFilter.builder()
                .lt(LocalDateTime.parse(TEST_DATETIME)) // Eliminated one entry
                .gte(LocalDateTime.parse("2022-11-12T10:13:01"))
                .build());
        filter.setGpsLongitudeFilter(FloatFilter.builder().gte(testLongitude).build()); // Eliminated another entry
        filter.setEngineLoadFilter(FloatFilter.builder().gte(testEnginLoadGte).lt(testEngineLoadLt).build()); // Eliminated another entry
        Specification<VehicleTelemetry> spec = filterSpecification.build(filter);

        List<VehicleTelemetry> verifyList = vehicleTelemetryRepository.findAll(spec);

        assertThat(verifyList.size()).isEqualTo(1);
        assertThat(verifyList.get(0).getGpsLongitude()).isGreaterThanOrEqualTo(testLongitude);
        assertThat(verifyList.get(0).getEngineLoad()).isGreaterThanOrEqualTo(testEnginLoadGte).isLessThan(testEngineLoadLt);
    }

    private void createTestFixture () {
            testData = List.of(
                    VehicleTelemetry.builder()
                            .dateTime(LocalDateTime.parse(TEST_DATETIME))
                            .serialNumber(TEST_SERIAL_NUMBER)
                            .gpsLongitude(20.4154522)
                            .gpsLatitude(45.3649405)
                            .totalWorkingHours(1185.36)
                            .engineSpeed(748)
                            .engineLoad(39.0)
                            .fuelConsumption(2.85)
                            .groundSpeed(0.0)
                            .groundSpeedRadar(0.0)
                            .coolantTemperature(14)
                            .speedFrontPto(0.0)
                            .speedRearPto(0.0)
                            .currentGearShift(5)
                            .ambientTemperature(10.59)
                            .transverseDifferentialLockStatus(3)
                            .allWheelDriveStatus("Active")
                            .actualStatusOfCreeper("Inactive")
                            .build(),
                    VehicleTelemetry.builder()
                            .dateTime(LocalDateTime.parse("2023-03-31T05:54:26"))
                            .serialNumber(TEST_SERIAL_NUMBER)
                            .gpsLongitude(20.4154438)
                            .gpsLatitude(45.3649366)
                            .totalWorkingHours(1185.37)
                            .engineSpeed(TEST_ENGINE_SPEED)
                            .engineLoad(40.0)
                            .fuelConsumption(2.75)
                            .groundSpeed(0.0)
                            .groundSpeedRadar(0.0)
                            .coolantTemperature(16)
                            .speedFrontPto(0.0)
                            .speedRearPto(0.0)
                            .currentGearShift(5)
                            .ambientTemperature(10.59)
                            .transverseDifferentialLockStatus(3)
                            .allWheelDriveStatus("Active")
                            .actualStatusOfCreeper("Inactive")
                            .build(),
                    VehicleTelemetry.builder()
                            .dateTime(LocalDateTime.parse("2022-12-12T10:13:04"))
                            .serialNumber("C7502627")
                            .gpsLongitude(20.1759685)
                            .gpsLatitude(45.3082947)
                            .totalWorkingHours(1153.88)
                            .groundSpeed(0.0)
                            .engineSpeed(1200)
                            .engineLoad(0.0)
                            .drumSpeed(0)
                            .fanSpeed(0)
                            .chopper(false)
                            .tankLevel(65.82)
                            .partialWidthsCount(8)
                            .frontAttachment(false)
                            .partialWidthsMaxCount(8)
                            .feedRakeSpeed(0.0)
                            .workingPosition(false)
                            .grainTankUnloading(false)
                            .mainDriveStatus(true)
                            .concavePos(11)
                            .upperSievePos(8)
                            .lowerSievePos(5)
                            .grainTank70(false)
                            .grainTank100(false)
                            .build(),
                    VehicleTelemetry.builder()
                            .dateTime(LocalDateTime.parse("2022-12-12T10:13:01"))
                            .serialNumber("C7502627")
                            .gpsLongitude(20.1759683)
                            .gpsLatitude(45.3082947)
                            .totalWorkingHours(1153.88)
                            .groundSpeed(0.0)
                            .engineSpeed(1200)
                            .engineLoad(0.0)
                            .drumSpeed(0)
                            .fanSpeed(0)
                            .chopper(true)
                            .tankLevel(65.82)
                            .partialWidthsCount(8)
                            .frontAttachment(false)
                            .partialWidthsMaxCount(8)
                            .feedRakeSpeed(0.0)
                            .workingPosition(false)
                            .grainTankUnloading(false)
                            .mainDriveStatus(true)
                            .concavePos(11)
                            .upperSievePos(8)
                            .lowerSievePos(5)
                            .grainTank70(false)
                            .grainTank100(false)
                            .build()

        );
    }
}
