package com.example.horizontalcalendarview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.horizontalcalendarview.R;


/**
 * @author Mulham-Raee
 * @since v1.0.0
 */
class DateViewHolder extends RecyclerView.ViewHolder {

    TextView textTop;
    TextView textMiddle;
    TextView textBottom;
    View selectionView;
    View layoutContent;
    RecyclerView eventsRecyclerView;

    DateViewHolder(View rootView) {
        super(rootView);
        textTop = rootView.findViewById(R.id.hc_text_month);
        textMiddle = rootView.findViewById(R.id.hc_text_day);
        textBottom = rootView.findViewById(R.id.hc_text_bottom);
        layoutContent = rootView.findViewById(R.id.hc_layoutContent);
        selectionView = rootView.findViewById(R.id.hc_selector);
        eventsRecyclerView = rootView.findViewById(R.id.hc_events_recyclerView);
    }
}
