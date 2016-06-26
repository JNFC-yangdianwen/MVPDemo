package com.example.yangdianwen.mvpdemo;

/**
 * Created by yangdianwen on 16-6-26.
 * 这是一个接口封装几个方法实现view层与presenter之间的数据交互
 */
public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();

}
