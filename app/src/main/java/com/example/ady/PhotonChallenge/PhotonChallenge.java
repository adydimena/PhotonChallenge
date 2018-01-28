package com.example.ady.PhotonChallenge;

import android.app.Application;
import android.content.Context;

import com.example.ady.PhotonChallenge.DI.app.AppComponent;
import com.example.ady.PhotonChallenge.DI.app.AppModule;
import com.example.ady.PhotonChallenge.DI.app.DaggerAppComponent;
import com.example.ady.PhotonChallenge.DI.main.MainComponent;
import com.example.ady.PhotonChallenge.DI.main.MainModule;


/**
 * Created by Ady on 1/14/2018.
 */

public class PhotonChallenge extends Application {
    public static final String TAG = PhotonChallenge.class.getSimpleName();
    private AppComponent appComponent;
    private MainComponent mainComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        AppModule appModule = new AppModule();
        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build();
    }
    public static PhotonChallenge get(Context context){

        return (PhotonChallenge) context.getApplicationContext();
    }
    public MainComponent getMainComponent(){
        mainComponent = appComponent.add(new MainModule());
        return  mainComponent;
    }

    public void ClearMainCoponent(){
        mainComponent = null;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

    }
}
