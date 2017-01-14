package com.andro.listndetails.applicationbase;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.andro.listndetails.R;

/**
 * Created by andro on 1/14/2017.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    protected void setcontentView(){
        setContentView(R.layout.generic_activity_layout);
    }

    protected void addFragment(BaseFragment fragment, Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.genericActivityFrameLayout, fragment);
            ft.commit();
        }
    }


}
