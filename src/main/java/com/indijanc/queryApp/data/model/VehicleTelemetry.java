package com.indijanc.queryApp.data.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

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
public class VehicleTelemetry {

    public static final String DATETIME_FORMAT = "MMM d, yyyy, h:mm:ss a";

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
    private String groundSpeedRadar;
    private Float speedFrontPto;
    private Float speedRearPto;
    private Integer currentGearShift;
    private Float ambientTemperature;
    private Integer parkingBreakStatus;
    private Integer transverseDifferentialLockStatus;
    private String allWheelDriveStatus;
    private String actualStatusOfCreeper;

    protected VehicleTelemetry() {}

    public VehicleTelemetry(LocalDateTime datetime, String serialNumber, Float gpsLongitude, Float gpsLatitude,
                            Float totalWorkingHours, Float groundSpeed, Integer engineSpeed, Float engineLoad, Integer drumSpeed,
                            Integer fanSpeed, Integer strawWalkerSpeed, Float separationLosses, Float sieveLosses,
                            String chopper, Float tankLevel, Integer partialWidthsCount, String frontAttachment,
                            int partialWidthsMaxCount, Float feedRakeSpeed, String workingPosition,
                            String grainTankUnloading, String mainDriveStatus, Integer concavePos, Integer upperSievePos,
                            Integer lowerSievePos, String grainTank70, String grainTank100, Float grainMoistureContent,
                            Float throughput, String radialSpreaderSpeed, Float grainInReturns, Float channelPos,
                            String yieldMeasurement, Float returnsAugerMeasurement, String moistureMeasurement,
                            String typeOfCrop, Float specificCropWeight, String autoPilotStatus, String cruisePilotStatus,
                            Float rateOfWork, Float yield, Float quantimeterCalibrationFactor, Float separationSensitivity,
                            Float sieveSensitivity) {
        this.dateTime = datetime;
        this.serialNumber = serialNumber;
        this.gpsLongitude = gpsLongitude;
        this.gpsLatitude = gpsLatitude;
        this.totalWorkingHours = totalWorkingHours;
        this.groundSpeed = groundSpeed;
        this.engineSpeed = engineSpeed;
        this.engineLoad = engineLoad;
        this.drumSpeed = drumSpeed;
        this.fanSpeed = fanSpeed;
        this.strawWalkerSpeed = strawWalkerSpeed;
        this.separationLosses = separationLosses;
        this.sieveLosses = sieveLosses;
        this.chopper = chopper;
        this.tankLevel = tankLevel;
        this.partialWidthsCount = partialWidthsCount;
        this.frontAttachment = frontAttachment;
        this.partialWidthsMaxCount = partialWidthsMaxCount;
        this.feedRakeSpeed = feedRakeSpeed;
        this.workingPosition = workingPosition;
        this.grainTankUnloading = grainTankUnloading;
        this.mainDriveStatus = mainDriveStatus;
        this.concavePos = concavePos;
        this.upperSievePos = upperSievePos;
        this.lowerSievePos = lowerSievePos;
        this.grainTank70 = grainTank70;
        this.grainTank100 = grainTank100;
        this.grainMoistureContent = grainMoistureContent;
        this.throughput = throughput;
        this.radialSpreaderSpeed = radialSpreaderSpeed;
        this.grainInReturns = grainInReturns;
        this.channelPos = channelPos;
        this.yieldMeasurement = yieldMeasurement;
        this.returnsAugerMeasurement = returnsAugerMeasurement;
        this.moistureMeasurement = moistureMeasurement;
        this.typeOfCrop = typeOfCrop;
        this.specificCropWeight = specificCropWeight;
        this.autoPilotStatus = autoPilotStatus;
        this.cruisePilotStatus = cruisePilotStatus;
        this.rateOfWork = rateOfWork;
        this.yield = yield;
        this.quantimeterCalibrationFactor = quantimeterCalibrationFactor;
        this.separationSensitivity = separationSensitivity;
        this.sieveSensitivity = sieveSensitivity;
    }

    public VehicleTelemetry(LocalDateTime datetime, String serialNumber, Float gpsLongitude, Float gpsLatitude,
                            Float totalWorkingHours, Integer engineSpeed, Float engineLoad, Float fuelConsumption,
                            Float groundSpeed, String groundSpeedRadar, Integer coolantTemperature,
                            Float speedFrontPto, Float speedRearPto, Integer currentGearShift, Float ambientTemperature,
                            Integer parkingBreakStatus, Integer transverseDifferentialLockStatus,
                            String allWheelDriveStatus, String actualStatusOfCreeper) {
        this.dateTime = datetime;
        this.serialNumber = serialNumber;
        this.gpsLongitude = gpsLongitude;
        this.gpsLatitude = gpsLatitude;
        this.totalWorkingHours = totalWorkingHours;
        this.engineSpeed = engineSpeed;
        this.engineLoad = engineLoad;
        this.fuelConsumption = fuelConsumption;
        this.groundSpeed = groundSpeed;
        this.groundSpeedRadar = groundSpeedRadar;
        this.coolantTemperature = coolantTemperature;
        this.speedFrontPto = speedFrontPto;
        this.speedRearPto = speedRearPto;
        this.currentGearShift = currentGearShift;
        this.ambientTemperature = ambientTemperature;
        this.parkingBreakStatus = parkingBreakStatus;
        this.transverseDifferentialLockStatus = transverseDifferentialLockStatus;
        this.allWheelDriveStatus = allWheelDriveStatus;
        this.actualStatusOfCreeper = actualStatusOfCreeper;
    }

    @Override
    public String toString() {
        return String.format(
                "VehicleTelemetry[id=%d, serialNumber='%s', dateTime='%s']",
                id, serialNumber, dateTime.toString());
    }

    public Long getId() { return id; }
    public LocalDateTime getDateTime() { return dateTime; }
    public String getSerialNumber() { return serialNumber; }
    public Float getGpsLongitude() { return gpsLongitude; }
    public Float getGpsLatitude() { return gpsLatitude; }
    public Float getTotalWorkingHours() { return totalWorkingHours; }
    public Float getGroundSpeed () { return groundSpeed; }
    public Integer getEngineSpeed() { return engineSpeed; }
    public Float getEngineLoad() { return engineLoad; }
    public Integer getDrumSpeed() { return drumSpeed; }
    public Integer getFanSpeed() { return fanSpeed; }
    public Integer getStrawWalkerSpeed() { return strawWalkerSpeed; }
    public Float getSeparationLosses() { return separationLosses; }
    public Float getSieveLosses() { return sieveLosses; }
    public String getChopper() { return chopper; }
    public Float getTankLevel() { return tankLevel; }
    public Integer getPartialWidthsCount() { return partialWidthsCount; }
    public String getFrontAttachment() { return frontAttachment; }
    public Integer getPartialWidthsMaxCount() { return partialWidthsMaxCount; }
    public Float getFeedRakeSpeed() { return feedRakeSpeed; }
    public String getWorkingPosition() { return workingPosition; }
    public String getGrainTankUnloading() { return grainTankUnloading; }
    public String getMainDriveStatus() { return mainDriveStatus; }
    public Integer getConcavePos() { return concavePos; }
    public Integer getUpperSievePos() { return upperSievePos; }
    public Integer getLowerSievePos() { return lowerSievePos; }
    public String getGrainTank70() { return grainTank70; }
    public String getGrainTank100() { return grainTank100; }
    public Float getGrainMoistureContent() { return grainMoistureContent; }
    public Float getThroughput() { return throughput; }
    public String getRadialSpreaderSpeed() { return radialSpreaderSpeed; }
    public Float getGrainInReturns() { return grainInReturns; }
    public Float getChannelPos() { return channelPos; }
    public String getYieldMeasurement() { return yieldMeasurement; }
    public Float getReturnsAugerMeasurement() { return returnsAugerMeasurement; }
    public String getMoistureMeasurement() { return moistureMeasurement; }
    public String getTypeOfCrop() { return typeOfCrop; }
    public Float getSpecificCropWeight() { return specificCropWeight; }
    public String getAutoPilotStatus() { return autoPilotStatus; }
    public String getCruisePilotStatus() { return cruisePilotStatus; }
    public Float getRateOfWork() { return rateOfWork; }
    public Float getYield() { return yield; }
    public Float getQuantimeterCalibrationFactor() { return quantimeterCalibrationFactor; }
    public Float getSeparationSensitivity() { return separationSensitivity; }
    public Float getSieveSensitivity() { return sieveSensitivity; }
    public Float getFuelConsumption() { return fuelConsumption; }
    public Integer getCoolantTemperature() { return coolantTemperature; }
    public String getGroundSpeedRadar() { return groundSpeedRadar; }
    public Float getSpeedFrontPto() { return speedFrontPto; }
    public Float getSpeedRearPto() { return speedRearPto; }
    public Integer getCurrentGearShift() { return currentGearShift; }
    public Float getAmbientTemperature() { return ambientTemperature; }
    public Integer getParkingBreakStatus() { return parkingBreakStatus; }
    public Integer getTransverseDifferentialLockStatus() { return transverseDifferentialLockStatus; }
    public String getAllWheelDriveStatus() { return allWheelDriveStatus; }
    public String getActualStatusOfCreeper() { return actualStatusOfCreeper; }
}
