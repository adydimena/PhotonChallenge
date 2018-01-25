package com.example.ady.PhotonChallenge.View.main;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;

import com.example.ady.PhotonChallenge.Util.view.BasePresenter;
import com.example.ady.PhotonChallenge.Util.view.BaseView;

/**
 * Created by Ady on 1/14/2018.
 */

public interface MainContract {


    // methods for the main Activity
    interface View extends BaseView {
        void setrowsANDClomuns(ArrayAdapter<Integer> row, ArrayAdapter<Integer> column);
    }
    interface Presenter extends BasePresenter<View>{
        void getrowsANDcolumns(Context context);
        void getTableSetup(TableLayout table, Integer userRowChoice, Integer userColumnChoice, Context context);
        void getRandom(Integer row, Integer column,TableLayout table, Context context);
    }
}
