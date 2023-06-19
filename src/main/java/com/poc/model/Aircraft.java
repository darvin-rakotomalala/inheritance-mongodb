package com.poc.model;

import lombok.*;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "aeroData")
@TypeAlias("AircraftData")
public class Aircraft extends AeroData {
    private String tailNumber;
    private String manufacturer;
    private String model;

    public Aircraft(String id, RecordType recordType, String tailNumber, String manufacturer, String model) {
        this.id = id;
        this.recordType = recordType;
        this.tailNumber = tailNumber;
        this.manufacturer = manufacturer;
        this.model = model;
    }

}
