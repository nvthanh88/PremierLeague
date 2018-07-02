package com.example.thanhnv.premierleague.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.thanhnv.premierleague.R;

public class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    protected void openActivity(Activity activity,Class<? extends BaseActivity> nextActivity){
        Intent intent = new Intent(activity, nextActivity);
        startActivity(intent);
    }
    protected void openFragment(Fragment fragment, boolean isAddToBackStack){
        assert getFragmentManager() != null;
        String tag = fragment.getClass().getSimpleName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment,tag);
        if (isAddToBackStack) transaction.isAddToBackStackAllowed();
        transaction.commit();
    }

}
