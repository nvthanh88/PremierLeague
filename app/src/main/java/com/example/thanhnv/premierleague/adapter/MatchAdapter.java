package com.example.thanhnv.premierleague.adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thanhnv.premierleague.R;
import com.example.thanhnv.premierleague.model.Fixture;
import com.example.thanhnv.premierleague.model.Match;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {
    private Context context;
    private List<Fixture> fixtureList;

    public MatchAdapter(Context context, List<Fixture> fixtureList) {
        this.context = context;
        this.fixtureList = fixtureList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_match,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        Fixture fixtureItem = fixtureList.get(position);
        holder.homeName.setText(fixtureItem.getHomeName());
        holder.awayName.setText(fixtureItem.getAwayName());

    }

    @Override
    public int getItemCount() {
        return fixtureList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_name)
        TextView homeName;
        @BindView(R.id.away_name)
        TextView awayName;
        @BindView(R.id.home_score)
        TextView homeScore;
        @BindView(R.id.away_score)
        TextView awayScore;
        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);


        }
    }
}
