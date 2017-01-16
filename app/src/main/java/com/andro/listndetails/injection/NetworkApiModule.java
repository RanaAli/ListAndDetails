package com.andro.listndetails.injection;

import android.content.Context;

import com.andro.listndetails.api.ApiManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andro on 1/15/2017.
 */

@Module
public class NetworkApiModule {
    Context mContext;

    public NetworkApiModule(Context context){
        mContext = context;
    }

    @Singleton
    @Provides
    ApiManager provideApiManager(){
        return new ApiManager(mContext);
    }
}
