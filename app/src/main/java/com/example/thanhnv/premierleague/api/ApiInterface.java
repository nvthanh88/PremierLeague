package com.example.thanhnv.premierleague.api;

import com.example.thanhnv.premierleague.model.Fixture;
import com.example.thanhnv.premierleague.model.Result;

import org.json.JSONObject;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("fixtures/matches.json")
    Call<Fixture> getFixtures(@Query("key") String apiKey,@Query("secret") String secret);

    @GET("users/pair.json")
    Call<Result> testApi(@Query("key") String apiKey, @Query("secret") String secret);
}
