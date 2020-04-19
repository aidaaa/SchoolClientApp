package com.example.android.schoolclientapp.model.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SchoolApiService
{
    public static String base_url;


    public SchoolApiService(String base_url) {
        this.base_url = base_url;
    }

    static SchoolApiService create(String base_url)
    {
        return new SchoolApiService(base_url);
    }

    public static Retrofit getRetrofit()
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient client=new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
        return new Retrofit.Builder()
                .baseUrl(base_url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
