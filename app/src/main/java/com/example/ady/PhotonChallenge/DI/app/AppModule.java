package com.example.ady.PhotonChallenge.DI.app;


import com.example.ady.PhotonChallenge.Model.CostCalculator;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ady on 1/12/2018.
 */
@Module
public class AppModule {
    private final String TAG = AppModule.class.getSimpleName();

    public AppModule() {

    }
    @Provides
    CostCalculator providesRemoteDataSource(){

        return new CostCalculator();

    }
}
