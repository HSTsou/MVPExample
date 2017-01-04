package com.example.handsome.mvpexample.presenter;

import com.example.handsome.mvpexample.view.ILoginView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

/**
 * Created by handsome on 2017/1/4.
 */
public class LoginPresenterTest {

    @Mock
    ILoginView iLoginView;
    LoginPresenter loginPresenter;

    @Before
    public void setup() throws Exception {
        loginPresenter = new LoginPresenter(iLoginView);

    }

    @Test
    public void clear() throws Exception {

    }

    @Test
    public void doLogin() throws Exception {

    }

    @Test
    public void setProgressBarVisibility() throws Exception {

    }

}