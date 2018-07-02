package com.example.thanhnv.premierleague.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Fixture implements Serializable {
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("round")
    @Expose
    private String round;
    @SerializedName("home_name")
    @Expose
    private String homeName;
    @SerializedName("away_name")
    @Expose
    private String awayName;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("league_id")
    @Expose
    private String leagueId;

    public Fixture(String date, String time, String round, String homeName, String awayName, String location, String leagueId) {
        this.date = date;
        this.time = time;
        this.round = round;
        this.homeName = homeName;
        this.awayName = awayName;
        this.location = location;
        this.leagueId = leagueId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getAwayName() {
        return awayName;
    }

    public void setAwayName(String awayName) {
        this.awayName = awayName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

}
