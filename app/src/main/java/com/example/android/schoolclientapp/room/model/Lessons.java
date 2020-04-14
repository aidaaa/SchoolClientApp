package com.example.android.schoolclientapp.room.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Lessons")
public class Lessons
{
    @ColumnInfo(name = "lessons")
    @PrimaryKey
    @NonNull
    private String lessons;

    public Lessons(String lessons) {
        this.lessons = lessons;
    }

    public String getLessons() {
        return lessons;
    }

    public void setLessons(String lessons) {
        this.lessons = lessons;
    }
}
