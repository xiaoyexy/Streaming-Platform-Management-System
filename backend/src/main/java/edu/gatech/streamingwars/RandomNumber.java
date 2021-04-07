package edu.gatech.streamingwars;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RandomNumber {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer value;

    public RandomNumber() {}
  
    public RandomNumber(Integer value) {
        this.value = value;
    }

    public String toString() {
        return String.format("%d", this.value);
    }

    public Long getId() {
        return this.id;
    }

    public Integer getValue() {
        return this.value;
    }
}
