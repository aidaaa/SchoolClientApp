package com.example.android.schoolclientapp.model.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrofitModel
{
    @SerializedName("id")
    @Expose
    private String class_name;

    public RetrofitModel(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
