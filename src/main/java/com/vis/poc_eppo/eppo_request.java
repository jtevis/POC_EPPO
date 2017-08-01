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

public class eppo_request extends AppCompatActivity {


    //String API_BASE_URL = "https://data.eppo.int/api/rest/1.0/taxon/CORN?authtoken=" + eppo_token;
    String API_BASE_URL = "https://data.eppo.int/";

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
        EPPOClient client =  retrofit.create(EPPOClient.class);

// Fetch a list of the Github repositories.
       Call<List<EPPOResponse>> call = client.EPPOForUser("corn");

// Execute the call asynchronously. Get a positive or negative callback.


       call.enqueue(new Callback<List<EPPOResponse>>() {
            @Override
            public void onResponse(Call<List<EPPOResponse>> call, Response<List<EPPOResponse>> response) {
                List<EPPOResponse> respo = response.body();

              listview.setAdapter(new EPPOResponseAdapter(eppo_request.this, respo));
            }

            @Override
            public void onFailure(Call<List<EPPOResponse>> call, Throwable t) {
                Toast.makeText(eppo_request.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });

    }
}