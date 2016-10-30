package com.wanli.com.multitypedemo.api.http.services;

import com.wanli.com.multitypedemo.bean.MovieInfoResponse;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dk on 2016/10/29.
 */

public interface IMovieListService {
    @GET("movie/top250")
    Observable<Response<MovieInfoResponse>> getMovieList(@Query("start")int start , @Query("count")int count);
}
