package com.example.ady.PhotonChallenge.DI.app;

import com.example.ady.PhotonChallenge.DI.main.MainComponent;
import com.example.ady.PhotonChallenge.DI.main.MainModule;


import dagger.Component;

/**
 * Created by Ady on 1/12/2018.
 */

@Component(modules = AppModule.class)
public interface AppComponent {
    MainComponent add(MainModule mainModule);


}
