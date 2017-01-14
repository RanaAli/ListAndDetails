package com.andro.listndetails.screens.mainscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andro.listndetails.R;
import com.andro.listndetails.applicationbase.BaseFragment;

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
        mMainScreenPresenter = new MainScreenPresenter(mainScreenView);
//        mMainScreenPresenter.setMainScreenPresenterInterface(mainScreenPresenterInterface);

        return view;
    }

//    private MainScreenPresenter.MainScreenPresenterInterface
//            mainScreenPresenterInterface = new MainScreenPresenter.MainScreenPresenterInterface() {
//        @Override
//        public void showDetails(Result result) {
//            Intent intent = DetailsActivity.getDetailsActivityIntent(MainActivity.this, result);
//            startActivity(intent);
//        }
//
//        @Override
//        public void showDatePicker() {
//            final Calendar c = Calendar.getInstance();
//            int mYear = c.get(Calendar.YEAR);
//            int mMonth = c.get(Calendar.MONTH);
//            int mDay = c.get(Calendar.DAY_OF_MONTH);
//
//            DatePickerDialog datePickerDialog = new DatePickerDialog(
//                    MainActivity.this, onDateSetListener, mYear, mMonth, mDay);
//
//            datePickerDialog.show();
//        }
//    };
}
