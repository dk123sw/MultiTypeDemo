package com.wanli.com.multitypedemo.api.presenter;

/**
 * Created by dk on 2016/10/29.
 */

public interface IMovieListPresenter {

    void loadMoives(int start ,int count);

    void cancelLoading();
}
