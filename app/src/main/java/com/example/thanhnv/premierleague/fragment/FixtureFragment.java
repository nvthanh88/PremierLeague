package com.example.thanhnv.premierleague.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.JsonReader;
import android.view.View;
import android.widget.Toast;

import com.example.horizontalcalendarview.HorizontalCalendar;
import com.example.horizontalcalendarview.utils.HorizontalCalendarListener;
import com.example.thanhnv.premierleague.R;
import com.example.thanhnv.premierleague.adapter.MatchAdapter;
import com.example.thanhnv.premierleague.base.BaseFragment;
import com.example.thanhnv.premierleague.model.Fixture;
import com.example.thanhnv.premierleague.model.Match;
import com.example.thanhnv.premierleague.ultils.TestUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FixtureFragment extends BaseFragment {
    private static final String TAG = FixtureFragment.class.getSimpleName();
    @BindView(R.id.fixtureRecycleView)
    RecyclerView fixtureRecycleView;
    private List<Fixture> fixtures = new ArrayList<>();
    private MatchAdapter matchAdapter;

    @Override
    public int setFragmentView() {
        return R.layout.fragment_fixture;
    }

    @Override
    public void initControl() {

    }

    @Override
    public void initUI() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
        fixtureRecycleView = (RecyclerView) getView().findViewById(R.id.fixtureRecycleView);
        fixtureRecycleView.setLayoutManager(layoutManager);
        fixtureRecycleView.setItemAnimator(new DefaultItemAnimator());
        matchAdapter = new MatchAdapter(mActivity, fixtures);
        fixtureRecycleView.setAdapter(matchAdapter);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupCalendar();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private void setupCalendar() {
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 10);
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, 0);
        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(getView(), R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .configure()
                .formatTopText("MMM")
                .formatMiddleText("dd")
                .formatBottomText("EE")
                .showTopText(true)
                .showBottomText(true)
                .textColor(Color.BLACK, getResources().getColor(R.color.colorAccent))
                .textSize(14f, 14f, 14f)
                .end()
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {

            }

            @Override
            public void onDateClick(Calendar date, int position) {
                // Toast.makeText(getContext(), DateFormat.format("dd-MM-yyyy",date),Toast.LENGTH_SHORT).show();
                //Todo getApi and display Match
                fixtures.clear();
                try {
                    JSONObject jsonObject = (new JSONObject(TestUtils.loadJSONFromAsset(mActivity)));
                    JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("fixtures");
                    Type listType = new TypeToken<List<Fixture>>() {}.getType();
                    List<Fixture> list;
                    list = new Gson().fromJson(String.valueOf(jsonArray),listType);
                    fixtures.addAll(list);
                    matchAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }


        });
    }

}
