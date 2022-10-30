package com.example.s2e2.retrofit.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class BloodDonation {
    @Expose
    @SerializedName("id")
    private Long id;

    @Expose
    @SerializedName("count")
    private int count;

    @Expose
    @SerializedName("date")
    private String  date;

    @Expose
    @SerializedName("availableDate")
    private int availableDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BloodDonation{" +
                "id=" + id +
                ", count=" + count +
                ", date=" + date +
                ", availableDate=" + availableDate +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(int availableDate) {
        this.availableDate = availableDate;
    }
}
