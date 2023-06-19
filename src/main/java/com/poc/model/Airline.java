package com.poc.model;

import lombok.*;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "aeroData")
@TypeAlias("AirlineData")
public class Airline extends AeroData {
    private String airlineName;
    private String country;
    private String countryISO;
    private String callsign;
    private String website;

    public Airline(String id, RecordType recordType, String airlineName, String country, String countryISO, String callsign, String website) {
        this.id = id;
        this.recordType = recordType;
        this.airlineName = airlineName;
        this.country = country;
        this.countryISO = countryISO;
        this.callsign = callsign;
        this.website = website;
    }

}
