package com.example.ady.PhotonChallenge.di.main;
import com.example.ady.PhotonChallenge.model.CostCalculator;
import com.example.ady.PhotonChallenge.view.main.MainPresenter;
import dagger.Module;
import dagger.Provides;
/**
 * Created by Ady.
 */
@Module
public class MainModule {
    @Provides
    MainPresenter providesMainPresenter (CostCalculator newsDataSource){
        return new MainPresenter();
    }
}