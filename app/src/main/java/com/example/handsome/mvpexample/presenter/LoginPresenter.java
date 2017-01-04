package com.example.handsome.mvpexample.presenter;

import com.example.handsome.mvpexample.model.IUser;
import com.example.handsome.mvpexample.model.UserModel;
import com.example.handsome.mvpexample.view.ILoginView;

/**
 * Created by handsome on 2017/1/3.
 */

public class LoginPresenter implements ILoginPresenter {
    ILoginView iLoginView;
    IUser user;

    private static final String TEST_NAME = "mvp";
    private static final String TEST_PASSWD = "mvp";

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
    }

    private void initUser() {
        user = new UserModel(TEST_NAME, TEST_PASSWD);
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String passwd) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name, passwd);// 1 = true, means correct name and pw.
        if (code != 1) {
            isLoginSuccess = false;
        }
        final Boolean result = isLoginSuccess;
        iLoginView.onLoginResult(result, code);
    }

    @Override
    public void setProgressBarVisibility(int visibility) {
        iLoginView.onSetProgressBarVisibility(visibility);
    }
}
