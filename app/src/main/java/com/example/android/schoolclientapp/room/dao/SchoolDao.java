package com.example.android.schoolclientapp.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.android.schoolclientapp.room.model.Classes;
import com.example.android.schoolclientapp.room.model.Lessons;
import com.example.android.schoolclientapp.room.model.Students;

import java.util.List;

@Dao
public interface SchoolDao
{
    @Insert
    void insertClass(Classes class_name);

    @Insert
    void insertLesson(Lessons lessons);

    @Insert
    void insertStudent(Students students);

    @Query("Select * from Classes")
    LiveData<List<Classes>> selectClass();

    @Query("Select * from Lessons")
    LiveData<List<Lessons>> selectLessons();

    @Query("Select * from Students")
    LiveData<List<Students>> selectStudents();

}
