package com.example.thanhnv.premierleague.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.thanhnv.premierleague.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
