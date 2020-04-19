package com.example.android.schoolclientapp.model.retrofit;

import androidx.lifecycle.LiveData;

import com.example.android.schoolclientapp.model.model.Classes;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface SchoolApi
{
    @POST("ClassNameShow")
    Call<List<Classes>> classNameShow();

    @POST("ClassNameRegister")
    Call<String> classNameRegister(@QueryMap Map<String,String> map);
}
