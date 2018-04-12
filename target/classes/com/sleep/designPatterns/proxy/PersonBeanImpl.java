package com.sleep.designPatterns.proxy;

public class PersonBeanImpl implements PersonBean {
    private String name;
    private String gender;
    private String interests;
    private int hotOrNotRating;

    public PersonBeanImpl() {
    }

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }

    public String getInterests() {
        return interests;
    }

    public int getHotOrNotRating() {
        return this.hotOrNotRating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public void setHotOrNotRating(int rating) {
        this.hotOrNotRating = rating;
    }
}
