package com.example.ayatidevices.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceUtils {

    SharedPreferences preferences;
    Context context;
    private static final String PREF_NAME = "androidhive-welcome";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PreferenceUtils(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.context = context;
    }

    public void setLogin(boolean status) {
        SharedPreferences.Editor editor_loginStatus = preferences.edit();
        editor_loginStatus.putBoolean("LOGIN", status);
        editor_loginStatus.apply();
    }

    public void setClear() {
        SharedPreferences.Editor editor_loginStatus = preferences.edit();
        editor_loginStatus.putBoolean("LOGIN", false);
        editor_loginStatus.clear();
        editor_loginStatus.apply();
    }

    public void setKeepMeLoin(boolean status) {
        SharedPreferences.Editor editor_loginStatus = preferences.edit();
        editor_loginStatus.putBoolean("keepMeLogin", status);
        editor_loginStatus.apply();
    }

    public boolean isLogin() {
        return preferences.getBoolean("LOGIN", false);
    }


    public void setUserName(String uname) {
        SharedPreferences.Editor editor_Uid = preferences.edit();
        editor_Uid.putString("uname", uname);
        editor_Uid.apply();
    }

    public String getUserName() {
        return preferences.getString("uname", "");
    }


    public void setCno(String uname) {
        SharedPreferences.Editor editor_Uid = preferences.edit();
        editor_Uid.putString("cno", uname);
        editor_Uid.apply();
    }

    public String getCno() {
        return preferences.getString("cno", "");
    }


    public void setDob(String uname) {
        SharedPreferences.Editor editor_Uid = preferences.edit();
        editor_Uid.putString("dob", uname);
        editor_Uid.apply();
    }

    public String getDob() {
        return preferences.getString("dob", null);
    }

    public void setCity(String city) {
        SharedPreferences.Editor editor_Uid = preferences.edit();
        editor_Uid.putString("city", city);
        editor_Uid.apply();
    }

    public String getCity() {
        return preferences.getString("city", null);
    }


    public void setStatus(String status) {
        SharedPreferences.Editor editor_Uid = preferences.edit();
        editor_Uid.putString("status", status);
        editor_Uid.apply();
    }

    public String getStatus() {
        return preferences.getString("status", null);
    }


    public void setId(String id) {
        SharedPreferences.Editor editor_Uid = preferences.edit();
        editor_Uid.putString("id", id);
        editor_Uid.apply();
    }

    public String getId() {
        return preferences.getString("id", null);
    }

}