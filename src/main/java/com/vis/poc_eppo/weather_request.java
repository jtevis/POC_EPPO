package com.vis.poc_eppo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by XPS13 on 7/27/2017.
 */

public class weather_request extends AppCompatActivity {
     //String API_BASE_URL = "https://<jwtevis@vis4ag.com>:<LarBar2010>@twcservice.mybluemix.net:443/api/weather_request/v1/geocode/45.42/75.69/forecast/hourly/48hour.json?units=m&language=en-US";
    //String API_BASE_URL = "https://twcservice.mybluemix.net/api-docs/weather_data.json , api version: 1.0";
    String API_BASE_URL = "https://jwtevis@vis4ag.com:LarBar2010@twcservice.mybluemix.net/";
    //GET /v1/geocode/{latitude}/{longitude}/forecast/daily/3day.json
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_request);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        listview = (ListView) findViewById(R.id.list_item_pagination);


        Retrofit retrofit = builder.build();

        // Create a very simple REST adapter which points the GitHub API endpoint.
        WeatherClient client =  retrofit.create(WeatherClient.class);

// Fetch a list of the Github repositories.
        Call<List<WeatherResponse>> call = client.respoForUser("55387:4:US");

// Execute the call asynchronously. Get a positive or negative callback.


        call.enqueue(new Callback<List<WeatherResponse>>() {
            @Override
            public void onResponse(Call<List<WeatherResponse>> call, Response<List<WeatherResponse>> response) {
                List<WeatherResponse> respo = response.body();

                listview.setAdapter(new WeatherResponseAdapter(weather_request.this, respo));
            }

            @Override
            public void onFailure(Call<List<WeatherResponse>> call, Throwable t) {
                Toast.makeText(weather_request.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });

    }
}
