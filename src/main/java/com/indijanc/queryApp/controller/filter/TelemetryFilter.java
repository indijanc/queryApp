package com.indijanc.queryApp.controller.filter;

import java.util.ArrayList;
import java.util.List;

import static com.indijanc.queryApp.data.model.FieldName.*;

public class TelemetryFilter {
    List<FieldFilter> allFieldFilters = new ArrayList<>();

    public FieldFilter getSerialNumberFilter() { return filterLookup(SERIAL_NUMBER); }
    public FieldFilter getGroundSpeedFilter() { return filterLookup(GROUND_SPEED); }
    public FieldFilter getEngineSpeedFilter() { return filterLookup(ENGINE_SPEED); }
    public FieldFilter getGroundSpeedRadarFilter() { return filterLookup(GROUND_SPEED_RADAR); }
    public FieldFilter getEngineLoadFilter() { return filterLookup(ENGINE_LOAD); }
    public FieldFilter getGpsLongitudeFilter() { return filterLookup(GPS_LONGITUDE); }
    public FieldFilter getGpsLatitudeFilter() { return filterLookup(GPS_LATITUDE); }
    public FieldFilter getTotalWorkingHoursFilter() { return filterLookup(TOTAL_WORKING_HOURS); }
    public FieldFilter getDrumSpeedFilter() { return filterLookup(DRUM_SPEED); }
    public FieldFilter getFanSpeedFilter() { return filterLookup(FAN_SPEED); }
    public FieldFilter getStrawWalkerSpeedFilter() { return filterLookup(STRAW_WALKER_SPEED); }
    public FieldFilter getSeparationLossesFilter() { return filterLookup(SEPARATION_LOSSES); }
    public FieldFilter getSieveLossesFilter() { return filterLookup(SIEVE_LOSSES); }
    public FieldFilter getChopperFilter() { return filterLookup(CHOPPER); }
    public FieldFilter getTankLevelFilter() { return filterLookup(TANK_LEVEL); }
    public FieldFilter getPartialWidthsCountFilter() { return filterLookup(PARTIAL_WIDTHS_COUNT); }
    public FieldFilter getFrontAttachmentFilter() { return filterLookup(FRONT_ATTACHMENT); }
    public FieldFilter getPartialWidthsMaxCountFilter() { return filterLookup(PARTIAL_WIDTHS_MAX_COUNT); }
    public FieldFilter getFeedRakeSpeedFilter() { return filterLookup(FEED_RAKE_SPEED); }
    public FieldFilter getWorkingPositionFilter() { return filterLookup(WORKING_POSITION); }
    public FieldFilter getGrainTankUnloadingFilter() { return filterLookup(GRAIN_TANK_UNLOADING); }
    public FieldFilter getMainDriveStatusFilter() { return filterLookup(MAIN_DRIVE_STATUS); }
    public FieldFilter getConcavePosFilter() { return filterLookup(CONCAVE_POS); }
    public FieldFilter getUpperSievePosFilter() { return filterLookup(UPPER_SIEVE_POS); }
    public FieldFilter getLowerSievePosFilter() { return filterLookup(LOWER_SIEVE_POS); };
    public FieldFilter getGrainTank70Filter() { return filterLookup(GRAIN_TANK_70); }
    public FieldFilter getGrainTank100Filter() { return filterLookup(GRAIN_TANK_100); }
    public FieldFilter getGrainMoistureContentFilter() { return filterLookup(GRAIN_MOISTURE_CONTENT); }
    public FieldFilter getThroughputFilter() { return filterLookup(THROUGHPUT); }
    public FieldFilter getRadialSpreaderSpeedFilter() { return filterLookup(RADIAL_SPREADER_SPEED); }
    public FieldFilter getGrainInReturnsFilter() { return filterLookup(GRAIN_IN_RETURNS); }
    public FieldFilter getChannelPosFilter() { return filterLookup(CHANNEL_POS); }
    public FieldFilter getYieldMeasurementFilter() { return filterLookup(YIELD_MEASUREMENT); }
    public FieldFilter getReturnsAugerMeasurementFilter() { return filterLookup(RETURNS_AUGER_MEASUREMENT); }
    public FieldFilter getMoistureMeasurementFilter() { return filterLookup(MOISTURE_MEASUREMENT); }
    public FieldFilter getTypeOfCropFilter() { return filterLookup(TYPE_OF_CROP); }
    public FieldFilter getSpecificCropWeightFilter() { return filterLookup(SPECIFIC_CROP_WEIGHT); }
    public FieldFilter getAutoPilotStatusFilter() { return filterLookup(AUTO_PILOT_STATUS); }
    public FieldFilter getCruisePilotStatusFilter() { return filterLookup(CRUISE_PILOT_STATUS); }
    public FieldFilter getRateOfWorkFilter() { return filterLookup(RATE_OF_WORK); }
    public FieldFilter getYieldFilter() { return filterLookup(YIELD); }
    public FieldFilter getQuantimeterCalibrationFactorFilter() { return filterLookup(QUANTIMETER_CALIBRATION_FACTOR); }
    public FieldFilter getSeparationSensitivityFilter() { return filterLookup(SEPARATION_SENSITIVITY); }
    public FieldFilter getSieveSensitivityFilter() { return filterLookup(SIEVE_SENSITIVITY); }
    public FieldFilter getFuelConsumptionFilter() { return filterLookup(FUEL_CONSUMPTION); }
    public FieldFilter getCoolantTemperatureFilter() { return filterLookup(COOLANT_TEMPERATURE); }
    public FieldFilter getSpeedFrontPtoFilter() { return filterLookup(SPEED_FRONT_PTO); }
    public FieldFilter getSpeedRearPtoFilter() { return filterLookup(SPEED_REAR_PTO); }
    public FieldFilter getCurrentGearShiftFilter() { return filterLookup(CURRENT_GEAR_SHIFT); }
    public FieldFilter getAmbientTemperatureFilter() { return filterLookup(AMBIENT_TEMPERATURE); }
    public FieldFilter getParkingBreakStatusFilter() { return filterLookup(PARKING_BREAK_STATUS); }
    public FieldFilter getTransverseDifferentialLockStatusFilter() { return filterLookup(TRANSVERSE_DIFFERENTIAL_LOCK_STATUS); }
    public FieldFilter getAllWheelDriveStatusFilter() { return filterLookup(ALL_WHEEL_DRIVE_STATUS); }
    public FieldFilter getActualStatusOfCreeperFilter() { return filterLookup(ACTUAL_STATUS_OF_CREEPER); }

    public List<FieldFilter> getAllFieldFilters() {
        return allFieldFilters;
    }

    private FieldFilter filterLookup (String fieldName) {
        return allFieldFilters.stream()
                .filter(f -> f.getFieldName().equals(fieldName))
                .findFirst().orElse(null);
    }

    public void setSerialNumberFilter(StringFilter stringFilter) {
        stringFilter.setFieldName(SERIAL_NUMBER);
        allFieldFilters.add(stringFilter);
    }

    public void setEngineSpeedFilter(IntFilter intFilter) {
        intFilter.setFieldName(ENGINE_SPEED);
        allFieldFilters.add(intFilter);
    }

    public void setGroundSpeedFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(GROUND_SPEED);
        allFieldFilters.add(floatFilter);
    }

    public void setActualStatusOfCreeperFilter(StringFilter stringFilter) {
        stringFilter.setFieldName(ACTUAL_STATUS_OF_CREEPER);
        allFieldFilters.add(stringFilter);
    }

    public void setGpsLatitudeFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(GPS_LATITUDE);
        allFieldFilters.add(floatFilter);
    }

    public void setGpsLongitudeFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(GPS_LONGITUDE);
        allFieldFilters.add(floatFilter);
    }

    public void setTotalWorkingHoursFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(TOTAL_WORKING_HOURS);
        allFieldFilters.add(floatFilter);
    }

    public void setEngineLoadFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(ENGINE_LOAD);
        allFieldFilters.add(floatFilter);
    }

    public void setDrumSpeedFilter(IntFilter intFilter) {
        intFilter.setFieldName(DRUM_SPEED);
        allFieldFilters.add(intFilter);
    }

    public void setFanSpeedFilter(IntFilter intFilter) {
        intFilter.setFieldName(FAN_SPEED);
        allFieldFilters.add(intFilter);
    }

    public void setStrawWalkerSpeedFilter(IntFilter intFilter) {
        intFilter.setFieldName(STRAW_WALKER_SPEED);
        allFieldFilters.add(intFilter);
    }

    public void setSeparationLossesFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(SEPARATION_LOSSES);
        allFieldFilters.add(floatFilter);
    }

    public void setSieveLossesFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(SIEVE_LOSSES);
        allFieldFilters.add(floatFilter);
    }

    public void setChopperFilter(StringFilter stringFilter) {
        stringFilter.setFieldName(CHOPPER);
        allFieldFilters.add(stringFilter);
    }

    public void setTankLevelFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(TANK_LEVEL);
        allFieldFilters.add(floatFilter);
    }

    public void setPartialWidthsCountFilter(IntFilter intFilter) {
        intFilter.setFieldName(PARTIAL_WIDTHS_COUNT);
        allFieldFilters.add(intFilter);
    }

    public void setFrontAttachmentFilter(StringFilter stringFilter) {
        stringFilter.setFieldName(FRONT_ATTACHMENT);
        allFieldFilters.add(stringFilter);
    }

    public void setPartialWidthsMaxCountFilter(IntFilter intFilter) {
        intFilter.setFieldName(PARTIAL_WIDTHS_MAX_COUNT);
        allFieldFilters.add(intFilter);
    }

    public void setFeedRakeSpeedFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(FEED_RAKE_SPEED);
        allFieldFilters.add(floatFilter);
    }

    public void setWorkingPositionFilter(StringFilter stringFilter) {
        stringFilter.setFieldName(WORKING_POSITION);
        allFieldFilters.add(stringFilter);
    }

    public void setGrainTankUnloadingFilter(StringFilter stringFilter) {
        stringFilter.setFieldName(GRAIN_TANK_UNLOADING);
        allFieldFilters.add(stringFilter);
    }

    public void setMainDriveStatusFilter(StringFilter stringFilter) {
        stringFilter.setFieldName(MAIN_DRIVE_STATUS);
        allFieldFilters.add(stringFilter);
    }

    public void setConcavePosFilter(IntFilter intFilter) {
        intFilter.setFieldName(CONCAVE_POS);
        allFieldFilters.add(intFilter);
    }

    public void setUpperSievePosFilter(IntFilter intFilter) {
        intFilter.setFieldName(UPPER_SIEVE_POS);
        allFieldFilters.add(intFilter);
    }

    public void setLowerSievePosFilter(IntFilter intFilter) {
        intFilter.setFieldName(LOWER_SIEVE_POS);
        allFieldFilters.add(intFilter);
    }

    public void setGrainTank70Filter(StringFilter stringFilter) {
        stringFilter.setFieldName(GRAIN_TANK_70);
        allFieldFilters.add(stringFilter);
    }

    public void setGrainTank100Filter(StringFilter stringFilter) {
        stringFilter.setFieldName(GRAIN_TANK_100);
        allFieldFilters.add(stringFilter);
    }

    public void setGrainMoistureContentFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(GRAIN_MOISTURE_CONTENT);
        allFieldFilters.add(floatFilter);
    }

    public void setThroughputFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(THROUGHPUT);
        allFieldFilters.add(floatFilter);
    }

    public void setRadialSpreaderSpeedFilter(StringFilter stringFilter) {
        stringFilter.setFieldName(RADIAL_SPREADER_SPEED);
        allFieldFilters.add(stringFilter);
    }

    public void setGrainInReturnsFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(GRAIN_IN_RETURNS);
        allFieldFilters.add(floatFilter);
    }

    public void setChannelPosFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(CHANNEL_POS);
        allFieldFilters.add(floatFilter);
    }

    public void setYieldMeasurementFilter(StringFilter stringFilter) {
        stringFilter.setFieldName(YIELD_MEASUREMENT);
        allFieldFilters.add(stringFilter);
    }

    public void setReturnsAugerMeasurementFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(RETURNS_AUGER_MEASUREMENT);
        allFieldFilters.add(floatFilter);
    }

    public void setMoistureMeasurementFilter(StringFilter stringFilter) {
        stringFilter.setFieldName(MOISTURE_MEASUREMENT);
        allFieldFilters.add(stringFilter);
    }

    public void setTypeOfCropFilter(StringFilter stringFilter) {
        stringFilter.setFieldName(TYPE_OF_CROP);
        allFieldFilters.add(stringFilter);
    }

    public void setSpecificCropWeightFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(SPECIFIC_CROP_WEIGHT);
        allFieldFilters.add(floatFilter);
    }

    public void setAutoPilotStatusFilter(StringFilter stringFilter) {
        stringFilter.setFieldName(AUTO_PILOT_STATUS);
        allFieldFilters.add(stringFilter);
    }

    public void setCruisePilotStatusFilter(StringFilter stringFilter) {
        stringFilter.setFieldName(CRUISE_PILOT_STATUS);
        allFieldFilters.add(stringFilter);
    }

    public void setRateOfWorkFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(RATE_OF_WORK);
        allFieldFilters.add(floatFilter);
    }

    public void setYieldFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(YIELD);
        allFieldFilters.add(floatFilter);
    }

    public void setQuantimeterCalibrationFactorFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(QUANTIMETER_CALIBRATION_FACTOR);
        allFieldFilters.add(floatFilter);
    }

    public void setSeparationSensitivityFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(SEPARATION_SENSITIVITY);
        allFieldFilters.add(floatFilter);
    }

    public void setSieveSensitivityFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(SIEVE_SENSITIVITY);
        allFieldFilters.add(floatFilter);
    }

    public void setFuelConsumptionFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(FUEL_CONSUMPTION);
        allFieldFilters.add(floatFilter);
    }

    public void setCoolantTemperatureFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(COOLANT_TEMPERATURE);
        allFieldFilters.add(floatFilter);
    }

    public void setGroundSpeedRadarFilter(StringFilter stringFilter) {
        stringFilter.setFieldName(GROUND_SPEED_RADAR);
        allFieldFilters.add(stringFilter);
    }

    public void setSpeedFrontPtoFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(SPEED_FRONT_PTO);
        allFieldFilters.add(floatFilter);
    }

    public void setSpeedRearPtoFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(SPEED_REAR_PTO);
        allFieldFilters.add(floatFilter);
    }

    public void setCurrentGearShiftFilter(IntFilter intFilter) {
        intFilter.setFieldName(CURRENT_GEAR_SHIFT);
        allFieldFilters.add(intFilter);
    }

    public void setAmbientTemperatureFilter(FloatFilter floatFilter) {
        floatFilter.setFieldName(AMBIENT_TEMPERATURE);
        allFieldFilters.add(floatFilter);
    }

    public void setParkingBreakStatusFilter(IntFilter intFilter) {
        intFilter.setFieldName(PARKING_BREAK_STATUS);
        allFieldFilters.add(intFilter);
    }

    public void setTransverseDifferentialLockStatusFilter(IntFilter intFilter) {
        intFilter.setFieldName(TRANSVERSE_DIFFERENTIAL_LOCK_STATUS);
        allFieldFilters.add(intFilter);
    }

    public void setAllWheelDriveStatusFilter(StringFilter stringFilter) {
        stringFilter.setFieldName(ALL_WHEEL_DRIVE_STATUS);
        allFieldFilters.add(stringFilter);
    }
}
