package edu.gatech.streamingwars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShowLicenseRecord {

    @Id
    @Column(name="streaming_service_short_name")
    private String streamingServiceShortName;

    @Id
    @Column(name="show_short_name")
    private String showShortName;

    @Id
    @Column(name="show_year")
    private Integer showYear;

    @Column(name="year_month")
    private String yearMonth;

    @Column(name="licence_fee")
    private Integer licenceFee;

    @Column(name="studio_short_name")
    private String studioShortName;

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

    public Integer getLicenceFee() {
        return licenceFee;
    }

    public void setLicenceFee(Integer licenceFee) {
        this.licenceFee = licenceFee;
    }

    public String getStudioShortName() {
        return studioShortName;
    }

    public void setStudioShortName(String studioShortName) {
        this.studioShortName = studioShortName;
    }

    @Override
    public String toString() {
        return "ShowLicenseRecord{" +
                "streamingServiceShortName='" + streamingServiceShortName + '\'' +
                ", showShortName='" + showShortName + '\'' +
                ", showYear=" + showYear +
                ", yearMonth='" + yearMonth + '\'' +
                ", licenceFee=" + licenceFee +
                ", studioShortName='" + studioShortName + '\'' +
                '}';
    }

    public ShowLicenseRecord() {
    }

    public ShowLicenseRecord(String streamingServiceShortName, String showShortName, Integer showYear, String yearMonth, Integer licenceFee, String studioShortName) {
        this.streamingServiceShortName = streamingServiceShortName;
        this.showShortName = showShortName;
        this.showYear = showYear;
        this.yearMonth = yearMonth;
        this.licenceFee = licenceFee;
        this.studioShortName = studioShortName;
    }
}
