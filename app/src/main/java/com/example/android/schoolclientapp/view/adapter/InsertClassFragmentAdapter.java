package com.example.android.schoolclientapp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.schoolclientapp.R;
import com.example.android.schoolclientapp.model.model.Classes;

import java.util.ArrayList;
import java.util.List;

public class InsertClassFragmentAdapter extends RecyclerView.Adapter<InsertClassFragmentAdapter.InsertClassFragmentViewHolder>
{

    List<Classes> classesList=new ArrayList<>();

    @NonNull
    @Override
    public InsertClassFragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_insert_class_rv_items,parent,false);
        return new InsertClassFragmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InsertClassFragmentViewHolder holder, int position) {
        Classes classes=classesList.get(position);
        holder.onBind(classes);
    }

    @Override
    public int getItemCount() {
        return classesList.size();
    }

    public void setClassesList(List<Classes> classesList)
    {
        this.classesList=classesList;
        notifyDataSetChanged();
    }

    public class InsertClassFragmentViewHolder extends RecyclerView.ViewHolder
    {
        TextView fragment_insert_class_rv_items_txt;
        public InsertClassFragmentViewHolder(@NonNull View itemView) {
            super(itemView);
            fragment_insert_class_rv_items_txt=itemView.findViewById(R.id.fragment_insert_class_rv_items_txt);
        }

        public void onBind(Classes classes )
        {
            fragment_insert_class_rv_items_txt.setText(classes.getClass_name());
        }
    }
}
