package com.heritsam.majeliscoding1.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class DataConfig {

    public static final String SP_CONFIG = "MajelisCoding";

    public static void setLogin(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_CONFIG, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("login", true);
        editor.apply();
    }

    public static boolean isLogin(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_CONFIG, 0);
        return sp.getBoolean("login", false);
    }

    public static void setLogout(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_CONFIG, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
    }
}
