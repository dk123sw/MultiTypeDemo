package com.wanli.com.multitypedemo.bean;

import java.util.List;

/**
 * Created by dk on 2016/10/29.
 */

public class MovieInfoResponse extends BaseResponse {
    private int count;
    private int start;
    private int total;
    protected List<MovieListResponse> subjects;

    public MovieInfoResponse() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<MovieListResponse> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<MovieListResponse> subjects) {
        this.subjects = subjects;
    }


}
