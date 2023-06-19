package com.poc.repository;

import com.poc.model.Aircraft;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AircraftRepository extends MongoRepository<Aircraft, String> {
    @Query("{_class: \"AircraftData\"}")
    List<Aircraft> findAllAircraft();
    @Query("{_id: /^?0/, _class: \"AircraftData\"}")
    List<Aircraft> findAircraftDataByIcaoAddr(String icaoAddr);
}
