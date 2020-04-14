package com.example.android.schoolclientapp.cases.insert;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.schoolclientapp.R;
import com.example.android.schoolclientapp.adapter.InsertClassFragmentAdapter;
import com.example.android.schoolclientapp.room.model.Classes;
import com.example.android.schoolclientapp.viewmodel.MainViewModel;

import org.w3c.dom.Text;

import java.util.List;

public class InsertClassFragment extends Fragment implements View.OnClickListener {

    NavController navController;
    RecyclerView fragment_insert_class_rv;
    EditText fragment_insert_class_edt;
    String className;
    MainViewModel mainViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insert_class, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController= Navigation.findNavController(view);
        mainViewModel= ViewModelProviders.of(this).get(MainViewModel.class);

        fragment_insert_class_rv=view.findViewById(R.id.fragment_insert_class_rv);
        fragment_insert_class_edt=view.findViewById(R.id.fragment_insert_class_edt);
        view.findViewById(R.id.fragment_insert_class_btn).setOnClickListener(this);


        fragment_insert_class_rv.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(),RecyclerView.VERTICAL,false));
        final InsertClassFragmentAdapter adapter=new InsertClassFragmentAdapter();
        fragment_insert_class_rv.setAdapter(adapter);

        mainViewModel.getAllClass().observe(getViewLifecycleOwner(), new Observer<List<Classes>>() {
            @Override
            public void onChanged(List<Classes> classes) {
                adapter.setClassesList(classes);
            }
        });
    }


    @Override
    public void onClick(View v)
    {
       switch (v.getId())
       {
           case R.id.fragment_insert_class_btn:
               className=fragment_insert_class_edt.getText().toString();
               if (!TextUtils.isEmpty(className))
               {
                   Classes classes=new Classes(className);
                   mainViewModel.insertClass(classes);
               }
               break;
       }
    }
}
