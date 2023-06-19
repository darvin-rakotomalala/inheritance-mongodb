package com.poc.service;

import com.poc.model.ADSBRecord;
import com.poc.model.Aircraft;
import com.poc.model.Airline;

import java.util.List;

public interface AeroDataService {
    void deleteAll();
    void saveAirline(Airline airline);
    void saveAircraft(Aircraft aircraft);
    void saveADSBRecord(ADSBRecord aircraft);
    List<Airline> getAllAirlines();
    Airline getAirlineByIcaoAddr(String icaoAddr);
    List<Aircraft> getAllAircraft();
    List<Aircraft> getAircraftDataByIcaoAddr(String icaoAddr);
    List<ADSBRecord> getAllADSBRecords();
    List<ADSBRecord> getADSBDataByIcaoAddr(String icaoAddr);
}