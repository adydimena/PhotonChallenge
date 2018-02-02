package com.example.ady.PhotonChallenge.di.main;
import com.example.ady.PhotonChallenge.model.PathCalculator;
import com.example.ady.PhotonChallenge.view.main.PhotonPresenter;
import dagger.Module;
import dagger.Provides;
/**
 * Created by Ady.
 */
@Module
public class MainModule {
    @Provides
    PhotonPresenter providesMainPresenter (PathCalculator newsDataSource){
        return new PhotonPresenter();
    }
}