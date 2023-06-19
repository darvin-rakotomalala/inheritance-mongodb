package com.poc.repository;

import com.poc.model.AeroData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AeroDataRepository extends MongoRepository<AeroData, String> {

}
