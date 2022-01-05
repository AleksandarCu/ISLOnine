package com.islonline.mobile.testapplication.retrofit;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("user")
    public String user;

    @SerializedName("pwd")
    public String pwd;

    public User(String user, String pwd){
        this.user = user;
        this.pwd = pwd;
    }
}
