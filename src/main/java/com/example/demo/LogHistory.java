package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="log_history")
public class LogHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="log_id")
    private Long logId;
    private String details;
    private Date original_dtg;
    private Date updated_dtg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getOriginal_dtg() {
        return original_dtg;
    }

    public void setOriginal_dtg(Date original_dtg) {
        this.original_dtg = original_dtg;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdated_dtg() {
        return updated_dtg;
    }

    public void setUpdated_dtg(Date updated_dtg) {
        this.updated_dtg = updated_dtg;
    }
}
