package com.example.android.schoolclientapp;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment implements View.OnClickListener {

    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController= Navigation.findNavController(view);
        view.findViewById(R.id.insert_class).setOnClickListener(this);
        view.findViewById(R.id.insert_disciplinary).setOnClickListener(this);
        view.findViewById(R.id.insert_lesson).setOnClickListener(this);
        view.findViewById(R.id.insert_Student).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.insert_class:
                navController.navigate(R.id.action_mainFragment_to_insertClassFragment);
                break;
            case R.id.insert_lesson:
                navController.navigate(R.id.action_mainFragment_to_insertLessonFragment);
                break;
            case R.id.insert_Student:
                navController.navigate(R.id.action_mainFragment_to_insertStudentFragment);
                break;
            case R.id.insert_disciplinary:
                navController.navigate(R.id.action_mainFragment_to_insertDisciplinaryFragment);
                break;
        }
    }
}
