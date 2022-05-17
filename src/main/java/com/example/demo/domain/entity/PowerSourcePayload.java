package com.example.demo.domain.entity;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class PowerSourcePayload {

    private final double temperature;
    private final double powerLevel;

    @JsonCreator
    public PowerSourcePayload(@JsonProperty("temperature") double temperature, @JsonProperty("powerLevel") double powerLevel) {
        this.temperature = temperature;
        this.powerLevel = powerLevel;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPowerLevel() {
        return powerLevel;
    }

    @Override
    public String toString() {
        return "PowerSourcePayload{" +
                "temperature=" + temperature +
                ", powerLevel=" + powerLevel +
                '}';
    }
}
