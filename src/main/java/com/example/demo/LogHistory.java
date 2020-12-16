package com.example.demo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="log_history")
public class LogHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long log_id;
    private String details;
    private Date original_dtg;
    private Date updated_dtg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLog_id() {
        return log_id;
    }

    public void setLog_id(Long log_id) {
        this.log_id = log_id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getOriginal_dtg() {
        return original_dtg;
    }

    public void setOriginal_dtg(Date original_dtg) {
        this.original_dtg = original_dtg;
    }

    public Date getUpdated_dtg() {
        return updated_dtg;
    }

    public void setUpdated_dtg(Date updated_dtg) {
        this.updated_dtg = updated_dtg;
    }
}
