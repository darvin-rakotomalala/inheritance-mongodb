package com.poc.service;

import com.poc.exception.ResourceNotFoundException;
import com.poc.model.ADSBRecord;
import com.poc.model.Aircraft;
import com.poc.model.Airline;
import com.poc.repository.ADSBRecordRepository;
import com.poc.repository.AircraftRepository;
import com.poc.repository.AirlineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AeroDataServiceImpl implements AeroDataService {

    private final AirlineRepository airlineRepo;
    private final AircraftRepository aircraftRepo;
    private final ADSBRecordRepository adsbRepo;

    @Override
    public void deleteAll() {
        airlineRepo.deleteAll();
    }

    @Override
    public void saveAirline(Airline airline) {
        airlineRepo.save(airline);
    }

    @Override
    public void saveAircraft(Aircraft aircraft) {
        aircraftRepo.save(aircraft);
    }

    @Override
    public void saveADSBRecord(ADSBRecord aircraft) {
        adsbRepo.save(aircraft);
    }

    @Override
    public List<Airline> getAllAirlines() {
        return airlineRepo.findAllAirlines();
    }

    @Override
    public Airline getAirlineByIcaoAddr(String icaoAddr) {
        Optional<Airline> airlineFound = airlineRepo.findAirlineByIcaoAddr(icaoAddr);
        if (airlineFound.isEmpty()) {
            throw new ResourceNotFoundException("Airline " + icaoAddr + " not found");
        }
        return airlineFound.get();
    }

    @Override
    public List<Aircraft> getAllAircraft() {
        return aircraftRepo.findAllAircraft();
    }

    @Override
    public List<Aircraft> getAircraftDataByIcaoAddr(String icaoAddr) {
        return aircraftRepo.findAircraftDataByIcaoAddr(icaoAddr);
    }

    @Override
    public List<ADSBRecord> getAllADSBRecords() {
        return adsbRepo.findAllADSBRecords();
    }

    @Override
    public List<ADSBRecord> getADSBDataByIcaoAddr(String icaoAddr) {
        return adsbRepo.findADSBDataByIcaoAddr(icaoAddr);
    }

}
