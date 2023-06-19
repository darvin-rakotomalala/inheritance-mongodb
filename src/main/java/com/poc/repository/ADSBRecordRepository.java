package com.poc.repository;

import com.poc.model.ADSBRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ADSBRecordRepository extends MongoRepository<ADSBRecord, String> {
    @Query(value="{_class: \"ADSBRecord\"}",sort="{_id: 1}")
    List<ADSBRecord> findAllADSBRecords();
    @Query(value="{_id: /^?0/, _class: \"ADSBRecord\"}", sort = "{_id: 1}")
    List<ADSBRecord> findADSBDataByIcaoAddr(String icaoAddr);
}
