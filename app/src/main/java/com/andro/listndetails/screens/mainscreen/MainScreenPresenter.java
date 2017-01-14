package com.andro.listndetails.screens.mainscreen;

import android.os.Bundle;

import com.andro.listndetails.api.ApiManager;
import com.andro.listndetails.models.Discover;
import com.andro.listndetails.models.Result;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by andro on 1/14/2017.
 */

public class MainScreenPresenter {
    public static final String ADAPTOR_DATA = "adaptorData";
    public static final String PAGE_NUMBER = "pageNumber";
    private MainScreenView mMainScreenView;

    private ApiManager mApiManager;
    private MovieListAdaptor mMovieListAdapter;
    private List<Result> mResults;

    private MainScreenPresenterInterface mMainScreenPresenterInterface;

    private int mPage = 1;

    public MainScreenPresenter(MainScreenView mMainScreenView, Bundle savedInstanceState) {
        this.mMainScreenView = mMainScreenView;

        mResults = new ArrayList<>();

        mMainScreenView.setMainScreenViewInterface(mainScreenViewInterface);

        mMovieListAdapter = new MovieListAdaptor();
        mMovieListAdapter.setMovieListAdapterInterface(mMovieListAdapterInterface);
        mMainScreenView.populateList(mMovieListAdapter);

        mApiManager = new ApiManager(mMainScreenView.getContext());
    }

    private Callback discoverCallback = new Callback<Discover>() {
        @Override
        public void onResponse(Call<Discover> call, Response<Discover> response) {

            mResults.addAll(response.body().getResults());
            mMovieListAdapter.setData(mResults);
            mMainScreenView.dismissProgress();
        }

        @Override
        public void onFailure(Call<Discover> call, Throwable t) {
            mMainScreenView.dismissProgress();
        }
    };

    private MovieListAdaptor.MovieListAdapterInterface
            mMovieListAdapterInterface = new MovieListAdaptor.MovieListAdapterInterface() {
        @Override
        public void onItemClicked(Result result) {
            if (mMainScreenPresenterInterface != null) {
                mMainScreenPresenterInterface.showDetails(result);
            }
        }
    };

    private MainScreenView.MainScreenViewInterface
            mainScreenViewInterface = new MainScreenView.MainScreenViewInterface() {

        @Override
        public void loadMore(int page, int totalItemCount) {
            mMainScreenView.showProgress();
            mPage = page + 1;

            mApiManager.discover(mPage, discoverCallback);
        }
    };

    public void onSaveInstanceState(Bundle savedInstanceState) {
        if (mMovieListAdapter != null) {
            List<Result> results = mMovieListAdapter.getData();

            savedInstanceState.putParcelable(ADAPTOR_DATA, Parcels.wrap(results));
            savedInstanceState.putInt(PAGE_NUMBER, mPage);
        }
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.getParcelable(ADAPTOR_DATA) != null) {
            mResults = Parcels.unwrap(savedInstanceState.getParcelable(ADAPTOR_DATA));
            mMovieListAdapter.setData(mResults);

            mPage = savedInstanceState.getInt(PAGE_NUMBER);
        }else{
            mMainScreenView.showProgress();
            mApiManager.discover(mPage, discoverCallback);
        }
    }

    public void setMainScreenPresenterInterface(MainScreenPresenterInterface mainScreenPresenterInterface) {
        this.mMainScreenPresenterInterface = mainScreenPresenterInterface;
    }

    public interface MainScreenPresenterInterface {
        void showDetails(Result result);
    }
}
