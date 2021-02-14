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

    public int getId() {
        return id;
    }
}
