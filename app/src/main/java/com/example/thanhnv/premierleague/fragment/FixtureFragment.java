package com.example.thanhnv.premierleague.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Toast;

import com.example.horizontalcalendarview.HorizontalCalendar;
import com.example.horizontalcalendarview.utils.HorizontalCalendarListener;
import com.example.thanhnv.premierleague.R;
import com.example.thanhnv.premierleague.adapter.MatchAdapter;
import com.example.thanhnv.premierleague.base.BaseFragment;
import com.example.thanhnv.premierleague.model.Match;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FixtureFragment extends BaseFragment {
    private static final String TAG = FixtureFragment.class.getSimpleName();
    private HorizontalCalendar horizontalCalendar;
    @BindView(R.id.fixtureRecycleView)
    RecyclerView fixtureRecycleView;
    private List<Match> matchList = new ArrayList<>();
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
    private void setupCalendar(){
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 10);
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, 0);
        horizontalCalendar = new HorizontalCalendar.Builder(getView(), R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .configure()
                .formatTopText("MMM")
                .formatMiddleText("dd")
                .formatBottomText("EE")
                .showTopText(true)
                .showBottomText(true)
                .textColor(Color.BLACK, getResources().getColor(R.color.colorAccent))
                .textSize(14f,14f,14f)
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
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mActivity,LinearLayoutManager.HORIZONTAL,false);
                fixtureRecycleView = (RecyclerView) getView().findViewById(R.id.fixtureRecycleView);
                fixtureRecycleView.setLayoutManager(layoutManager);
                fixtureRecycleView.setItemAnimator(new DefaultItemAnimator());
                fixtureRecycleView.setAdapter(matchAdapter);
                matchList.add(new Match("Manchester United","Chelsea","1","0"));
                matchAdapter = new MatchAdapter(context,matchList);
                matchAdapter.notifyDataSetChanged();
            }


        });
    }
}
