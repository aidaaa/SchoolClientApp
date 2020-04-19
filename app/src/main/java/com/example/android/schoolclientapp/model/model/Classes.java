package com.example.android.schoolclientapp.model.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Classes")
public class Classes
{
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "class_name")

    private String class_name;

    public Classes(String class_name) {
    this.class_name = class_name;
}
    public Classes() {
    }
    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
