package com.example.dlarb.local_server;

import android.content.Context;
import android.content.SharedPreferences;

public class Data_Helper {
    Context mContext;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    Data_Helper(Context context){
        mContext = context;
        preferences = context.getSharedPreferences("Local", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void saveText(String text){
        editor.putString("text",text);//key,value
        editor.apply();
    }

    String getText(){
        return preferences.getString("text","");
    }
}