package com.example.s2e2.retrofit.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BloodDonationHouse {
    @Expose
    @SerializedName("id")
    private Long id;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("streeteNameAddress")
    private String streetNameAddress;

    @Override
    public String toString() {
        return "BloodDonationHouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", streetNameAddress='" + streetNameAddress + '\'' +
                '}';
    }
}
