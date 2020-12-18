package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name="mx")
public class MxTask {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;
    private String mx_id;
    private String mx_title;
    private String description;
    private String sensors;
    private String type;

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    private String approved;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMx_id() {
        return mx_id;
    }

    public void setMx_id(String mx_id) {
        this.mx_id = mx_id;
    }

    public String getMx_title() {
        return mx_title;
    }

    public void setMx_title(String mx_title) {
        this.mx_title = mx_title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSensors() {
        return sensors;
    }

    public void setSensors(String sensors) {
        this.sensors = sensors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
