package com.example.demo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "asset_request")
public class AssetRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private Long sat_id;
    private Date pass_start;
    private Date pass_stop;
    private float latitude;
    private float longitude;
    private float elevation;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getSat_id() {
        return sat_id;
    }

    public void setSat_id(Long sat_id) {
        this.sat_id = sat_id;
    }

    public Date getPass_start() {
        return pass_start;
    }

    public void setPass_start(Date pass_start) {
        this.pass_start = pass_start;
    }

    public Date getPass_stop() {
        return pass_stop;
    }

    public void setPass_stop(Date pass_stop) {
        this.pass_stop = pass_stop;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getElevation() {
        return elevation;
    }

    public void setElevation(float elevation) {
        this.elevation = elevation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
