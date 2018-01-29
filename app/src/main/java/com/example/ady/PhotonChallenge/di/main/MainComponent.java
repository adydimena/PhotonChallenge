package com.example.ady.PhotonChallenge.di.main;
import com.example.ady.PhotonChallenge.view.main.MainActivity;
import dagger.Subcomponent;
/**
 * Created by Ady.
 */
@Subcomponent (modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}