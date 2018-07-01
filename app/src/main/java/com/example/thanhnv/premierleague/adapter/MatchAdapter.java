package com.example.thanhnv.premierleague.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thanhnv.premierleague.R;
import com.example.thanhnv.premierleague.model.Match;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {
    private Context context;
    private List<Match> matchList;

    public MatchAdapter(Context context, List<Match> matchList) {
        this.context = context;
        this.matchList = matchList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_match,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Match matchItem = matchList.get(position);
        holder.homeName.setText(matchItem.getHome());
        holder.awayName.setText(matchItem.getAway());
        holder.homeScore.setText(matchItem.getHomeScore());
        holder.awayScore.setText(matchItem.getAwayScore());
    }

    @Override
    public int getItemCount() {
        return matchList.size();
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
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
