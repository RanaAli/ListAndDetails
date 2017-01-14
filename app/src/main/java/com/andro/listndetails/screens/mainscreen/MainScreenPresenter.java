package com.andro.listndetails.screens.mainscreen;

import com.andro.listndetails.api.ApiManager;
import com.andro.listndetails.models.Discover;
import com.andro.listndetails.models.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by andro on 1/14/2017.
 */

public class MainScreenPresenter {
    public static final String OUTPUT_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    private MainScreenView mMainScreenView;

    private ApiManager mApiManager;
    private MovieListAdaptor mMovieListAdapter;

    private MainScreenPresenterInterface mMainScreenPresenterInterface;

    private int mPage = 1;

    public MainScreenPresenter(MainScreenView mMainScreenView) {
        this.mMainScreenView = mMainScreenView;

        mMainScreenView.setMainScreenViewInterface(mainScreenViewInterface);

        mMovieListAdapter = new MovieListAdaptor();
        mMovieListAdapter.setMovieListAdapterInterface(mMovieListAdapterInterface);
        mMainScreenView.populateList(mMovieListAdapter);

        mApiManager = new ApiManager(mMainScreenView.getContext());
        mMainScreenView.showProgress();
        mApiManager.discover(mPage, discoverCallback);

    }

    private Callback discoverCallback = new Callback<Discover>() {
        @Override
        public void onResponse(Call<Discover> call, Response<Discover> response) {

            mMovieListAdapter.addData(response.body().getResults());
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

    public void setMainScreenPresenterInterface(MainScreenPresenterInterface mainScreenPresenterInterface) {
        this.mMainScreenPresenterInterface = mainScreenPresenterInterface;
    }

    public interface MainScreenPresenterInterface {
        void showDetails(Result result);
    }
}
