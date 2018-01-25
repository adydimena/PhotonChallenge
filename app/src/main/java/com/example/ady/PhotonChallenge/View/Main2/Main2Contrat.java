package com.example.ady.PhotonChallenge.View.Main2;

import android.content.Context;

import com.example.ady.PhotonChallenge.Data.Local.NewsLocalDatabase;
import com.example.ady.PhotonChallenge.Util.HelperClasses.News;
import com.example.ady.PhotonChallenge.Util.view.BasePresenter;
import com.example.ady.PhotonChallenge.Util.view.BaseView;

import java.util.List;

/**
 * Created by Ady on 1/17/2018.
 */

public interface Main2Contrat {
    interface View extends BaseView {
        void setDatabse(List<News> newsList, NewsLocalDatabase newsLocalDatabase);

    }
    interface Presenter extends BasePresenter<View> {
        void getDataBase (NewsLocalDatabase newsLocalDatabase, Context context);

    }
}
