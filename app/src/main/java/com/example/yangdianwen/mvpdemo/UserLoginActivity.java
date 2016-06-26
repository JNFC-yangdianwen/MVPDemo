package com.example.yangdianwen.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by yangdianwen on 16-6-26.
 * 主界面的逻辑处理
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

        //登陆监听
        mBtnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mUserLoginPresenter.login();
            }
        });
        //清除数据监听
        mBtnClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mUserLoginPresenter.clear();
            }
        });
    }
    //获取用户信息
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

    //清空数据具体操作
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
    //显示progressbar
    @Override
    public void showLoading()
    {

    }
    //隐藏progressbar
    @Override
    public void hideLoading()
    {

    }
      //登陆成功后要执行的逻辑操作
    @Override
    public void toMainActivity(User user)
    {
        Toast.makeText(this, user.getUsername() + " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    //登陆失败的逻辑操作
    @Override
    public void showFailedError()
    {
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
    }
}