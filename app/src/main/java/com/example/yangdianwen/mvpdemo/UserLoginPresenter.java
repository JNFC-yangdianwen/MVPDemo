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
  //Presenter的 constructer，对数据进行初始化
    public UserLoginPresenter(IUserLoginView userLoginView)
    {   //这里userLoginView是携带数据的
        this.userLoginView = userLoginView;
        //这里初始化userBiz使用的多态
        this.userBiz = new UserBiz();
    }

    public void login()
    {
        userLoginView.showLoading();
        //UserBiz类里的login方法
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener()
        {
            //登陆成功要执行的逻辑操作
            @Override
            public void loginSuccess(final User user)
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {   //执行跳转的意图
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });

            }
            //登陆失败要执行的逻辑操作
            @Override
            public void loginFailed()
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {    //显示错误信息
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
