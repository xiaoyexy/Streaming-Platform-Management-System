package edu.gatech.streamingwars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(WatchRecordId.class)
public class WatchRecord {

    @Column(name="percentage_of_account")
    private Integer percentageOfAccount;

    @Id
    @Column(name="demographic_group_short_name")
    private String demographicGroupShortName;

    @Id
    @Column(name="show_short_name")
    private String showShortName;

    @Id
    @Column(name="show_year")
    private Integer showYear;

    @Column(name="streaming_service_short_name")
    private String streamingServiceShortName;

    @Column(name="year_month")
    private String yearMonth;

    @Column(name="watch_price")
    private Integer watchPrice;

    @Column(name="demongraphic_group_num_of_account")
    private Integer demongraphicGroupNumOfAccount;

    @Override
    public String toString() {
        return "WatchRecord{" +
                "percentageOfAccount=" + percentageOfAccount +
                ", demographicGroupShortName='" + demographicGroupShortName + '\'' +
                ", showShortName='" + showShortName + '\'' +
                ", showYear=" + showYear +
                ", streamingServiceShortName='" + streamingServiceShortName + '\'' +
                ", yearMonth='" + yearMonth + '\'' +
                ", watchPrice=" + watchPrice +
                ", demongraphicGroupNumOfAccount=" + demongraphicGroupNumOfAccount +
                '}';
    }

    public Integer getPercentageOfAccount() {
        return percentageOfAccount;
    }

    public void setPercentageOfAccount(Integer percentageOfAccount) {
        this.percentageOfAccount = percentageOfAccount;
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

    public Integer getWatchPrice() {
        return watchPrice;
    }

    public void setWatchPrice(Integer watchPrice) {
        this.watchPrice = watchPrice;
    }

    public Integer getDemongraphicGroupNumOfAccount() {
        return demongraphicGroupNumOfAccount;
    }

    public void setDemongraphicGroupNumOfAccount(Integer demongraphicGroupNumOfAccount) {
        this.demongraphicGroupNumOfAccount = demongraphicGroupNumOfAccount;
    }

    public WatchRecord() {
    }

    public WatchRecord(Integer percentageOfAccount, String demographicGroupShortName, String showShortName, Integer showYear, String streamingServiceShortName, String yearMonth, Integer watchPrice, Integer demongraphicGroupNumOfAccount) {
        this.percentageOfAccount = percentageOfAccount;
        this.demographicGroupShortName = demographicGroupShortName;
        this.showShortName = showShortName;
        this.showYear = showYear;
        this.streamingServiceShortName = streamingServiceShortName;
        this.yearMonth = yearMonth;
        this.watchPrice = watchPrice;
        this.demongraphicGroupNumOfAccount = demongraphicGroupNumOfAccount;
    }
}
