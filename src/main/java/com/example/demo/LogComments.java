package com.example.demo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log_comments")
public class LogComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long log_id;
    private String details;
    private Date comment_dtg;

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

    public Date getComment_dtg() {
        return comment_dtg;
    }

    public void setComment_dtg(Date comment_dtg) {
        this.comment_dtg = comment_dtg;
    }
}
