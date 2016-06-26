package com.example.yangdianwen.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by yangdianwen on 16-6-26.
 */
public class UserLoginActivity extends AppCompatActivity implements IUserLoginView
{
    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }
    private void initViews()
    {
        mEtUsername = (EditText) findViewById(R.id.et_user);
        mEtPassword = (EditText) findViewById(R.id.et_psw);

        mBtnClear = (Button) findViewById(R.id.btn_clear);
        mBtnLogin = (Button) findViewById(R.id.btn_login);


        mBtnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mUserLoginPresenter.login();
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mUserLoginPresenter.clear();
            }
        });
    }
    @Override
    public String getUserName()
    {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword()
    {
        return mEtPassword.getText().toString();
    }
    @Override
    public void clearUserName()
    {
        mEtUsername.setText("");
    }
    @Override
    public void clearPassword()
    {
        mEtPassword.setText("");
    }
    @Override
    public void showLoading()
    {

    }

    @Override
    public void hideLoading()
    {

    }

    @Override
    public void toMainActivity(User user)
    {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError()
    {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }
}