package com.example.thanhnv.premierleague.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.horizontalcalendarview.HorizontalCalendar;
import com.example.horizontalcalendarview.utils.HorizontalCalendarListener;
import com.example.thanhnv.premierleague.R;
import com.example.thanhnv.premierleague.base.BaseFragment;

import java.util.Calendar;
import java.util.Date;



public class FixtureFragment extends BaseFragment {
    private HorizontalCalendar horizontalCalendar;
    @Override
    public int setFragmentView() {
        return R.layout.fragment_fixture;
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
        endDate.add(Calendar.MONTH, 1);
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);
        horizontalCalendar = new HorizontalCalendar.Builder(getView(), R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(6)
                .configure()
                .formatTopText("MMM")
                .formatMiddleText("dd")
                .formatBottomText("EEE")
                .showTopText(true)
                .showBottomText(true)
                .textColor(Color.LTGRAY, Color.WHITE)
                .colorTextMiddle(Color.LTGRAY, Color.parseColor("#ffd54f"))
                .end()
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                
            }

          

        });
    }
}
