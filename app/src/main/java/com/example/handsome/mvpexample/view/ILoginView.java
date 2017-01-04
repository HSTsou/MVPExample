package com.example.handsome.mvpexample.view;

/**
 * Created by handsome on 2017/1/3.
 */
public interface ILoginView {
   void onClearText();
    void onLoginResult(Boolean result, int code);
    void onSetProgressBarVisibility(int visibility);
}

