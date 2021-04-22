package edu.gatech.streamingwars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="show")
public class Show {

    @Id
    @Column(name="short_name")
    private String shortName;

    @Id
    @Column(name="year")
    private Integer year;

    @Column(name="duration")
    private Integer duration;

    @Column(name="show_type")
    private String showType;

    @Column(name="price")
    private Integer price;

    @Column(name="studio_name")
    private String studioName;

    @Override
    public String toString() {
        return "Show{" +
                "shortName='" + shortName + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                ", showType='" + showType + '\'' +
                ", price=" + price +
                ", studioName='" + studioName + '\'' +
                '}';
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public Show() {
    }

    public Show(String shortName, Integer year, Integer duration, String showType, Integer price, String studioName) {
        this.shortName = shortName;
        this.year = year;
        this.duration = duration;
        this.showType = showType;
        this.price = price;
        this.studioName = studioName;
    }
}
