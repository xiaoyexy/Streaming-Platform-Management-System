package edu.gatech.streamingwars.entity;

import java.io.Serializable;
import java.util.Objects;

public class SubscriptionRecordId implements Serializable {
    private String demographicGroupShortName;
    private String streamingServiceShortName;
    private String yearMonth;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubscriptionRecordId)) return false;
        SubscriptionRecordId that = (SubscriptionRecordId) o;
        return Objects.equals(getDemographicGroupShortName(), that.getDemographicGroupShortName()) &&
                Objects.equals(getStreamingServiceShortName(), that.getStreamingServiceShortName()) &&
                Objects.equals(getYearMonth(), that.getYearMonth());
    }

    public SubscriptionRecordId() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDemographicGroupShortName(), getStreamingServiceShortName(), getYearMonth());
    }

    public String getDemographicGroupShortName() {
        return demographicGroupShortName;
    }

    public void setDemographicGroupShortName(String demographicGroupShortName) {
        this.demographicGroupShortName = demographicGroupShortName;
    }

    public String getStreamingServiceShortName() {
        return streamingServiceShortName;
    }

    public void setStreamingServiceShortName(String streamingServiceShortName) {
        this.streamingServiceShortName = streamingServiceShortName;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public SubscriptionRecordId(String demographicGroupShortName, String streamingServiceShortName, String yearMonth) {
        this.demographicGroupShortName = demographicGroupShortName;
        this.streamingServiceShortName = streamingServiceShortName;
        this.yearMonth = yearMonth;
    }
}
