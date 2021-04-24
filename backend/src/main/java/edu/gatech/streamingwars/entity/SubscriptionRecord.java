package edu.gatech.streamingwars.entity;

import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(SubscriptionRecordId.class)
public class SubscriptionRecord {

    @Id
    @Column(name="demographic_group_short_name")
    private String demographicGroupShortName;

    @Id
    @Column(name="streaming_service_short_name")
    private String streamingServiceShortName;

    @Id
    @Column(name="year_month")
    private String yearMonth;

    @Column(name="percentage")
    private Integer percentage;

    @Column(name="subscription_fee")
    private Integer subscriptionFee;

    @Column(name="demongraphic_group_num_of_account")
    private Integer demongraphicGroupNumOfAccount;

    public SubscriptionRecord() {
    }

    @Override
    public String toString() {
        return "SubscriptionRecord{" +
                "demographicGroupShortName='" + demographicGroupShortName + '\'' +
                ", streamingServiceShortName='" + streamingServiceShortName + '\'' +
                ", yearMonth='" + yearMonth + '\'' +
                ", percentage=" + percentage +
                ", subscriptionFee=" + subscriptionFee +
                ", demongraphicGroupNumOfAccount=" + demongraphicGroupNumOfAccount +
                '}';
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

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public Integer getSubscriptionFee() {
        return subscriptionFee;
    }

    public void setSubscriptionFee(Integer subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    public Integer getDemongraphicGroupNumOfAccount() {
        return demongraphicGroupNumOfAccount;
    }

    public void setDemongraphicGroupNumOfAccount(Integer demongraphicGroupNumOfAccount) {
        this.demongraphicGroupNumOfAccount = demongraphicGroupNumOfAccount;
    }

    public SubscriptionRecord(String demographicGroupShortName, String streamingServiceShortName, String yearMonth, Integer percentage, Integer subscriptionFee, Integer demongraphicGroupNumOfAccount) {
        this.demographicGroupShortName = demographicGroupShortName;
        this.streamingServiceShortName = streamingServiceShortName;
        this.yearMonth = yearMonth;
        this.percentage = percentage;
        this.subscriptionFee = subscriptionFee;
        this.demongraphicGroupNumOfAccount = demongraphicGroupNumOfAccount;
    }
}
