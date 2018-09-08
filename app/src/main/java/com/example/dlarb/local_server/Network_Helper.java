package com.example.dlarb.local_server;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network_Helper {
    final static String url = "http://aws.soylatte.kr";
    final static int port = 5000;

    public static Retrofit retrofit;

    public static NetworkInterface getInstance(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(url+":"+port).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(NetworkInterface.class);
    }

}
