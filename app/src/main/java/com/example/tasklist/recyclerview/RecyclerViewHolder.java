package com.example.tasklist.recyclerview;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasklist.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private final TextView taskTitle;
    private final TextView taskCreateDate;
    private final TextView taskEndDate;
    private final TextView taskLength;
    private final Button deleteTaskButton;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        this.taskTitle = itemView.findViewById(R.id.taskTitle);
        this.taskCreateDate = itemView.findViewById(R.id.creationDate);
        this.taskEndDate = itemView.findViewById(R.id.endDate);
        this.taskLength = itemView.findViewById(R.id.taskLength);
        this.deleteTaskButton = itemView.findViewById(R.id.deleteTaskButton);
    }

    public TextView getTaskTitle() {
        return this.taskTitle;
    }

    public TextView getTaskCreateDate() {
        return taskCreateDate;
    }

    public TextView getTaskEndDate() {
        return taskEndDate;
    }

    public TextView getTaskLength() {
        return taskLength;
    }

    public Button getDeleteTaskButton() {
        return this.deleteTaskButton;
    }
}
