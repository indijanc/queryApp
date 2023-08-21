package com.indijanc.queryApp.controller;

import com.indijanc.queryApp.service.CsvVehicleTelemetryInsertionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TelemetryUploadController.class)
public class TelemetryUploadControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CsvVehicleTelemetryInsertionService csvVehicleTelemetryInsertionServiceMock;

    private final MockMultipartFile mockFile = new MockMultipartFile(
            "file", "file.csv", "text/plain", "dummy,dummy".getBytes());

    @Test
    @DisplayName("HTTP GET is not supported")
    void getNotAllowed() throws Exception {
        mockMvc.perform(get("/telemetry/upload"))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    @DisplayName("Uploading data returns number of inserted entries")
    void reportInsertedEntries() throws Exception {
        Mockito.when(csvVehicleTelemetryInsertionServiceMock.insertVehicleData(any())).thenReturn(250);

        mockMvc.perform(multipart("/telemetry/upload").file(mockFile))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Inserted 250 entries")));
    }

    @Test
    @DisplayName("Uploading same data returns data integrity error")
    void sameDataReportError() throws Exception {
        Mockito.when(csvVehicleTelemetryInsertionServiceMock.insertVehicleData(any())).thenThrow(DataIntegrityViolationException.class);

        mockMvc.perform(multipart("/telemetry/upload").file(mockFile))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Data integrity violation")));
    }
}
