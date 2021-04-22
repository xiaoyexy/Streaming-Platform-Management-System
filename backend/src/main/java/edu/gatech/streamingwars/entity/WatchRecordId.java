package edu.gatech.streamingwars.entity;

import java.io.Serializable;
import java.util.Objects;

public class WatchRecordId implements Serializable {
    private String demographicGroupShortName;
    private String showShortName;
    private Integer showYear;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WatchRecordId)) return false;
        WatchRecordId that = (WatchRecordId) o;
        return Objects.equals(getDemographicGroupShortName(), that.getDemographicGroupShortName()) &&
                Objects.equals(getShowShortName(), that.getShowShortName()) &&
                Objects.equals(getShowYear(), that.getShowYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDemographicGroupShortName(), getShowShortName(), getShowYear());
    }

    public String getDemographicGroupShortName() {
        return demographicGroupShortName;
    }

    public void setDemographicGroupShortName(String demographicGroupShortName) {
        this.demographicGroupShortName = demographicGroupShortName;
    }

    public String getShowShortName() {
        return showShortName;
    }

    public void setShowShortName(String showShortName) {
        this.showShortName = showShortName;
    }

    public Integer getShowYear() {
        return showYear;
    }

    public void setShowYear(Integer showYear) {
        this.showYear = showYear;
    }

    public WatchRecordId(String demographicGroupShortName, String showShortName, Integer showYear) {
        this.demographicGroupShortName = demographicGroupShortName;
        this.showShortName = showShortName;
        this.showYear = showYear;
    }
}
