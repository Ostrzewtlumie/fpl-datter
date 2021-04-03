package datter.dto;

import com.google.gson.annotations.SerializedName;

public class Team {
    private Integer id;

    private String name;

    @SerializedName(value = "short_name")
    private String shortName;

    private int draw;

    private int win;

    private int loss;

    private int played;

    private int strength;

    @SerializedName(value = "strength_overall_home")
    private int strengthHome;

    @SerializedName(value = "strength_overall_away")
    private int strengthAway;

    @SerializedName(value = "strength_attack_home")
    private int strengthAttackHome;

    @SerializedName(value = "strength_attack_away")
    private int strengthAttackAway;

    @SerializedName(value = "strength_defence_home")
    private int strengthDefenceHome;

    @SerializedName(value = "strength_defence_away")
    private int strengthDefenceAway;

    private int scoredGoals;

    private int lostGoals;

    public Integer getId() {
        return id;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public void setLostGoals(int lostGoals) {
        this.lostGoals = lostGoals;
    }
}
