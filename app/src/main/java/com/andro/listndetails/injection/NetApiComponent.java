package com.andro.listndetails.injection;

import com.andro.listndetails.screens.mainscreen.MainScreenFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by andro on 1/15/2017.
 */

@Singleton
@Component(modules = {NetworkApiModule.class})
public interface NetApiComponent {
    void inject(MainScreenFragment mainScreenFragment);
}
