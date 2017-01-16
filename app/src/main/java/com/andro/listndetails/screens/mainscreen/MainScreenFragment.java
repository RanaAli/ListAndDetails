package com.andro.listndetails.screens.mainscreen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andro.listndetails.R;
import com.andro.listndetails.api.ApiManager;
import com.andro.listndetails.applicationbase.BaseFragment;

import javax.inject.Inject;

/**
 * Created by andro on 1/14/2017.
 */

public class MainScreenFragment extends BaseFragment {

    private MainScreenPresenter mMainScreenPresenter;

    @Inject
    protected ApiManager mApiManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.main_fragment_layout, container, false);

        getListNDetailsApplication().getNetComponent().inject(this);

        MainScreenView mainScreenView = new MainScreenView(view);
        mMainScreenPresenter = new MainScreenPresenter(mainScreenView, mApiManager);
        mMainScreenPresenter.setMainScreenPresenterInterface(mainScreenPresenterInterface);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        mMainScreenPresenter.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mMainScreenPresenter.onRestoreInstanceState(savedInstanceState);
    }

    private MainScreenPresenter.MainScreenPresenterInterface
            mainScreenPresenterInterface = new MainScreenPresenter.MainScreenPresenterInterface() {
        @Override
        public void showDetails(String url) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }

    };
}
