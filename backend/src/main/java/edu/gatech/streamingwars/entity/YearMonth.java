package edu.gatech.streamingwars.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.Objects;


@Repository
public class YearMonth {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof YearMonth)) return false;
        YearMonth yearMonth = (YearMonth) o;
        return getYear() == yearMonth.getYear() &&
                getMonth() == yearMonth.getMonth();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getMonth());
    }

    private int year;
    private int month;

    public YearMonth(int year, int month) {
        this.year = year;
        this.month = month;
    }

    public YearMonth() {
        this.year = 2020;
        this.month = 8;
    }

    public void nextMonth() {
        if (month == 12) { year++; }
        month = (month % 12) + 1;
    }

    public YearMonth getPrevYearMonth() {
        int res_year = year;
        int res_month = month;
        if (month == 1) {
            res_year--;
            res_month = 12;
        } else {
            res_month--;
        }
        return new YearMonth(res_year, res_month);
    }

    @Override
    public String toString() {
        return year + "-" + month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String display(){
        return "time" + "," + month + "," + year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
