package com.example.yangdianwen.mvpdemo;

/**
 * Created by yangdianwen on 16-6-26.
 * 这是一个登陆的接口
 * 一个登陆的方法login
 * 传入三个参数username，password，loginListener，
 * 当用户点击了login按键时调用此方法
 */
public interface IUserBiz {
    public void login(String username, String password, OnLoginListener loginListener);
}

