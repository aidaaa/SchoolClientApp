package com.example.android.schoolclientapp.model.retrofit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.android.schoolclientapp.model.model.Classes;
import com.example.android.schoolclientapp.model.model.Lessons;
import com.example.android.schoolclientapp.model.model.Students;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitRepository
{
    public static RetrofitRepository retrofitRepository;
    SchoolApi schoolApi;
    Retrofit retrofit;
    SchoolApiService schoolApiService;
    private MutableLiveData<List<Classes>> allClass=new MutableLiveData<>();
    private LiveData<List<Lessons>> allLessons;
    private LiveData<List<Students>> allStudent;

    public static RetrofitRepository getInstance()
    {
        if (retrofitRepository== null)
        {
            retrofitRepository=new RetrofitRepository();
        }
        return retrofitRepository;
    }

    public RetrofitRepository()
    {
        retrofit=SchoolApiService.create("http://192.168.10.85:8081/SchoolServer_war_exploded/").getRetrofit();
        schoolApi=retrofit.create(SchoolApi.class);
    }

    public void insertClass(final Classes classes)
    {
        Map<String , String> stringMap=new HashMap<>();
        stringMap.put("ClassName",classes.getClass_name());
        schoolApi.classNameRegister(stringMap).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println(response.body());
                getAllClass();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
    public MutableLiveData<List<Classes>> getAllClass()
    {
        schoolApi.classNameShow().enqueue(new Callback<List<Classes>>() {
            @Override
            public void onResponse(Call<List<Classes>> call, Response<List<Classes>> response) {
               List<Classes> classesList=new ArrayList<>();
                for (int i = 0; i < response.body().size(); i++) {
                    Classes classes=new Classes();
                    String class_name=response.body().get(i).getClass_name();
                    classes.setClass_name(class_name);
                    classesList.add(classes);
                }
                allClass.postValue(classesList);
            }

            @Override
            public void onFailure(Call<List<Classes>> call, Throwable t) {
                 allClass.postValue(null);
            }
        });
        return allClass;
    }
}
