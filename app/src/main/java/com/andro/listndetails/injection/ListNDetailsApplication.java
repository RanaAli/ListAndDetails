package com.andro.listndetails.injection;

import android.app.Application;


/**
 * Created by andro on 1/15/2017.
 */

public class ListNDetailsApplication extends Application {

    private NetApiComponent mNetApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetApiComponent = DaggerNetApiComponent.builder()
                .networkApiModule(new NetworkApiModule(getApplicationContext()))
                .build();
    }

    public NetApiComponent getNetComponent(){
        return mNetApiComponent;
    }
}
