package com.wanli.com.multitypedemo.bean;

import java.io.Serializable;

/**
 * Created by dk on 2016/10/29.
 */

public class MovieRatingBean implements Serializable {
    private int max;
    private String average;
    private int stars;
    private int min;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
