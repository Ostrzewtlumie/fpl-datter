package datter.dto;

import com.google.gson.annotations.SerializedName;

public class Player {
    int id;

    @SerializedName(value = "first_name")
    private String firstName;

    @SerializedName(value = "second_name")
    private String secondName;

    @SerializedName(value = "total_points")
    private int points;

    @SerializedName(value = "chance_of_playing_next_round")
    private int chanceOfPlayingNext;

    @SerializedName(value = "chance_of_playing_this_round")
    private int chanceOfPlayingThisRound;

    @SerializedName(value = "element_type")
    private int postion;

    @SerializedName(value = "event_points")
    private int pointsGameWeek;

    private String form;

    @SerializedName(value = "new_cost")
    private String cost;

    @SerializedName(value = "points_per_game")
    private String pointsPerGame;

    @SerializedName(value = "selected_by_percent")
    private String selectedByPercent;

    private String status;

    private int team;

    @SerializedName(value = "value_season")
    private String seasonValue;

    @SerializedName(value = "value_form")
    private String formValue;

    private int minutes;

    @SerializedName(value = "goals_scored")
    private int goals;

    private int assists;

    @SerializedName(value = "clean_sheets")
    private int cleanSheets;

    @SerializedName(value = "goals_conceded")
    private int goalsConceded;

    @SerializedName(value = "own_goals")
    private int ownGoals;

    @SerializedName(value = "penalties_saved")
    private int penaltiesSaved;

    @SerializedName(value = "penalties_missed")
    private int penaltiesMissed;

    @SerializedName(value = "yellow_cards")
    private int yellowCards;

    @SerializedName(value = "red_cards")
    private int redCards;

    private int saves;

    private int bonus;

    private String influence;

    private String creativity;

    private String threat;

    public int getId() {
        return id;
    }
}
