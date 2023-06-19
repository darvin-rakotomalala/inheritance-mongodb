package com.poc.model;

public class GeoPoint {
    private String type;
    private Double[] coordinates;

    public GeoPoint(Double[] coordinates) {
        this.type = "Point";
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return String.format(
                "GeoPoint[latitude='%s', longitude='%s']",
                this.coordinates[1].toString(), this.coordinates[0].toString());
    }
}
