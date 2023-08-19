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
    private Float gpsLongitude;
    private Float gpsLatitude;
    private Float totalWorkingHours;
    private Float groundSpeed;
    private Integer engineSpeed;
    private Float engineLoad;
    private Integer drumSpeed;
    private Integer fanSpeed;
    private Integer strawWalkerSpeed;
    private Float separationLosses;
    private Float sieveLosses;
    private String chopper;
    private Float tankLevel;
    private Integer partialWidthsCount;
    private String frontAttachment;
    private Integer partialWidthsMaxCount;
    private Float feedRakeSpeed;
    private String workingPosition;
    private String grainTankUnloading;
    private String mainDriveStatus;
    private Integer concavePos;
    private Integer upperSievePos;
    private Integer lowerSievePos;
    private String grainTank70;
    private String grainTank100;
    private Float grainMoistureContent;
    private Float throughput;
    private String radialSpreaderSpeed;
    private Float grainInReturns;
    private Float channelPos;
    private String yieldMeasurement;
    private Float returnsAugerMeasurement;
    private String moistureMeasurement;
    private String typeOfCrop;
    private Float specificCropWeight;
    private String autoPilotStatus;
    private String cruisePilotStatus;
    private Float rateOfWork;
    private Float yield;
    private Float quantimeterCalibrationFactor;
    private Float separationSensitivity;
    private Float sieveSensitivity;
    private Float fuelConsumption;
    private Integer coolantTemperature;
    private Float groundSpeedRadar;
    private Float speedFrontPto;
    private Float speedRearPto;
    private Integer currentGearShift;
    private Float ambientTemperature;
    private Integer parkingBreakStatus;
    private Integer transverseDifferentialLockStatus;
    private String allWheelDriveStatus;
    private String actualStatusOfCreeper;
}
