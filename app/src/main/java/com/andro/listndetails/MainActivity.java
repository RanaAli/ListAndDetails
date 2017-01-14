package com.andro.listndetails;

import android.os.Bundle;

import com.andro.listndetails.applicationbase.BaseActivity;
import com.andro.listndetails.screens.mainscreen.MainScreenFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setcontentView();
        addFragment(new MainScreenFragment(), savedInstanceState);
    }
}
