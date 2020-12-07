package dto;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrengthHome() {
        return strengthHome;
    }

    public void setStrengthHome(int strengthHome) {
        this.strengthHome = strengthHome;
    }

    public int getStrengthAway() {
        return strengthAway;
    }

    public void setStrengthAway(int strengthAway) {
        this.strengthAway = strengthAway;
    }

    public int getStrengthAttackHome() {
        return strengthAttackHome;
    }

    public void setStrengthAttackHome(int strengthAttackHome) {
        this.strengthAttackHome = strengthAttackHome;
    }

    public int getStrengthAttackAway() {
        return strengthAttackAway;
    }

    public void setStrengthAttackAway(int strengthAttackAway) {
        this.strengthAttackAway = strengthAttackAway;
    }

    public int getStrengthDefenceHome() {
        return strengthDefenceHome;
    }

    public void setStrengthDefenceHome(int strengthDefenceHome) {
        this.strengthDefenceHome = strengthDefenceHome;
    }

    public int getStrengthDefenceAway() {
        return strengthDefenceAway;
    }

    public void setStrengthDefenceAway(int strengthDefenceAway) {
        this.strengthDefenceAway = strengthDefenceAway;
    }

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

    public Team() {
    }

    public Team(int id, String name, String shortName, int draw, int win, int loss, int played, int strength,
                int strengthHome, int strengthAway, int strengthAttackHome, int strengthAttackAway,
                int strengthDefenceHome, int strengthDefenceAway) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.draw = draw;
        this.win = win;
        this.loss = loss;
        this.played = played;
        this.strength = strength;
        this.strengthHome = strengthHome;
        this.strengthAway = strengthAway;
        this.strengthAttackHome = strengthAttackHome;
        this.strengthAttackAway = strengthAttackAway;
        this.strengthDefenceHome = strengthDefenceHome;
        this.strengthDefenceAway = strengthDefenceAway;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
