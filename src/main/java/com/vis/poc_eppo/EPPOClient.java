package com.vis.poc_eppo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by XPS13 on 7/7/2017.
 */


public interface EPPOClient {

    //@GET("/taxon/{eppocode}/names?authtoken=476ae968c83b58ea07b1e95831722fcd")
    //@GET("api/rest/1.0/taxon/{eppocode}/names?authtoken=1684e85df52a666b29b843efdd1f17e6")
    //@GET("api/rest/1.0/taxon/{eppocode}/names?authtoken=1684e85df52a666b29b843efdd1f17e6")
    //@POST("api/rest/1.0/tools/names2codes?kw={crop}?searchfor=1?searchmode=1?typeorg=0?authtoken=1684e85df52a666b29b843efdd1f17e6")
    @POST("api/rest/1.0/tools/names2codes?intext={crop}?authtoken=1684e85df52a666b29b843efdd1f17e6")

        //Call<List<GitHubResponse>> reposForUser (String user);
    //Call<List<EPPOResponse>> EPPOForUser(@Path("eppocode") String eppocode);
    Call<List<EPPOResponse>> EPPOForUser(@Path("crop") String crop);

}