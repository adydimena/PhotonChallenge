package com.example.ady.PhotonChallenge.di.app;
import com.example.ady.PhotonChallenge.model.CostCalculator;

import dagger.Module;
import dagger.Provides;
/**
 * Created by Ady.
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