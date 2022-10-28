package com.example.s2e2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.IOException;
import java.util.List;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.googleMap = googleMap;
        Context context = this;
        //LatLng SEOUL = new LatLng(37.56, 126.97);

        Location bloodDonationHouse = addressToPoint(context);
        final LatLng house = new LatLng(bloodDonationHouse.getLatitude(), bloodDonationHouse.getLongitude());

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(house);
        markerOptions.title("name");
        googleMap.addMarker(markerOptions);

    }

    //카메라 움직이기
    private void movingCamera(LatLng latLng) {
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 20));
    }

    //데베에서 받아온 위치를 모두 처리하기기
    private void bloodDonationHouseList(List<BloodDonationHousePosition> bloodDonationHousePositions) {
        for (int i = 0; i < bloodDonationHousePositions.size(); i++) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(new LatLng(bloodDonationHousePositions.get(i).getLatitude(), bloodDonationHousePositions.get(i).getLongitude()));
            markerOptions.title(bloodDonationHousePositions.get(i).getName());
            markerOptions.snippet("헌혈의 집");

            this.googleMap.addMarker(markerOptions);
        }
    }

    public static Location addressToPoint(Context context) {
        Location location = new Location("");
        Geocoder geocoder = new Geocoder(context);
        List<Address> addresses = null;

        try {
            addresses = geocoder.getFromLocationName("name", 3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (addresses != null) {
            for (int i = 0; i < addresses.size(); i++){
                Address lating = addresses.get(i);
                location.setLatitude(lating.getLatitude());
                location.setLongitude(lating.getLongitude());
            }
        }
        return location;
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    //화면 이동 메소드 - 메인페이지로
    public void goToMainPage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //화면 이동 메소드 - 메인페지이로, 헌혈횟수를 1 증가시킨다.
    public void completeAndGoTOMainPage(View view) {
        MainActivity.increaseCountBloodDonation();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}