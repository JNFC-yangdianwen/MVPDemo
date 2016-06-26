package com.example.yangdianwen.mvpdemo;

/**
 * Created by yangdianwen on 16-6-26.
 * 这是一个监听登陆状态的接口，两个方法loginSuccess，loginFailed
 */
public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
