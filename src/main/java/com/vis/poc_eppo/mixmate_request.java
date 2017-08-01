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
 * Created by XPS13 on 7/6/2017.
 */

public class mixmate_request extends AppCompatActivity {

    //String API_BASE_URL = "https://api.github.com/";
    //String API_BASE_URL = " https://twcservice.mybluemix.net/api-docs/weather_data.json , api version: 1.0/";
    //String API_BASE_URL = "https://<jwtevis@vis4ag.com>:<LarBar2010>@twcservice.mybluemix.net:443/api/weather_request/";
    String API_BASE_URL = "https://<jwtevis@vis4ag.com>:<LarBar2010>https://<username>:<password>@twcservice.mybluemix.net:443/api/weather_request/v1/geocode/45.42/75.69/forecast/hourly/48hour.json?units=m&language=en-US";
    //String API_BASE_URL = "https://<jwtevis@vis4ag.com>:<LarBar2010>@twcservice.mybluemix.net:443/api/weather_request/v1/geocode/45.42/75.69/forecast/hourly/48hour.json?units=m&language=en-US/";
    //String MY_TOKEN = getString(eppo_token);

    //String API_BASE_URL = "https://data.eppo.int/api/rest/1.0/taxon/CORN?authtoken=" + eppo_token;
    //String API_BASE_URL = "https://data.eppo.int/api/rest/1.0/";

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eppo_request);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        listview = (ListView) findViewById(R.id.list_item_pagination);


       Retrofit retrofit = builder.build();

        // Create a very simple REST adapter which points the GitHub API endpoint.
        GitHubClient client =  retrofit.create(GitHubClient.class);

// Fetch a list of the Github repositories.
       Call<List<GitHubResponse>> call = client.reposForUser("jtevis");
      // Call<List<GitHubResponse>> call = client.reposForUser("corn");
       //Call<List<GitHubResponse>> call = client.reposForUser("ZEAMX");

// Execute the call asynchronously. Get a positive or negative callback.


       call.enqueue(new Callback<List<GitHubResponse>>() {
            @Override
            public void onResponse(Call<List<GitHubResponse>> call, Response<List<GitHubResponse>> response) {
                List<GitHubResponse> repos = response.body();

              listview.setAdapter(new GitHubResponseAdapter(mixmate_request.this, repos));
            }

            @Override
            public void onFailure(Call<List<GitHubResponse>> call, Throwable t) {
                Toast.makeText(mixmate_request.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });

    }
}