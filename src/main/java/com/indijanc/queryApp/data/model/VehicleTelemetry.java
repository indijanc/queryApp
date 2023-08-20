package com.indijanc.queryApp.data.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import static com.indijanc.queryApp.data.model.FieldName.DATE_TIME;
import static com.indijanc.queryApp.data.model.FieldName.SERIAL_NUMBER;

/**
 * Class represents the vehicle telemetry table in the database.
 * Considering this a time-series data stream per vehicle / serial number,
 * hence creating constraint on dateTime and serialNumber
 */
// TODO: Consider using an actual time-series database and revise this
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "dateTimeAndSerial", columnNames = {DATE_TIME, SERIAL_NUMBER})})
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleTelemetry {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime dateTime;
    @NotNull
    private String serialNumber;
    private Double gpsLongitude;
    private Double gpsLatitude;
    private Double totalWorkingHours;
    private Double groundSpeed;
    private Integer engineSpeed;
    private Double engineLoad;
    private Integer drumSpeed;
    private Integer fanSpeed;
    private Integer strawWalkerSpeed;
    private Double separationLosses;
    private Double sieveLosses;
    private Boolean chopper;
    private Double tankLevel;
    private Integer partialWidthsCount;
    private Boolean frontAttachment;
    private Integer partialWidthsMaxCount;
    private Double feedRakeSpeed;
    private Boolean workingPosition;
    private Boolean grainTankUnloading;
    private Boolean mainDriveStatus;
    private Integer concavePos;
    private Integer upperSievePos;
    private Integer lowerSievePos;
    private Boolean grainTank70;
    private Boolean grainTank100;
    private Double grainMoistureContent;
    private Double throughput;
    private String radialSpreaderSpeed;
    private Double grainInReturns;
    private Double channelPos;
    private Boolean yieldMeasurement;
    private Double returnsAugerMeasurement;
    private Boolean moistureMeasurement;
    private String typeOfCrop;
    private Double specificCropWeight;
    private Boolean autoPilotStatus;
    private String cruisePilotStatus;
    private Double rateOfWork;
    private Double yield;
    private Double quantimeterCalibrationFactor;
    private Double separationSensitivity;
    private Double sieveSensitivity;
    private Double fuelConsumption;
    private Integer coolantTemperature;
    private Double groundSpeedRadar;
    private Double speedFrontPto;
    private Double speedRearPto;
    private Integer currentGearShift;
    private Double ambientTemperature;
    private Integer parkingBreakStatus;
    private Integer transverseDifferentialLockStatus;
    private String allWheelDriveStatus;
    private String actualStatusOfCreeper;
}
