package com.example.handsome.mvpexample.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.handsome.mvpexample.model.IUser;
import com.example.handsome.mvpexample.model.UserModel;
import com.example.handsome.mvpexample.view.ILoginView;

/**
 * Created by handsome on 2017/1/3.
 */

public class LoginPresenter implements ILoginPresenter {
    ILoginView iLoginView;
    IUser user;
    Handler handler;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    private void initUser() {
        user = new UserModel("mvp","mvp");
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String passwd) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name, passwd);// 1 = true, means correct name and pw.
        if (code!=1) {
            isLoginSuccess = false;
        }
        final Boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);
            }
        }, 3000);
    }

    @Override
    public void setProgressBarVisibility(int visibility) {
        iLoginView.onSetProgressBarVisibility(visibility);
    }
}
