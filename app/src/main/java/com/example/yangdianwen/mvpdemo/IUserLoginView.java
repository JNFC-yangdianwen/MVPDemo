package com.example.yangdianwen.mvpdemo;

/**
 * Created by yangdianwen on 16-6-26.
 *
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
