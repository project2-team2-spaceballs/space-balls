package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "satellites")
public class SatelliteEntity {

    @Id
    private int id;
    private float period;
    private float inclination;
    private int elset;
    private float rcs;
    private String mission_type;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPeriod() {
        return period;
    }

    public void setPeriod(float period) {
        this.period = period;
    }

    public float getInclination() {
        return inclination;
    }

    public void setInclination(float inclination) {
        this.inclination = inclination;
    }

    public int getElset() {
        return elset;
    }

    public void setElset(int elset) {
        this.elset = elset;
    }

    public float getRcs() {
        return rcs;
    }

    public void setRcs(float rcs) {
        this.rcs = rcs;
    }

    public String getMission_type() {
        return mission_type;
    }

    public void setMission_type(String mission_type) {
        this.mission_type = mission_type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
