package com.example.demo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="logs")
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sensor_id;
    private String details;
    private Date entry_dtg;
    private boolean archived = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(Long sensor_id) {
        this.sensor_id = sensor_id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getEntry_dtg() {
        return entry_dtg;
    }

    public void setEntry_dtg(Date entry_dtg) {
        this.entry_dtg = entry_dtg;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
