package com.wanli.com.multitypedemo.api.model.impl;

import com.google.gson.Gson;
import com.wanli.com.multitypedemo.api.ApiCompleteListener;
import com.wanli.com.multitypedemo.api.http.ServiceFactory;
import com.wanli.com.multitypedemo.api.http.services.IMovieListService;
import com.wanli.com.multitypedemo.api.model.IMovieListModel;
import com.wanli.com.multitypedemo.bean.BaseResponse;
import com.wanli.com.multitypedemo.bean.MovieInfoResponse;

import java.net.UnknownHostException;

import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dk on 2016/10/29.
 */

public class MovieListModelImpl implements IMovieListModel {

    @Override
    public void loadMovieList(int start, int count,final ApiCompleteListener listener) {
        IMovieListService service = ServiceFactory.createService(IMovieListService.class);
        service.getMovieList(start ,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response<MovieInfoResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof UnknownHostException) {
                            listener.onFailed(null);
                            return;
                        }
                        listener.onFailed(new BaseResponse(404, e.getMessage()));
                    }

                    @Override
                    public void onNext(Response<MovieInfoResponse> movieInfoResponseResponse) {
                        if (movieInfoResponseResponse.isSuccessful()) {
                            String str = new Gson().toJson(movieInfoResponseResponse.body());
                            listener.onComplected(movieInfoResponseResponse.body());
                        } else {
                            listener.onFailed(new BaseResponse(movieInfoResponseResponse.code(),
                                    movieInfoResponseResponse.message()));
                        }
                    }
                });
    }

    @Override
    public void cancelLoading() {

    }
}
