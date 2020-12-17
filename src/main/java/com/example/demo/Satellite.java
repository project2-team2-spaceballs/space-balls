package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "satellites")
public class Satellite {

    @Id
    private int id;
    private float period;
    private float inclination;
    private int elset;
    private float rcs;
    @Column(name="mission_type")
    private String missionType;
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

    public String getMissionType() {
        return missionType;
    }

    public void setMissionType(String missionType) {
        this.missionType = missionType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
