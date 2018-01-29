package com.example.ady.PhotonChallenge.di.app;
import com.example.ady.PhotonChallenge.model.costCalculator;
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
    costCalculator providesRemoteDataSource(){
        return new costCalculator();
    }
}