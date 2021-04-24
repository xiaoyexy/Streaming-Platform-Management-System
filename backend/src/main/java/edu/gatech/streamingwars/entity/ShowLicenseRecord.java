package edu.gatech.streamingwars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ShowLicenseRecordId.class)
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

    @Id
    @Column(name="year_month")
    private String yearMonth;

    @Column(name="license_fee")
    private Integer licenseFee;

    @Column(name="watch_price")
    private Integer watchPrice;

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

    public Integer getLicenseFee() {
        return licenseFee;
    }

    public void setLicenseFee(Integer licenseFee) {
        this.licenseFee = licenseFee;
    }

    public Integer getWatchPrice() {
        return watchPrice;
    }

    public void setWatchPrice(Integer watchPrice) {
        this.watchPrice = watchPrice;
    }

    @Override
    public String toString() {
        return "ShowLicenseRecord{" +
                "streamingServiceShortName='" + streamingServiceShortName + '\'' +
                ", showShortName='" + showShortName + '\'' +
                ", showYear=" + showYear +
                ", yearMonth='" + yearMonth + '\'' +
                ", licenseFee=" + licenseFee +
                ", watchPrice=" + watchPrice +
                ", studioShortName='" + studioShortName + '\'' +
                '}';
    }

    public String getStudioShortName() {
        return studioShortName;
    }

    public void setStudioShortName(String studioShortName) {
        this.studioShortName = studioShortName;
    }

    public ShowLicenseRecord(String streamingServiceShortName, String showShortName, Integer showYear, String yearMonth, Integer licenseFee, Integer watchPrice, String studioShortName) {
        this.streamingServiceShortName = streamingServiceShortName;
        this.showShortName = showShortName;
        this.showYear = showYear;
        this.yearMonth = yearMonth;
        this.licenseFee = licenseFee;
        this.watchPrice = watchPrice;
        this.studioShortName = studioShortName;
    }

    public ShowLicenseRecord() {
    }

}
