package edu.gatech.streamingwars.entity;

import java.io.Serializable;
import java.util.Objects;

public class ShowLicenseRecordId implements Serializable {
    private String streamingServiceShortName;
    private String showShortName;
    private Integer showYear;
    private String yearMonth;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShowLicenseRecordId)) return false;
        ShowLicenseRecordId that = (ShowLicenseRecordId) o;
        return Objects.equals(getStreamingServiceShortName(), that.getStreamingServiceShortName()) &&
                Objects.equals(getShowShortName(), that.getShowShortName()) &&
                Objects.equals(getShowYear(), that.getShowYear()) &&
                Objects.equals(getYearMonth(), that.getYearMonth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStreamingServiceShortName(), getShowShortName(), getShowYear(), getYearMonth());
    }

    @Override
    public String toString() {
        return "ShowLicenseRecordId{" +
                "streamingServiceShortName='" + streamingServiceShortName + '\'' +
                ", showShortName='" + showShortName + '\'' +
                ", showYear=" + showYear +
                ", yearMonth='" + yearMonth + '\'' +
                '}';
    }

    public String getStreamingServiceShortName() {
        return streamingServiceShortName;
    }

    public void setStreamingServiceShortName(String streamingServiceShortName) {
        this.streamingServiceShortName = streamingServiceShortName;
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

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public ShowLicenseRecordId() {
    }

    public ShowLicenseRecordId(String streamingServiceShortName, String showShortName, Integer showYear, String yearMonth) {
        this.streamingServiceShortName = streamingServiceShortName;
        this.showShortName = showShortName;
        this.showYear = showYear;
        this.yearMonth = yearMonth;
    }
}
