package com.indijanc.queryApp.controller;

import com.indijanc.queryApp.service.CsvVehicleTelemetryInsertionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

/**
 * Controller for uploading telemetry data.
 */
@Controller
@RequestMapping("/telemetry")
public class TelemetryUploadController {
    private static final Logger log = LoggerFactory.getLogger(TelemetryUploadController.class);

    @Autowired
    private CsvVehicleTelemetryInsertionService csvVehicleTelemetryInsertionService;

    @PostMapping("/upload")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<GenericResponse> uploadTelemetry(@RequestParam("file") MultipartFile file) throws Exception {
        log.info("Received file named {} with size {}", file.getOriginalFilename(), file.getSize());
        int insertedEntries = csvVehicleTelemetryInsertionService.insertVehicleData(file);

        return ResponseEntity.ok(GenericResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Inserted " + Integer.toString(insertedEntries) + " entries")
                .build());
    }
}
