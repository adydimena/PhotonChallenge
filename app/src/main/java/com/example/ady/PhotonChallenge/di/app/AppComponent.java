package com.example.ady.PhotonChallenge.di.app;
import com.example.ady.PhotonChallenge.di.main.MainComponent;
import com.example.ady.PhotonChallenge.di.main.MainModule;
import dagger.Component;
/**
 * Created by Ady.
 */
@Component(modules = AppModule.class)
public interface AppComponent {
    MainComponent add(MainModule mainModule);
}