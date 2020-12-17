package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log_comments")
public class LogComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "log_id")
    private Long logId;
    private String details;
    private Date comment_dtg;

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
    public Date getComment_dtg() {
        return comment_dtg;
    }

    public void setComment_dtg(Date comment_dtg) {
        this.comment_dtg = comment_dtg;
    }
}
