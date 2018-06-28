package com.example.thanhnv.premierleague.app;

import android.app.Application;
import android.content.SharedPreferences;

import dagger.Provides;

public class PlApplication extends Application {
    @Provides
    SharedPreferences provideSharedPreferences(Application application){
        return application.getSharedPreferences("s",MODE_PRIVATE);
    }
}
