package com.example.thanhnv.premierleague.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "http://livescore-api.com/api-client/";
    public static final String API_KEY = "h7Q20yMIrWnejPoO";
    public static final String API_SECRET = "8JqzzyTBHTFyAJWRRNUSlGAMCY1VOqJX";
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
