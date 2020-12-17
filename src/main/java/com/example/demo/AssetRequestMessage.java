package com.example.demo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "asset_request_message")
public class AssetRequestMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private Date time_stamp;
    private String text;
    private Long asset_request_id;

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

    public Date getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(Date time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getAsset_request_id() {
        return asset_request_id;
    }

    public void setAsset_request_id(Long asset_request_id) {
        this.asset_request_id = asset_request_id;
    }



}
