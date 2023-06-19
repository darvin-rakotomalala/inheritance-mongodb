package com.poc;

import com.poc.model.*;
import com.poc.service.AeroDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;

@Slf4j
@SpringBootApplication
public class MainApplication implements ApplicationRunner {

    @Autowired
    private AeroDataService aeroDataService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("############################   RUN   ############################");

        // Delete any records from a previous run;
        aeroDataService.deleteAll();

        // save an airline
        aeroDataService.saveAirline(new Airline("DAL", RecordType.AIRLINE_DATA, "Delta Air Lines", "United States", "US", "DELTA", "delta.com"));

        // add some aircraft aircraft
        aeroDataService.saveAircraft(new Aircraft("DAL_a93d7c", RecordType.AIRCRAFT_DATA, "N695CA", "Bombardier Inc", "CL-600-2D24"));
        aeroDataService.saveAircraft(new Aircraft("DAL_ab8379", RecordType.AIRCRAFT_DATA, "N8409N", "Bombardier Inc", "CL-600-2B19"));
        aeroDataService.saveAircraft(new Aircraft("DAL_a36f7e", RecordType.AIRCRAFT_DATA, "N8409N", "Airbus Industrie", "A319-114"));

        // Add some ADSB position reports
        Double[] coords1 = {55.991776, -4.776722};
        GeoPoint geoPoint = new GeoPoint(coords1);
        aeroDataService.saveADSBRecord(new ADSBRecord("DAL_a36f7e_1", RecordType.ADSB_RECORD, 38825, 319, 428, 1024, Instant.now(), geoPoint));
        Double[] coords2 = {55.994843, -4.781466};
        geoPoint = new GeoPoint(coords2);
        aeroDataService.saveADSBRecord(new ADSBRecord("DAL_a36f7e_2", RecordType.ADSB_RECORD, 38875, 319, 429, 1024, Instant.now(), geoPoint));
        Double[] coords3 = {55.99606, -4.783344};
        geoPoint = new GeoPoint(coords3);
        aeroDataService.saveADSBRecord(new ADSBRecord("DAL_a36f7e_3", RecordType.ADSB_RECORD, 38892, 319, 428, 1024, Instant.now(), geoPoint));

        System.out.println("-------------------------------");

        // fetch all airlines
        System.out.println("Airlines found with findAllAirlines():");
        System.out.println("-------------------------------");
        for (Airline airline : aeroDataService.getAllAirlines()) {
            System.out.println(airline);
        }

        System.out.println();

        // fetch a specific airline by ICAO ID
        System.out.println("Airlines found with findAirlineByIcaoAddr(\"DAL\"):");
        System.out.println("-------------------------------");
        System.out.println(aeroDataService.getAirlineByIcaoAddr("DAL"));

        System.out.println();

        // fetch all aircraft
        System.out.println("Aircraft found with findAllAircraft():");
        System.out.println("-------------------------------");
        for (Aircraft aircraft : aeroDataService.getAllAircraft()) {
            System.out.println(aircraft);
        }
        System.out.println();
        // fetch Aircraft Documents specific to airline "DAL"
        System.out.println("Aircraft found with findAircraftDataByIcaoAddr(\"DAL\"):");
        System.out.println("-------------------------------");
        for (Aircraft aircraft : aeroDataService.getAircraftDataByIcaoAddr("DAL")) {
            System.out.println(aircraft);
        }

        System.out.println();

        // fetch Aircraft Documents specific to aircraft "a36f7e"
        System.out.println("Aircraft found with findAircraftDataByIcaoAddr(\"DAL_a36f7e\"):");
        System.out.println("-------------------------------");
        for (Aircraft aircraft : aeroDataService.getAircraftDataByIcaoAddr("DAL_a36f7e")) {
            System.out.println(aircraft);
        }

        System.out.println();

        // fetch all adsb records
        System.out.println("ADSB records found with findAllADSBRecords():");
        System.out.println("-------------------------------");
        for (ADSBRecord adsb : aeroDataService.getAllADSBRecords()) {
            System.out.println(adsb);
        }
        System.out.println();
        // fetch ADSB Documents specific to airline "DAL"
        System.out.println("ADSB Documents found with findADSBDataByIcaoAddr(\"DAL\"):");
        System.out.println("-------------------------------");
        for (ADSBRecord adsb : aeroDataService.getADSBDataByIcaoAddr("DAL")) {
            System.out.println(adsb);
        }

        System.out.println();

        // fetch ADSB Documents specific to aircraft "a36f7e"
        System.out.println("ADSB Documents found with findADSBDataByIcaoAddr(\"DAL_a36f7e\"):");
        System.out.println("-------------------------------");
        for (ADSBRecord adsb : aeroDataService.getADSBDataByIcaoAddr("DAL_a36f7e")) {
            System.out.println(adsb);
        }

        // Clean up the data
        // airlineRepo.deleteAll();

    }
}
