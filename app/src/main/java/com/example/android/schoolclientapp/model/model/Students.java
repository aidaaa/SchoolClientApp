package com.example.android.schoolclientapp.model.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Students",foreignKeys =@ForeignKey(entity = Classes.class,
                                                        parentColumns = "class_name",
                                                        childColumns = "class_name_student",
                                                        onDelete = ForeignKey.CASCADE))
public class Students
{
    @ColumnInfo(name = "name")
    @PrimaryKey
    @NonNull
    private String name;

    @ColumnInfo(name = "family")
    private String family;

    @ColumnInfo(name = "class_name_student")
    private String class_name;

    public Students(String name, String family, String class_name) {
        this.name = name;
        this.family = family;
        this.class_name = class_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
