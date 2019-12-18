package com.an.parking.dto;

public class TypeVehicleDto {

    private String cc;
    private boolean meanTransportation;

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public boolean isMeanTransportation() {
        return meanTransportation;
    }

    public void setMeanTransportation(boolean meanTransportation) {
        this.meanTransportation = meanTransportation;
    }
}
