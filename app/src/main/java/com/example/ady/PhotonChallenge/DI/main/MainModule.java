package com.example.ady.PhotonChallenge.DI.main;


import com.example.ady.PhotonChallenge.Model.CostCalculator;
import com.example.ady.PhotonChallenge.View.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ady on 1/12/2018.
 */

@Module
public class MainModule {
    @Provides
    MainPresenter providesMainPresenter (CostCalculator newsDataSource){
        return new MainPresenter();
    }
}
