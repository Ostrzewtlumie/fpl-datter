package datter.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Fixture {
    private int id;

    @SerializedName(value = "team_a")
    private int teamAway;

    @SerializedName(value = "team_h")
    private int teamHome;

    @SerializedName(value = "team_a_score")
    private int teamAwayScore;

    @SerializedName(value = "team_h_score")
    private int teamHomeScore;

    private Boolean started;

    @SerializedName(value = "kickoff_time")
    private String startTime;

    @SerializedName(value = "team_a_difficulty")
    private int teamAwayDiff;

    @SerializedName(value = "team_h_difficulty")
    private int teamHomeDiff;

    @SerializedName(value = "stats")
    private List<MatchStats> matchStats;

    public int getId() {
        return id;
    }
}
