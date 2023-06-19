package com.poc.model;

import lombok.*;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "aeroData")
@TypeAlias("ADSBRecord")
public class ADSBRecord extends AeroData {
    private Integer altitude;
    private Integer heading;
    private Integer speed;
    private Integer verticalSpeed;
    private Instant timestamp;
    private GeoPoint geoPoint;

    public ADSBRecord(String id, RecordType recordType, Integer altitude, Integer heading, Integer speed, Integer verticalSpeed, Instant timestamp, GeoPoint geoPoint) {
        this.id = id;
        this.recordType = recordType;
        this.altitude = altitude;
        this.heading = heading;
        this.speed = speed;
        this.verticalSpeed = verticalSpeed;
        this.timestamp = timestamp;
        this.geoPoint = geoPoint;
    }

}
