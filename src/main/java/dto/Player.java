package dto;

import com.google.gson.annotations.SerializedName;

public class Player {

    int id;
    @SerializedName(value = "first_name")
    String firstName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Player(int id, String firstName, String secondName, int points) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.points = points;
    }

    @SerializedName(value = "second_name")
    String secondName;
    @SerializedName(value = "total_points")
    int points;
}
