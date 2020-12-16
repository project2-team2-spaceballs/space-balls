package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "opscap")
public class OpsCap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long radar_id;

    private Long mw_stat;

    private Long md_stat;

    private  Long sda_stat;

    private String details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRadar_id() {
        return radar_id;
    }

    public void setRadar_id(Long radar_id) {
        this.radar_id = radar_id;
    }

    public Long getMw_stat() {
        return mw_stat;
    }

    public void setMw_stat(Long mw_stat) {
        this.mw_stat = mw_stat;
    }

    public Long getMd_stat() {
        return md_stat;
    }

    public void setMd_stat(Long md_stat) {
        this.md_stat = md_stat;
    }

    public Long getSda_stat() {
        return sda_stat;
    }

    public void setSda_stat(Long sda_stat) {
        this.sda_stat = sda_stat;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
