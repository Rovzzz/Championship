package com.example.championship;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.up.R;

public class Onboarding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard);
    }

    public void GoLog(View v){
        Intent intent = new Intent(Onboarding.this,Onboarding.class);
        startActivity(intent);
    }

    public void GoReg(View v){

    }

}