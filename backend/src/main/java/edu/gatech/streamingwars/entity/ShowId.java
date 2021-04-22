package edu.gatech.streamingwars.entity;

import java.io.Serializable;
import java.util.Objects;

public class ShowId implements Serializable {
    private String shortName;
    private Integer year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShowId)) return false;
        ShowId showId = (ShowId) o;
        return Objects.equals(getShortName(), showId.getShortName()) &&
                Objects.equals(getYear(), showId.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShortName(), getYear());
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public ShowId(String shortName, Integer year) {
        this.shortName = shortName;
        this.year = year;
    }
}
