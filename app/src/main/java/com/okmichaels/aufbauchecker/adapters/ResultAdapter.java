package com.okmichaels.aufbauchecker.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.okmichaels.aufbauchecker.R;
import com.okmichaels.aufbauchecker.model.Grade;

import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder> {

    private ArrayList<Grade> grades;
    private Context context;

    public ResultAdapter(ArrayList<Grade> grd, Context ctx) {
        this.grades = grd; this.context = ctx;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grade_row, parent, false);
        return new ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Grade grd = grades.get(position);
        holder.bindGrade(grd);
    }

    public int getItemCount() {
        return grades.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView subject, grade;

        public ViewHolder(View itemView) {
            super(itemView);

            subject = itemView.findViewById(R.id.tv_subject);
            grade = itemView.findViewById(R.id.tv_grade);
        }

        public void bindGrade(Grade grd) {
            this.subject.setText(grd.getSubject());
            this.grade.setText(grd.getScore());
        }
    }
}
