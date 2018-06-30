package com.example.thanhnv.premierleague.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thanhnv.premierleague.R;
import com.example.thanhnv.premierleague.activity.MainActivity;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {
    private Context context;
    private MainActivity mActivity;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (mActivity != null)
        context = mActivity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setFragmentView(),container,false);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    public abstract int setFragmentView();

    private void openFragment(Fragment fragment) {
        assert getFragmentManager() != null;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(view);
        super.onViewCreated(view, savedInstanceState);
    }
}
