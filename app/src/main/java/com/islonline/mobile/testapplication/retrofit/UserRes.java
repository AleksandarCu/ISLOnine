package com.islonline.mobile.testapplication.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRes {

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("result")
    @Expose
    private Result result;

    public UserRes(Data data, Result result) {
        this.data = data;
        this.result = result;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public class Result {

        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("hs")
        @Expose
        private String hs;
        @SerializedName("server")
        @Expose
        private Integer server;

        public Result(String code, String hs, Integer server) {
            this.code = code;
            this.hs = hs;
            this.server = server;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getHs() {
            return hs;
        }

        public void setHs(String hs) {
            this.hs = hs;
        }

        public Integer getServer() {
            return server;
        }

        public void setServer(Integer server) {
            this.server = server;
        }

    }

    public class Data {

        @SerializedName("lang")
        @Expose
        private String lang;
        @SerializedName("one_time_password")
        @Expose
        private String oneTimePassword;
        @SerializedName("sid")
        @Expose
        private String sid;

        public Data(String lang, String oneTimePassword, String sid) {
            this.lang = lang;
            this.oneTimePassword = oneTimePassword;
            this.sid = sid;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getOneTimePassword() {
            return oneTimePassword;
        }

        public void setOneTimePassword(String oneTimePassword) {
            this.oneTimePassword = oneTimePassword;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

    }

}