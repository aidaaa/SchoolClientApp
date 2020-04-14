package com.example.android.schoolclientapp.room.repository;

//C:\Users\MAJID-PC\AndroidStudioProjects\DataBinding\app\src\main\java\com\example\android\databinding\old

import android.content.Context;
import android.os.AsyncTask;
import android.util.AndroidException;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.example.android.schoolclientapp.room.dao.SchoolDao;
import com.example.android.schoolclientapp.room.db.SchoolDataBase;
import com.example.android.schoolclientapp.room.model.Classes;
import com.example.android.schoolclientapp.room.model.Lessons;
import com.example.android.schoolclientapp.room.model.Students;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class SchoolRepository
{

    private SchoolDao dao;
    private LiveData<List<Classes>> allClass;
    private LiveData<List<Lessons>> allLessons;
    private LiveData<List<Students>> allStudent;

    public SchoolRepository(Context context) {
        SchoolDataBase db= SchoolDataBase.getInstance(context);
        dao=db.schoolDao();
        allClass=dao.selectClass();
        allLessons=dao.selectLessons();
        allStudent=dao.selectStudents();
    }

    public void insertClass(final Classes classes)
    {
        //new InsertClassesAsynTask(dao).execute(classes);
       new SchoolActions().executeWithObservable(dao,classes);
    }

    public void insertLessons(final Lessons lessons)
    {
    }

    public void insertStudents(final Students students)
    {
    }

    public LiveData<List<Classes>> getAllClass() {
        return allClass;
    }

    public LiveData<List<Lessons>> getAllLessons()
    {
        return allLessons;
    }

    public LiveData<List<Students>> getAllStudent()
    {
        return allStudent;
    }

    public static class SchoolActions
    {
        public void executeWithObservable(final SchoolDao dao, final Classes classes){
            Observable.create(new ObservableOnSubscribe<Object>() {
                @Override
                public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                    dao.insertClass(classes);
                }
            }).observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<Object>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            // dao.insertClass(classes);
                        }

                        @Override
                        public void onNext(Object o) {
                            //  dao.insertClass(classes);
                        }

                        @Override
                        public void onError(Throwable e) {
                            System.out.println("error");
                        }

                        @Override
                        public void onComplete() {
                            //dao.insertClass(classes);
                        }
                    });
        }

        private void executeWithCompletable(final SchoolDao dao, final Classes classes){
          Completable.fromAction(new Action() {
                @Override
                public void run() throws Exception {
                    dao.insertClass(classes);
                }
            }).observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new CompletableObserver() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onComplete() {
                            //dao.insertClass(classes);
                        }

                        @Override
                        public void onError(Throwable e) {
                            System.out.println("error");
                        }
                    });
        }

    }

    public class InsertClassesAsynTask extends AsyncTask<Classes,Void,Void>
    {
        SchoolDao dao;

        public InsertClassesAsynTask( SchoolDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Classes... classes) {
           dao.insertClass(classes[0]);
            return null;
        }
    }
}
