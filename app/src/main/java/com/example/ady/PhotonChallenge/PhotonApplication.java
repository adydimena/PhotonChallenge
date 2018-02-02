/* Created by Ady
 * This class extends the Application class and set up the MVP Structure
 */
package com.example.ady.PhotonChallenge;

import android.app.Application;
import android.content.Context;

import com.example.ady.PhotonChallenge.di.app.AppComponent;
import com.example.ady.PhotonChallenge.di.app.AppModule;
import com.example.ady.PhotonChallenge.di.app.DaggerAppComponent;
import com.example.ady.PhotonChallenge.di.main.MainComponent;
import com.example.ady.PhotonChallenge.di.main.MainModule;

/**
 * Created by Ady on 1/14/2018.
 */

public class PhotonApplication extends Application {
    public static final String TAG = PhotonApplication.class.getSimpleName();
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

    public static PhotonApplication get(Context context) {

        return (PhotonApplication) context.getApplicationContext();
    }

    public MainComponent getMainComponent() {
        mainComponent = appComponent.add(new MainModule());
        return mainComponent;
    }

    public void ClearMainCoponent() {
        mainComponent = null;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}