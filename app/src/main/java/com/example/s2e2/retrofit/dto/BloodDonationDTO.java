package com.example.s2e2.retrofit.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class BloodDonationDTO {
    @Expose
    @SerializedName("id")
    private Long id;

    @Expose
    @SerializedName("blood_Donation_Count")
    private int blood_Donation_Count;

    @Expose
    @SerializedName("blood_Donation_Date")
    private String blood_Donation_Date;

    @Expose
    @SerializedName("blood_Donation_Available_Date")
    private int blood_Donation_Available_Date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBlood_Donation_Count() {
        return blood_Donation_Count;
    }

    public void setBlood_Donation_Count(int blood_Donation_Count) {
        this.blood_Donation_Count = blood_Donation_Count;
    }

    public String getBlood_Donation_Date() {
        return blood_Donation_Date;
    }

    public void setBlood_Donation_Date(String blood_Donation_Date) {
        this.blood_Donation_Date = blood_Donation_Date;
    }

    public int getBlood_Donation_Available_Date() {
        return blood_Donation_Available_Date;
    }

    public void setBlood_Donation_Available_Date(int blood_Donation_Available_Date) {
        this.blood_Donation_Available_Date = blood_Donation_Available_Date;
    }

    @Override
    public String toString() {
        return "BloodDonation{" +
                "id=" + id +
                ", blood_Donation_Count=" + blood_Donation_Count +
                ", blood_Donation_Date=" + blood_Donation_Date +
                ", blood_Donation_Available_Date=" + blood_Donation_Available_Date +
                '}';
    }
}
