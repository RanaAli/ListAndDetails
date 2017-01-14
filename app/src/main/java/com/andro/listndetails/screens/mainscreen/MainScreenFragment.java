package com.andro.listndetails.screens.mainscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andro.listndetails.R;
import com.andro.listndetails.applicationbase.BaseFragment;
import com.andro.listndetails.models.Result;

/**
 * Created by andro on 1/14/2017.
 */

public class MainScreenFragment extends BaseFragment {

    private MainScreenPresenter mMainScreenPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.main_fragment_layout, container, false);

        MainScreenView mainScreenView = new MainScreenView(view.findViewById(R.id.listRootLinearLayout));
        mMainScreenPresenter = new MainScreenPresenter(mainScreenView, savedInstanceState);
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
        public void showDetails(Result result) {
//            Intent intent = DetailsActivity.getDetailsActivityIntent(getActivity(), result);
//            startActivity(intent);
        }

    };
}
