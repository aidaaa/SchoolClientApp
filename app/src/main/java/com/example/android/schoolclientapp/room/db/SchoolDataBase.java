package com.example.android.schoolclientapp.room.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.android.schoolclientapp.room.dao.SchoolDao;
import com.example.android.schoolclientapp.room.model.Classes;
import com.example.android.schoolclientapp.room.model.Lessons;
import com.example.android.schoolclientapp.room.model.Students;

@Database(entities = {Classes.class, Lessons.class, Students.class} , version = 1)
public abstract class SchoolDataBase extends RoomDatabase
{
    private static SchoolDataBase instance;

    public abstract SchoolDao schoolDao();

    public static synchronized SchoolDataBase getInstance(Context context)
    {
        if (instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext()
            ,SchoolDataBase.class,"School_database")
                    .addCallback(rooCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback rooCallback=new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsynTask(instance).execute();
        }
    };

    private static class PopulateDbAsynTask extends AsyncTask<Void, Void, Void>
    {

        private SchoolDao schoolDao;

        public PopulateDbAsynTask(SchoolDataBase schoolDataBase) {
           schoolDao=schoolDataBase.schoolDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            schoolDao.insertClass(new Classes("1"));
            schoolDao.insertLesson(new Lessons("zaban"));
            schoolDao.insertStudent(new Students("aida","mosayebi","1"));
            return null;
        }
    }
}
