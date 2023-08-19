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
// TODO: Refactor this, use builder class or similar instead
@Service
public class CsvVehicleTelemetryInsertionService {
    private static final Logger log = LoggerFactory.getLogger(CsvVehicleTelemetryInsertionService.class);
    @Autowired
    private VehicleTelemetryRepository vehicleTelemetryRepository;

    public int insertTractorData(MultipartFile file) throws IOException {
        List<VehicleTelemetry> insertList = new java.util.ArrayList<>(Collections.emptyList());

        try (CSVParser parser = new CSVParser(new InputStreamReader(file.getInputStream()), CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader())) {
            for (CSVRecord record : parser) {
                insertList.add(new VehicleTelemetry(parseDateTime(record.get(0)),
                        record.get(1), parseFloatOrNull(record.get(2)), parseFloatOrNull(record.get(3)),
                        parseFloatOrNull(record.get(4)), parseFloatOrNull(record.get(5)), parseIntOrNull(record.get((6))),
                        parseFloatOrNull(record.get(7)), parseIntOrNull(record.get((8))),
                        parseIntOrNull(record.get((9))), parseIntOrNull(record.get((10))),
                        parseFloatOrNull(record.get(11)), parseFloatOrNull(record.get(12)), record.get(13),
                        parseFloatOrNull(record.get(14)), parseIntOrNull(record.get((15))), record.get(16),
                        parseIntOrNull(record.get((17))), parseFloatOrNull(record.get(18)), record.get(19),
                        record.get(20), record.get(21), parseIntOrNull(record.get((22))),
                        parseIntOrNull(record.get((23))), parseIntOrNull(record.get((24))), record.get(25),
                        record.get(26), parseFloatOrNull(record.get(27)), parseFloatOrNull(record.get(28)),
                        record.get(29), parseFloatOrNull(record.get(30)), parseFloatOrNull(record.get(31)),
                        record.get(32), parseFloatOrNull(record.get(33)), record.get(34), record.get(35),
                        parseFloatOrNull(record.get(36)), record.get(37), record.get(38), parseFloatOrNull(record.get(39)),
                        parseFloatOrNull(record.get(40)), parseFloatOrNull(record.get(41)), parseFloatOrNull(record.get(42)),
                        parseFloatOrNull(record.get(43))));
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
                insertList.add(new VehicleTelemetry(parseDateTime(record.get(0)),
                        record.get(1), parseFloatOrNull(record.get(2)), parseFloatOrNull(record.get(3)),
                        parseFloatOrNull(record.get(4)), parseIntOrNull(record.get(5)), parseFloatOrNull(record.get(6)),
                        parseFloatOrNull(record.get(7)), parseFloatOrNull(record.get(8)), record.get(9), parseIntOrNull(record.get(10)),
                        parseFloatOrNull(record.get(11)), parseFloatOrNull(record.get(12)), parseIntOrNull(record.get(13)),
                        parseFloatOrNull(record.get(14)), parseIntOrNull(record.get(15)), parseIntOrNull(record.get(16)), record.get(17),
                        record.get(18)));
            }

            log.info("inserting {} combine entries", insertList.size());
            // Rather insert in batches, or limit size on input
            vehicleTelemetryRepository.saveAll(insertList);
        }
        return insertList.size();
    }
}
