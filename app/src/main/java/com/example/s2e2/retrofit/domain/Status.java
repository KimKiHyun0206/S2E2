package com.example.s2e2.retrofit.domain;

import com.google.gson.annotations.SerializedName;



public class Status {

    @SerializedName("status") private String status;

    public Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
