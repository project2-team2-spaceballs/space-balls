package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "satellite_passes")
public class Passes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sat_id;

    @Column(columnDefinition = "pass_start")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date pass_start;

    @Column(columnDefinition = "pass_stop")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date pass_stop;

    private float toes;
    private boolean nk_fence;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSat_id() {
        return sat_id;
    }

    public void setSat_id(int sat_id) {
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

    public float getToes() {
        return toes;
    }

    public void setToes(float toes) {
        this.toes = toes;
    }

    public boolean isNk_fence() {
        return nk_fence;
    }

    public void setNk_fence(boolean nk_fence) {
        this.nk_fence = nk_fence;
    }

    public boolean isK_fence() {
        return k_fence;
    }

    public void setK_fence(boolean k_fence) {
        this.k_fence = k_fence;
    }

    private boolean k_fence;
}
