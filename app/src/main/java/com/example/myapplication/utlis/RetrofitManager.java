package com.example.myapplication.utlis;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static RetrofitManager retrofitManager;

    private RetrofitManager() {
    }
    public synchronized static RetrofitManager getRetrofitManager() {
        if(retrofitManager==null){
            retrofitManager=new RetrofitManager();
        }
        return retrofitManager;
    }
    Retrofit retrofit;
    public Retrofit doNetWork(){
        retrofit =new Retrofit.Builder().baseUrl("http://43.143.146.165:7777/").addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
                .build();
        return retrofit;
    }

}
