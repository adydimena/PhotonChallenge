package com.example.ady.PhotonChallenge.util.view;
/**
 * Created by Ady.
 */
public interface BasePresenter <V extends BaseView>  {
    void attachView (V view);
    void detachView();
}