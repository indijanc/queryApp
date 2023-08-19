# Project Name

The Query App!

## Table of Contents

- [Project Name](#project-name)
  - [Table of Contents](#table-of-contents)
  - [Project Description](#project-description)
  - [Usage](#usage)
    - [Prerequisites](#prerequisites)
    - [Configuration](#configuration)
    - [Running the Project](#running-the-project)
  - [Todo List](#todo-list)

## Project Description

The Query App is a small Spring Boot based application for prototyping data querying mechanics using a GraphQL interface. It enables insertion of specific and structured vehicle telemetry data via HTTP for local storage and provides an interface for querying it. The data and filtering options are defined with the GraphQL schema. Application software management is done via Maven.

## Usage

Clone the project, run `mvn spring-boot:run` and off you go! But read on for some more instructions and details.

### Prerequisites

- Java 11+
- Maven 3.5.0+ (if running with Maven)

### Configuration

When running with maven you can generally change the behaviour of the application using it's [application.yaml](/src/main/resources/application.yaml) file. The useful options are:
- Location of the database (default: ./data/telemetry)
- Enabling or disabling DB queries over a simple in-browser console
- Setting DB credentials
- Location of embedded Tomcat temporary files (default: ./tomcat)
- Enabling or disabling the GraphiQL testing console

### Running the Project

You can either build and run the app from source:
- Clone the project
- cd into the cloned directory
- Run `mvn spring-boot:run`

Or run the app using the pre-built and packaged JAR file available under Releases.

After initialization, the application will start listening on port 8080, accessible over HTTP. Use the following steps to test it's features:
1. Upload data files. The files must be in CSV format with correct structure. Currenty supports combine and tractor telemetry data format. The upload endpoint is available at `/telemetry/upload` - the data files can be easily uploaded with the curl command `curl -F file=@<path to CSV file> http://localhost:8080/telemetry/upload`
2. Check the data. You can use the credentials in [application.yaml](/src/main/resources/application.yaml) to access the [DB console](http://localhost:8080/h2-console) and check the stored telemetry data.
3. Run some queries. A good way to run queries against the provided endpoint `/graphql` is to use the Browser based [GraphiQL UI](http://localhost:8080/graphiql)

Here are some example queries:

Get all vehicles location and speed data
```
{
  telemetry {
    dateTime
    serialNumber
    gpsLongitude
    gpsLatitude
    groundSpeed
  }
}
```

Get sieve data from all combines within a time range (assuming combine is identified with a serial number containing 'C')
```
{
  telemetry(filter: {
    serialNumberFilter: { contains: "C" }
    dateTimeFilter: {gte: "2022-11-14T10:03:46", lt:"2022-11-14T10:04:31"}
  }) {
    dateTime
    sieveLosses
    sieveSensitivity
    upperSievePos
    lowerSievePos
  }
}
```

Get all entries for a specific vehicle when engine was running at 1975 rpm
```
{
  telemetry(filter: {
    serialNumberFilter: { equals: "C7502627" }
    engineSpeedFilter: { gte: 1975, lt: 1976 }
  }) {
    dateTime
    serialNumber
    gpsLongitude
    gpsLatitude
    totalWorkingHours
    groundSpeed
    engineSpeed
    engineLoad
    drumSpeed
    fanSpeed
    strawWalkerSpeed
    separationLosses
    sieveLosses
    chopper
    tankLevel
    partialWidthsCount
    frontAttachment
    partialWidthsMaxCount
    feedRakeSpeed
    workingPosition
    grainTankUnloading
    mainDriveStatus
    concavePos
    upperSievePos
    lowerSievePos
    grainTank70
    grainTank100
    grainMoistureContent
    throughput
    radialSpreaderSpeed
    grainInReturns
    channelPos
    yieldMeasurement
    returnsAugerMeasurement
    moistureMeasurement
    typeOfCrop
    specificCropWeight
    autoPilotStatus
    cruisePilotStatus
    rateOfWork
    yield
    quantimeterCalibrationFactor
    separationSensitivity
    sieveSensitivity
    fuelConsumption
    coolantTemperature
    groundSpeedRadar
    speedFrontPto
    speedRearPto
    currentGearShift
    ambientTemperature
    parkingBreakStatus
    transverseDifferentialLockStatus
    allWheelDriveStatus
    actualStatusOfCreeper
  }
}
```

Try other queries using the console autocomplete features. Results are always ordered by time in a descendint manner.

## Todo List

A list of tasks, refactoring and improvements planned to implement.

- Fix float precision, float insertion doesn't work well, can we live with rounding?
- Investigate the provided data, determine boolean values
- Error handling for GraphQL errors
- Investigate and possibly improve GraphQL to Object mapping/binding
- Tests!
- Change to a proper time-series database, seems like it would be the best fit
- Improve/refactor dynamic data fetching mechanism - investigate QueryDsl
