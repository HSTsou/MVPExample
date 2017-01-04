package com.example.handsome.mvpexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.handsome.mvpexample.presenter.ILoginPresenter;
import com.example.handsome.mvpexample.presenter.LoginPresenter;
import com.example.handsome.mvpexample.view.ILoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ILoginView {

    ILoginPresenter loginPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_login_username)
    EditText etLoginUsername;
    @BindView(R.id.et_login_password)
    EditText etLoginPassword;
    @BindView(R.id.btn_login_login)
    Button btnLoginLogin;
    @BindView(R.id.btn_login_clear)
    Button btnLoginClear;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.progress_login)
    ProgressBar progressLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        loginPresenter = new LoginPresenter(this);
        loginPresenter.setProgressBarVisibility(View.INVISIBLE);
    }


    @OnClick({R.id.fab, R.id.btn_login_clear, R.id.btn_login_login})
    public void doClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            case R.id.btn_login_clear:
                loginPresenter.clear();
                break;
            case R.id.btn_login_login:
                loginPresenter.setProgressBarVisibility(View.VISIBLE);
                btnLoginLogin.setEnabled(false);
                btnLoginClear.setEnabled(false);
                loginPresenter.doLogin(etLoginUsername.getText().toString(), etLoginPassword.getText().toString());
                break;
        }
    }

    @Override
    public void onClearText() {
        etLoginUsername.setText("");
        etLoginPassword.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        loginPresenter.setProgressBarVisibility(View.INVISIBLE);
        btnLoginLogin.setEnabled(true);
        btnLoginClear.setEnabled(true);
        if (result) {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            // startActivity(new Intent(this, HomeActivity.class));
        } else
            Toast.makeText(this, "Login Fail, code = " + code, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressLogin.setVisibility(visibility);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
