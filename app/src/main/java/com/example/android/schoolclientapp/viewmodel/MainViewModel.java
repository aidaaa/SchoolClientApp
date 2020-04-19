package com.example.android.schoolclientapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.android.schoolclientapp.model.model.Classes;
import com.example.android.schoolclientapp.model.model.Lessons;
import com.example.android.schoolclientapp.model.model.Students;
import com.example.android.schoolclientapp.model.retrofit.RetrofitRepository;
import com.example.android.schoolclientapp.model.room.repository.SchoolRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel
{
   SchoolRepository schoolRepository;
    LiveData<List<Classes>> allClass;
    LiveData<List<Lessons>> allLessons;
    LiveData<List<Students>> allStudent;

   private MutableLiveData<List<Classes>> mutableLiveData;

    RetrofitRepository retrofitRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        schoolRepository=new SchoolRepository(getApplication());
       // retrofitRepository=new RetrofitRepository();

        allClass=schoolRepository.getAllClass();
        allLessons=schoolRepository.getAllLessons();
        allStudent=schoolRepository.getAllStudent();
    }


    public void init(){
        if (mutableLiveData != null){
            return;
        }
        retrofitRepository = RetrofitRepository.getInstance();
        mutableLiveData = retrofitRepository.getAllClass();
    }

    public void insertClass(final Classes classes)
    {
        schoolRepository.insertClass(classes);
    }

    public void insertClassRetrofit(final Classes classes)
    {
        retrofitRepository.insertClass(classes);
    }

    public void insertLessons(final Lessons lessons)
    {
       schoolRepository.insertLessons(lessons);
    }

    public void insertStudents(final Students students)
    {
        schoolRepository.insertStudents(students);
    }

    public LiveData<List<Classes>> getAllClass(){
        return allClass;
    }

    public LiveData<List<Classes>> getAllClassRetrofit(){
        return mutableLiveData;
    }

    public LiveData<List<Lessons>> getAllLessons(){
        return allLessons;
    }

    public LiveData<List<Students>> getAllStudent(){
        return allStudent;
    }
}
