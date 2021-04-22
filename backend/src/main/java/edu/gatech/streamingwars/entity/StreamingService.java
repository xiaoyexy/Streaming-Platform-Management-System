package edu.gatech.streamingwars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="streaming_service")
public class StreamingService {
    @Id
    @Column(name="short_name")
    private String shortName;

    @Column(name="long_name")
    private String longName;

    @Column(name="subscribe_fee")
    private Integer subscribeFee;

    public StreamingService() {
    }

    public StreamingService(String shortName, String longName, Integer subscribeFee) {
        this.shortName = shortName;
        this.longName = longName;
        this.subscribeFee = subscribeFee;
    }

    @Override
    public String toString() {
        return "StreamingService{" +
                "shortName='" + shortName + '\'' +
                ", longName='" + longName + '\'' +
                ", subscribeFee=" + subscribeFee +
                '}';
    }

    public Integer getSubscribeFee() {
        return subscribeFee;
    }

    public void setSubscribeFee(Integer subscribeFee) {
        this.subscribeFee = subscribeFee;
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

}
