package dto;

import com.google.gson.annotations.SerializedName;

public class Fixture {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamAway() {
        return teamAway;
    }

    public void setTeamAway(int teamAway) {
        this.teamAway = teamAway;
    }

    public int getTeamHome() {
        return teamHome;
    }

    public void setTeamHome(int teamHome) {
        this.teamHome = teamHome;
    }

    public int getTeamAwayScore() {
        return teamAwayScore;
    }

    public void setTeamAwayScore(int teamAwayScore) {
        this.teamAwayScore = teamAwayScore;
    }

    public int getTeamHomeScore() {
        return teamHomeScore;
    }

    public void setTeamHomeScore(int teamHomeScore) {
        this.teamHomeScore = teamHomeScore;
    }

    public Fixture(int id, int team_a, int team_h, int team_a_score, int team_h_score) {
        this.id = id;
        this.teamAway = team_a;
        this.teamHome = team_h;
        this.teamAwayScore = team_a_score;
        this.teamHomeScore = team_h_score;
    }

    private int id;

    @SerializedName(value = "team_a")
    private int teamAway;

    @SerializedName(value = "team_h")
    private int teamHome;

    @SerializedName(value = "team_a_score")
    private int teamAwayScore;

    @SerializedName(value = "team_h_score")
    private int teamHomeScore;
}
