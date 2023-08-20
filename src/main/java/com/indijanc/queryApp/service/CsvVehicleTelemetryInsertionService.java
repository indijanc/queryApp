package com.indijanc.queryApp.service;

import com.indijanc.queryApp.data.model.VehicleTelemetry;
import com.indijanc.queryApp.data.repository.VehicleTelemetryRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

import static com.indijanc.queryApp.utility.ParseUtil.*;

/**
 * Service class for inserting the CSV data to the database
 */
@Service
public class CsvVehicleTelemetryInsertionService {
    private static final Logger log = LoggerFactory.getLogger(CsvVehicleTelemetryInsertionService.class);
    @Autowired
    private VehicleTelemetryRepository vehicleTelemetryRepository;

    public int insertVehicleData(MultipartFile file) throws IOException {
        List<VehicleTelemetry> insertList = new java.util.ArrayList<>(Collections.emptyList());

        try (CSVParser parser = new CSVParser(new InputStreamReader(file.getInputStream()), CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader())) {
            List<String> headerNames = parser.getHeaderNames();
            for (CSVRecord record : parser) {
                VehicleTelemetry.VehicleTelemetryBuilder builder = VehicleTelemetry.builder();
                insertList.add(createVehicleTelemetry(headerNames, record));
            }

            log.info("inserting {} tractor entries", insertList.size());
            // Rather insert in batches, or limit size on input
            vehicleTelemetryRepository.saveAll(insertList);
        }
        return insertList.size();
    }

    private VehicleTelemetry createVehicleTelemetry(List<String> headers, CSVRecord record) {
        VehicleTelemetry.VehicleTelemetryBuilder builder = VehicleTelemetry.builder();
        for (String header : headers) {
            if (header.toLowerCase().contains("date/time")) { builder.dateTime(parseDateTime(record.get(header))); }
            else if (header.toLowerCase().contains("serial number")) { builder.serialNumber(record.get(header)); }
            else if (header.toLowerCase().contains("gps longitude")) { builder.gpsLongitude(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("gps latitude")) { builder.gpsLatitude(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("total working hours")) { builder.totalWorkingHours(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("engine speed")) { builder.engineSpeed(parseIntOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("engine load")) { builder.engineLoad(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("fuel consumption")) { builder.fuelConsumption(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("ground speed radar")) { builder.groundSpeedRadar(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("ground speed")) { builder.groundSpeed(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("coolant temperature")) { builder.coolantTemperature(parseIntOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("speed front pto")) { builder.speedFrontPto(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("speed rear pto")) { builder.speedRearPto(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("current gear shift")) { builder.currentGearShift(parseIntOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("ambient temperature")) { builder.ambientTemperature(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("parking brake status")) { builder.parkingBreakStatus(parseIntOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("transverse differential lock status")) { builder.transverseDifferentialLockStatus(parseIntOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("all-wheel drive status")) { builder.allWheelDriveStatus(record.get(header)); }
            else if (header.toLowerCase().contains("actual status of creeper")) { builder.actualStatusOfCreeper(record.get(header)); }
            else if (header.toLowerCase().contains("drum speed")) { builder.drumSpeed(parseIntOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("fan speed")) { builder.fanSpeed(parseIntOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("rotor / straw walker speed")) { builder.strawWalkerSpeed(parseIntOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("separation losses")) { builder.separationLosses(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("sieve losses")) { builder.sieveLosses(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("chopper")) { builder.chopper(parseBoolean(record.get(header))); }
            else if (header.toLowerCase().contains("diesel tank level")) { builder.tankLevel(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("no. of partial widths")) { builder.partialWidthsCount(parseIntOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("front attachment")) { builder.frontAttachment(parseBoolean(record.get(header))); }
            else if (header.toLowerCase().contains("max. no. of partial widths")) { builder.partialWidthsMaxCount(parseIntOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("feed rake speed")) { builder.feedRakeSpeed(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("working position")) { builder.workingPosition(parseBoolean(record.get(header))); }
            else if (header.toLowerCase().contains("grain tank unloading")) { builder.grainTankUnloading(parseBoolean(record.get(header))); }
            else if (header.toLowerCase().contains("main drive status")) { builder.mainDriveStatus(parseBoolean(record.get(header))); }
            else if (header.toLowerCase().contains("concave position")) { builder.concavePos(parseIntOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("upper sieve position")) { builder.upperSievePos(parseIntOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("lower sieve position")) { builder.lowerSievePos(parseIntOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("grain tank 70")) { builder.grainTank70(parseBoolean(record.get(header))); }
            else if (header.toLowerCase().contains("grain tank 100")) { builder.grainTank100(parseBoolean(record.get(header))); }
            else if (header.toLowerCase().contains("grain moisture content")) { builder.grainMoistureContent(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("throughput")) { builder.throughput(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("radial spreader speed")) { builder.radialSpreaderSpeed(record.get(header)); }
            else if (header.toLowerCase().contains("grain in returns")) { builder.grainInReturns(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("channel position")) { builder.channelPos(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("yield measurement")) { builder.yieldMeasurement(parseBoolean(record.get(header))); }
            else if (header.toLowerCase().contains("returns auger measurement")) { builder.returnsAugerMeasurement(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("moisture measurement")) { builder.moistureMeasurement(parseBoolean(record.get(header))); }
            else if (header.toLowerCase().contains("type of crop")) { builder.typeOfCrop(record.get(header)); }
            else if (header.toLowerCase().contains("specific crop weight")) { builder.specificCropWeight(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("auto pilot status")) { builder.autoPilotStatus(parseBoolean(record.get(header))); }
            else if (header.toLowerCase().contains("cruise pilot status")) { builder.cruisePilotStatus(record.get(header)); }
            else if (header.toLowerCase().contains("rate of work")) { builder.rateOfWork(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("yield")) { builder.yield(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("quantimeter calibration factor")) { builder.quantimeterCalibrationFactor(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("separation sensitivity")) { builder.separationSensitivity(parseDoubleOrNull(record.get(header))); }
            else if (header.toLowerCase().contains("sieve sensitivity")) { builder.sieveSensitivity(parseDoubleOrNull(record.get(header))); }
            else {
                throw new RuntimeException("Unrecognized column " + header);
            }
        }
        return builder.build();
    }
}
