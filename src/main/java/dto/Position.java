package dto;

import com.google.gson.annotations.SerializedName;

public class Position {

private int id;

    public Position() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPluralName() {
        return pluralName;
    }

    public void setPluralName(String pluralName) {
        this.pluralName = pluralName;
    }

    public Position(int id, String name) {
        this.id = id;
        this.pluralName = name;
    }

    @SerializedName(value = "plural_name")
    private String pluralName;
}
