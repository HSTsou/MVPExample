package com.example.handsome.mvpexample.model;

/**
 * Created by handsome on 2017/1/3.
 */
public interface IUser {
    String getName();
    String getPasswd();
    int checkUserValidity(String name, String passwd);
}
