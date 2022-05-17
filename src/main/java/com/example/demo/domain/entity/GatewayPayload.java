package com.example.demo.domain.entity;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class GatewayPayload {

    private final double temperature;
    private final double powerLevel;
    private final int connectedClients;

    @JsonCreator
    public GatewayPayload(@JsonProperty("temperature") double temperature, @JsonProperty("powerLevel") double powerLevel, @JsonProperty("connectedClients") int connectedClients) {
        this.temperature = temperature;
        this.powerLevel = powerLevel;
        this.connectedClients = connectedClients;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPowerLevel() {
        return powerLevel;
    }

    public int getConnectedClients() {
        return connectedClients;
    }

    @Override
    public String toString() {
        return "GatewayPayload{" +
                "temperature=" + temperature +
                ", powerLevel=" + powerLevel +
                ", connectedClients=" + connectedClients +
                '}';
    }
}
