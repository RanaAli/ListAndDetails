package com.andro.listndetails.screens.mainscreen;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.andro.listndetails.R;

/**
 * Created by andro on 1/14/2017.
 */

public class MainScreenView {
    private View mView;

    private RecyclerView mRecyclerView;
    private RelativeLayout mProgressLayout;

    private LinearLayoutManager mLinearLayoutManager;

    private MainScreenViewInterface mMainScreenViewInterface;

    public MainScreenView(View mView) {
        this.mView = mView;

        bindView();
        setupView();
    }

    private void bindView() {
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.movieListRecycleView);
        mProgressLayout = (RelativeLayout) mView.findViewById(R.id.movieProgressViewRelativeLayout);
    }

    private void setupView() {
        mLinearLayoutManager = new LinearLayoutManager(mView.getContext());

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
//        mRecyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(mLinearLayoutManager) {
//            @Override
//            public void onLoadMore(int page, int totalItemsCount) {
//                if (mMainScreenViewInterface != null) {
//                    mMainScreenViewInterface.loadMore(page, totalItemsCount);
//                }
//            }
//        });
    }

    public Context getContext() {
        return mView.getContext();
    }

    public void populateList(MovieListAdaptor movieListAdaptor) {
        mRecyclerView.setAdapter(movieListAdaptor);
    }

    public void showProgress() {
        mProgressLayout.setVisibility(View.VISIBLE);
    }

    public void dismissProgress() {
        mProgressLayout.setVisibility(View.GONE);
    }

    public void setMainScreenViewInterface(MainScreenViewInterface mainScreenViewInterface) {
        this.mMainScreenViewInterface = mainScreenViewInterface;
    }

    public interface MainScreenViewInterface {
        void loadMore(int page, int totalItemCount);
    }
}
