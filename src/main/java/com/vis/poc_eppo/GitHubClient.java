package com.vis.poc_eppo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by XPS13 on 7/7/2017.
 */


public interface GitHubClient {

    @GET("/users/{user}/repos")

        //Call<List<GitHubResponse>> reposForUser (String user);
    Call<List<GitHubResponse>> reposForUser(@Path("user") String user);

}