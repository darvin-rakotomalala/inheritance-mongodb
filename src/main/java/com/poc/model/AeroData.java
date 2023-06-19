package com.poc.model;

import com.poc.model.RecordType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "aeroData")
public abstract class AeroData {
    @Id
    public String id;
    public RecordType recordType;
}
