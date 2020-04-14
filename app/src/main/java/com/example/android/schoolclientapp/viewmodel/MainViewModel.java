package com.example.android.schoolclientapp.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.android.schoolclientapp.room.model.Classes;
import com.example.android.schoolclientapp.room.model.Lessons;
import com.example.android.schoolclientapp.room.model.Students;
import com.example.android.schoolclientapp.room.repository.SchoolRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel
{
   SchoolRepository schoolRepository;
    LiveData<List<Classes>> allClass;
    LiveData<List<Lessons>> allLessons;
    LiveData<List<Students>> allStudent;

    public MainViewModel(@NonNull Application application) {
        super(application);
        schoolRepository=new SchoolRepository(getApplication());
        allClass=schoolRepository.getAllClass();
        allLessons=schoolRepository.getAllLessons();
        allStudent=schoolRepository.getAllStudent();
    }


    public void insertClass(final Classes classes)
    {
        schoolRepository.insertClass(classes);
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

    public LiveData<List<Lessons>> getAllLessons(){
        return allLessons;
    }

    public LiveData<List<Students>> getAllStudent(){
        return allStudent;
    }
}
