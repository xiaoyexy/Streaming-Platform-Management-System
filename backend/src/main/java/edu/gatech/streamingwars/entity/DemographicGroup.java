package edu.gatech.streamingwars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="demographic_group")
public class DemographicGroup {

    @Id
    @Column(name="short_name")
    private String shortName;

    @Column(name="long_name")
    private String longName;

    @Column(name="number_of_account")
    private Integer numberOfAccount;

    public DemographicGroup(String shortName, String longName, int numberOfAccount) {
        this.shortName = shortName;
        this.longName = longName;
        this.numberOfAccount = numberOfAccount;
    }

    public DemographicGroup() {
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

    public int getNumberOfAccount() {
        return numberOfAccount;
    }

    public void setNumberOfAccount(int numberOfAccount) {
        this.numberOfAccount = numberOfAccount;
    }

    @Override
    public String toString() {
        return "DemographicGroup{" +
                "shortName='" + shortName + '\'' +
                ", longName='" + longName + '\'' +
                ", numberOfAccount=" + numberOfAccount +
                '}';
    }
}
