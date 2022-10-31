package com.example.s2e2.retrofit.domain;

import com.example.s2e2.retrofit.dto.BloodDonationHouseDTO;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BloodDonationHouses {
        @SerializedName("bloodDonationHouses")
        @Expose
        private List<BloodDonationHouse> bloodDonationHouses = new ArrayList<>();

        public BloodDonationHouses(List<BloodDonationHouse> bloodDonationHouses) {
                this.bloodDonationHouses = bloodDonationHouses;
        }
}
