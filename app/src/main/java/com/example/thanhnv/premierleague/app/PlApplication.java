package com.example.thanhnv.premierleague.app;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.thanhnv.premierleague.module.Model;

import dagger.Module;
import dagger.Provides;
@Module
public class PlApplication extends Application {
    @Provides
    SharedPreferences provideSharedPreferences(Application application){
        return application.getSharedPreferences("s",MODE_PRIVATE);
    }
    @Provides
    Model model(){
        return new Model();
    }

}
