package com.example.s2e2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {

    int lastDay = 5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avticity_second);

    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    public String getLastDay() {
        return String.valueOf(lastDay);
    }
}