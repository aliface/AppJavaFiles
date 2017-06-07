package com.example.homepagemod;


import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by alice on 6/7/2017.
 */

public class Session {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public Session(Context ctx){
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("rucharged", Context.MODE_PRIVATE);
        editor = prefs.edit();

    }

    public void setLoggedIn(boolean LoggedIn){
        editor.putBoolean("LoggedInmode", LoggedIn);
        editor.commit();
    }
     public boolean loggedIn(){
         return prefs.getBoolean("loggedInmode",false);
     }
}
