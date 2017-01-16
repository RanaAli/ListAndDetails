package com.andro.listndetails.applicationbase;

import android.app.Fragment;

import com.andro.listndetails.injection.ListNDetailsApplication;

/**
 * Created by andro on 1/14/2017.
 */

public class BaseFragment extends Fragment {

    protected ListNDetailsApplication getListNDetailsApplication() {
        return ((BaseActivity) getActivity()).getListNDetailsApplication();
    }
}
