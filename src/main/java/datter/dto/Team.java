package datter.dto;

import com.google.gson.annotations.SerializedName;

public class Team {
    private int id;
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

    public int getId() {
        return id;
    }
}
