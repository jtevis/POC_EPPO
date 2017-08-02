package com.vis.poc_eppo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by XPS13 on 7/7/2017.
 */


public interface EPPO_POSTClient {

    @POST("eppocode")
    Call<EPPOcode> FetchEPPO(@Body EPPOcode eppocode);
        //Call<List<GitHubResponse>> reposForUser (String user);
    //Call<List<EPPOResponse>> EPPOForUser(@Path("eppocode") String eppocode);
    //Call<List<EPPOResponse>> EPPOForUser(@Path("crop") String crop);

}