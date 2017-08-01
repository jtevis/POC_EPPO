package com.vis.poc_eppo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by XPS13 on 7/7/2017.
 */


public interface WeatherClient {

    //@GET("/users/{user}/repos")

    @GET ("/v1/location/{locationId}/forecast/daily/3day.json")

        //Call<List<GitHubResponse>> reposForUser (String user);
    Call<List<WeatherResponse>> respoForUser(@Path("locationId") String locationID);

}