package com.example.thanhnv.premierleague.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.thanhnv.premierleague.R;
import com.example.thanhnv.premierleague.api.ApiClient;
import com.example.thanhnv.premierleague.api.ApiInterface;
import com.example.thanhnv.premierleague.app.AppComponents;
import com.example.thanhnv.premierleague.base.BaseActivity;
import com.example.thanhnv.premierleague.fragment.FixtureFragment;
import com.example.thanhnv.premierleague.model.Fixture;
import com.example.thanhnv.premierleague.model.Result;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements AppComponents {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<Result> call = apiService.testApi(ApiClient.API_KEY, ApiClient.API_SECRET);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Boolean b = response.body().getSuccess();
                JSONObject data = response.body().getData();


                if (b) {
                    if (data.has("message")) {
                        try {
                            Toast.makeText(getApplicationContext(), "Test ok: " + data.getString("message"), Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    } else
                        Toast.makeText(getApplicationContext(), "Test failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "onFailure", Toast.LENGTH_LONG).show();
            }
        });
    }
}
