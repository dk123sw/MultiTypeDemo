package com.wanli.com.multitypedemo.api.model;

import com.wanli.com.multitypedemo.api.ApiCompleteListener;

/**
 * Created by dk on 2016/10/29.
 */

public interface IMovieListModel {

    void loadMovieList(int start , int count , ApiCompleteListener listener);

    void cancelLoading();
}
