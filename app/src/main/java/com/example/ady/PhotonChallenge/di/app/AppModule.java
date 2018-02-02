package com.example.ady.PhotonChallenge.di.app;

import com.example.ady.PhotonChallenge.model.PathCalculator;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ady.
 */
@Module
public class AppModule {
    public AppModule() {
    }

    @Provides
    PathCalculator providesRemoteDataSource() {
        return new PathCalculator();
    }
}