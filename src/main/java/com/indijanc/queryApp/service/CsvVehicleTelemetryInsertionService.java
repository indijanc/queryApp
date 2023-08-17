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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import static com.indijanc.queryApp.data.model.VehicleTelemetry.DATETIME_FORMAT;

@Service
public class CsvVehicleTelemetryInsertionService {
    private static final Logger log = LoggerFactory.getLogger(CsvVehicleTelemetryInsertionService.class);
    @Autowired
    private VehicleTelemetryRepository vehicleTelemetryRepository;

    public int insertTractorData(MultipartFile file) throws IOException {
        List<VehicleTelemetry> insertList = new java.util.ArrayList<>(Collections.emptyList());

        try (CSVParser parser = new CSVParser(new InputStreamReader(file.getInputStream()), CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader())) {
            for (CSVRecord record : parser) {
                insertList.add(new VehicleTelemetry(LocalDateTime.parse(record.get(0), DateTimeFormatter.ofPattern(DATETIME_FORMAT)),
                        record.get(1), cleanFloat(record.get(2)), cleanFloat(record.get(3)),
                        cleanFloat(record.get(4)), cleanFloat(record.get(5)), cleanInt(record.get((6))),
                        cleanFloat(record.get(7)), cleanInt(record.get((8))),
                        cleanInt(record.get((9))), cleanInt(record.get((10))),
                        cleanFloat(record.get(11)), cleanFloat(record.get(12)), record.get(13),
                        cleanFloat(record.get(14)), cleanInt(record.get((15))), record.get(16),
                        cleanInt(record.get((17))), cleanFloat(record.get(18)), record.get(19),
                        record.get(20), record.get(21), cleanInt(record.get((22))),
                        cleanInt(record.get((23))), cleanInt(record.get((24))), record.get(25),
                        record.get(26), cleanFloat(record.get(27)), cleanFloat(record.get(28)),
                        record.get(29), cleanFloat(record.get(30)), cleanFloat(record.get(31)),
                        record.get(32), cleanFloat(record.get(33)), record.get(34), record.get(35),
                        cleanFloat(record.get(36)), record.get(37), record.get(38), cleanFloat(record.get(39)),
                        cleanFloat(record.get(40)), cleanFloat(record.get(41)), cleanFloat(record.get(42)),
                        cleanFloat(record.get(43))));
            }

            log.info("inserting {} tractor entries", insertList.size());
            // Rather insert in batches, or limit size on input
            vehicleTelemetryRepository.saveAll(insertList);
        }
        return insertList.size();
    }

    public int insertCombineData(MultipartFile file) throws IOException {
        List<VehicleTelemetry> insertList = new java.util.ArrayList<>(Collections.emptyList());

        try (CSVParser parser = new CSVParser(new InputStreamReader(file.getInputStream()), CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader())) {
            for (CSVRecord record : parser) {
                insertList.add(new VehicleTelemetry(LocalDateTime.parse(record.get(0), DateTimeFormatter.ofPattern(DATETIME_FORMAT)),
                        record.get(1), cleanFloat(record.get(2)), cleanFloat(record.get(3)),
                        cleanFloat(record.get(4)), cleanInt(record.get(5)), cleanFloat(record.get(6)),
                        cleanFloat(record.get(7)), cleanFloat(record.get(8)), record.get(9), cleanFloat(record.get(10)),
                        cleanFloat(record.get(11)), cleanFloat(record.get(12)), cleanInt(record.get(13)),
                        cleanFloat(record.get(14)), cleanInt(record.get(15)), cleanInt(record.get(16)), record.get(17),
                        record.get(18)));
            }

            log.info("inserting {} combine entries", insertList.size());
            // Rather insert in batches, or limit size on input
            vehicleTelemetryRepository.saveAll(insertList);
        }
        return insertList.size();
    }

    private float cleanFloat(String inputStr) {
        try {
            return Float.parseFloat(inputStr);
        }
        catch (NumberFormatException e) {
            log.warn("Failed to convert to float: {}", inputStr);
            return 0;
        }
    }

    private int cleanInt(String inputStr) {
        try {
            return Integer.parseInt(inputStr);
        }
        catch (NumberFormatException e) {
            log.warn("Failed to convert to int: {}", inputStr);
            return 0;
        }
    }
}
