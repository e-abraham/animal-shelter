package com.example.animalshelter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="Dogs")
public class Dog {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double age;
    private String gender;
    private String breed;
    private Double weight;
    private boolean sterilized;
    private LocalDate arrival;

    public Dog() {
    }

    public Dog(String name, Double age, String gender, String breed, Double weight, boolean sterilized, LocalDate arrival) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.breed = breed;
        this.weight = weight;
        this.sterilized = sterilized;
        this.arrival = arrival;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public boolean isSterilized() {
        return sterilized;
    }

    public void setSterilized(boolean sterilized) {
        this.sterilized = sterilized;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public void setArrival(LocalDate arrival) {
        this.arrival = arrival;
    }
}
