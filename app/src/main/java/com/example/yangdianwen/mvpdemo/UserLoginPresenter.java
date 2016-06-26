package com.example.yangdianwen.mvpdemo;

import android.os.Handler;

/**
 * Created by yangdianwen on 16-6-26.
 * 这是一个Presenter层，处理业务逻辑，实现model与view之间的数据交互
 * 使用handler处理异步任务
 * 指定了IUserBiz，IUserLoginView这两个接口的引用，调用其中的几个方法
 */
public class UserLoginPresenter
{


    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView)
    {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login()
    {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener()
        {
            @Override
            public void loginSuccess(final User user)
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });

            }
            @Override
            public void loginFailed()
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });
            }
        });
    }
    //清空数据方法
    public void clear()
    {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
