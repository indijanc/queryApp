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

import java.io.FileNotFoundException;

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
        int insertedEntries;
        if (file.getOriginalFilename().startsWith("LD_C")) {
            insertedEntries = csvVehicleTelemetryInsertionService.insertTractorData(file);
        }
        else if (file.getOriginalFilename().startsWith("LD_A")) {
            insertedEntries = csvVehicleTelemetryInsertionService.insertCombineData(file);
        }
        else {
            // Abusing the FileNotFoundException, create your own specific exception
            throw new FileNotFoundException("Unrecognized file. Upload tractor or combine data, must start with LD_A or LD_C respectively!");
        }

        return ResponseEntity.ok(GenericResponse.create()
                .withStatus(HttpStatus.OK.value())
                .withMessage("Inserted " + Integer.toString(insertedEntries) + " entries"));
    }
}
