package com.vis.poc_eppo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onClickNewEPPO(View v) {

        if (v.getId() == R.id.CNewEPPO) {
            Intent i = new Intent(MainActivity.this, eppo_request.class);
            startActivity(i);
        }

    }

    public void onClickNewWeather(View v) {

        if (v.getId() == R.id.CWeather) {
            Intent i = new Intent(MainActivity.this, weather_request.class);
            startActivity(i);
        }

    }
    public void onClickNewGitHub(View v) {

        if (v.getId() == R.id.CGitHub) {
            Intent i = new Intent(MainActivity.this, github_entry.class);
            startActivity(i);
        }

    }
    public void onClickMixMate(View v) {

        if (v.getId() == R.id.CMixMate) {
            Intent i = new Intent(MainActivity.this, mixmate_request.class);
            startActivity(i);
        }
    }
}
