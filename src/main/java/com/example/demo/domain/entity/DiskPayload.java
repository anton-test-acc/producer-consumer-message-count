package com.example.demo.domain.entity;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class DiskPayload {

    private final double temperature;
    private final double spaceTotal;
    private final double spaceFree;

    @JsonCreator
    public DiskPayload(@JsonProperty("temperature") double temperature, @JsonProperty("spaceTotal") double spaceTotal, @JsonProperty("spaceFree") double spaceFree) {
        this.temperature = temperature;
        this.spaceTotal = spaceTotal;
        this.spaceFree = spaceFree;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getSpaceTotal() {
        return spaceTotal;
    }

    public double getSpaceFree() {
        return spaceFree;
    }

    @Override
    public String toString() {
        return "DiskPayload{" +
                "temperature=" + temperature +
                ", spaceTotal=" + spaceTotal +
                ", spaceFree=" + spaceFree +
                '}';
    }
}
