package com.wanli.com.multitypedemo.api.presenter.impl;

import com.wanli.com.multitypedemo.api.ApiCompleteListener;
import com.wanli.com.multitypedemo.api.IBaseView;
import com.wanli.com.multitypedemo.api.model.IMovieListModel;
import com.wanli.com.multitypedemo.api.model.impl.MovieListModelImpl;
import com.wanli.com.multitypedemo.api.presenter.IMovieListPresenter;
import com.wanli.com.multitypedemo.api.view.IBookListView;
import com.wanli.com.multitypedemo.bean.BaseResponse;

/**
 * Created by dk on 2016/10/29.
 */

public class MovieListPreImpl implements IMovieListPresenter,ApiCompleteListener{

    private IBookListView iBookListView;
    private IMovieListModel iMovieListModel;

    public MovieListPreImpl(IBaseView view){
        this.iBookListView = (IBookListView) view;
        iMovieListModel = new MovieListModelImpl();
    }

    @Override
    public void onComplected(Object result) {
        iBookListView.hideProgress();
        iBookListView.showData(result);
    }

    @Override
    public void onFailed(BaseResponse msg) {
        iBookListView.showMessage(msg.getMsg());
    }

    @Override
    public void loadMoives(int start, int count) {
        iBookListView.showProgress();
        iMovieListModel.loadMovieList(start , count ,this);
    }

    @Override
    public void cancelLoading() {
        iBookListView.hideProgress();
    }
}
