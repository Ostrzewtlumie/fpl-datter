package datter.dto;

import com.google.gson.annotations.SerializedName;

public class Position {
    private Integer id;

    @SerializedName(value = "singular_name")
    private String singularName;

    @SerializedName(value = "singular_name_short")
    private String singularShortName;

    public int getId() {
        return id;
    }

    public String getSingularName() {
        return singularName;
    }

    public String getSingularShortName() {
        return singularShortName;
    }
}