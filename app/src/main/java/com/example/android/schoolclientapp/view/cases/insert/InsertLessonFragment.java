package com.example.android.schoolclientapp.view.cases.insert;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.schoolclientapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InsertLessonFragment extends Fragment {


    public InsertLessonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insert_lesson, container, false);
    }

}
