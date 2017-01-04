package com.example.handsome.mvpexample.presenter;

import com.example.handsome.mvpexample.view.ILoginView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

/**
 * Created by handsome on 2017/1/4.
 */
public class LoginPresenterTest {

    @Mock
    ILoginView iLoginView;
    @Mock
    LoginPresenter loginPresenter;

    @Before
    public void setup() throws Exception {
       loginPresenter = mock(LoginPresenter.class);

    }

    @Test
    public void doLoginTest() throws Exception {
        String name ="mvp";
        String passwd = "mvp";

       /* when(loginPresenter.doLogin(name, passwd)).thenReturn(1);
        int abs = mathUtils.abs(-1);
        Assert.assertEquals(abs, 1);*/
    }

}