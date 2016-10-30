package com.wanli.com.multitypedemo.api.view.impl;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.wanli.com.multitypedemo.R;
import com.wanli.com.multitypedemo.api.BaseActivity;
import com.wanli.com.multitypedemo.api.presenter.impl.MovieListPreImpl;
import com.wanli.com.multitypedemo.api.view.IBookListView;
import com.wanli.com.multitypedemo.bean.MovieInfoResponse;
import com.wanli.com.multitypedemo.bean.MovieListResponse;
import com.wanli.com.multitypedemo.multi.prividers.MovieListProvider;

import me.drakeet.multitype.MultiTypeAdapter;

public class MoiveListActivity extends BaseActivity implements IBookListView,
        SwipeRefreshLayout.OnRefreshListener{

    private RecyclerView rv;
    private SwipeRefreshLayout swiperefresh;

    private MovieListPreImpl movieListPre;

    private MultiTypeAdapter adapter;

    private static int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        this.swiperefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        this.rv = (RecyclerView) findViewById(R.id.rv_details);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initEvent() {
        swiperefresh.setOnRefreshListener(this);
        movieListPre = new MovieListPreImpl(this);

        onRefresh();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        Log.e("showMessage", msg);
    }

    @Override
    public void showProgress() {
        swiperefresh.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        swiperefresh.setRefreshing(false);
    }

    @Override
    public void showData(Object result) {
        MovieInfoResponse response = (MovieInfoResponse) result;
        adapter = new MultiTypeAdapter(response.getSubjects());
        adapter.register(MovieListResponse.class , new MovieListProvider());
        rv.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        movieListPre.loadMoives(0 ,count);
    }
}
