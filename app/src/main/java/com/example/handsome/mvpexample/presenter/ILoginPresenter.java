package com.example.handsome.mvpexample.presenter;

/**
 * Created by handsome on 2017/1/3.
 */

public interface ILoginPresenter {
    void clear();
    void doLogin(String name, String passwd);
    void setProgressBarVisibility(int visibility);
}


