package com.vis.poc_eppo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
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

public class gitHub_request extends AppCompatActivity {

    //String GITHUBUSER = myUser;

    String API_BASE_URL = "https://api.github.com/";




    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.github_request);
        String myUser = getIntent().getStringExtra("GitUser");

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());


        final EditText mEdit = (EditText)findViewById(R.id.GitUser);
        listview = (ListView) findViewById(R.id.list_item_pagination);

       Retrofit retrofit = builder.build();

        // Create a very simple REST adapter which points the GitHub API endpoint.
        GitHubClient client =  retrofit.create(GitHubClient.class);

// Fetch a list of the Github repositories.
       //Call<List<GitHubResponse>> call = client.reposForUser("jtevis");



            Call<List<GitHubResponse>> call = client.reposForUser(myUser);

        //Call<List<GitHubResponse>> call = client.reposForUser("ibm-bluemix");

// Execute the call asynchronously. Get a positive or negative callback.


       call.enqueue(new Callback<List<GitHubResponse>>() {
            @Override
            public void onResponse(Call<List<GitHubResponse>> call, Response<List<GitHubResponse>> response) {
                List<GitHubResponse> repos = response.body();

                listview.setAdapter(new GitHubResponseAdapter(gitHub_request.this, repos));
            }

            @Override
            public void onFailure(Call<List<GitHubResponse>> call, Throwable t) {
                Toast.makeText(gitHub_request.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });

    }
}