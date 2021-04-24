package edu.gatech.streamingwars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studio")
public class Studio {
    @Id
    @Column(name="short_name")
    private String shortName;

    @Column(name="long_name")
    private String longName;

    public Studio() {
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public Studio(String shortName, String longName) {
        this.shortName = shortName;
        this.longName = longName;
    }
}
