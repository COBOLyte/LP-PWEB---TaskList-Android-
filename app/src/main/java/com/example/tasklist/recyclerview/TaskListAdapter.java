package com.example.tasklist.recyclerview;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasklist.R;
import com.example.tasklist.classes.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TaskListAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private final ArrayList<Task> taskList;

    public TaskListAdapter(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.task_item;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Nom
        String taskTitle = this.taskList.get(position).getTitle();
        holder.getTaskTitle().setText(taskTitle);

        // Date de création
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd MMM yyyy");
        String taskCreationDate = dateFormat1.format(this.taskList.get(position).getCreationDate());
        holder.getTaskCreateDate().setText(taskCreationDate);

        // Date de fin
        Date taskEndDate = this.taskList.get(position).getEndDate();
        String taskEndDateStr = dateFormat1.format(taskEndDate);
        holder.getTaskEndDate().setText(taskEndDateStr);

        // Durée avant la date de fin
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd MM yyyy");
        long daysBetween = 0;
        try {
            Date dateBefore = dateFormat2.parse(dateFormat2.format(new Date()));
            Date dateAfter = dateFormat2.parse(dateFormat2.format(taskEndDate));
            assert dateBefore != null;
            assert dateAfter != null;
            long difference = dateAfter.getTime() - dateBefore.getTime();
            daysBetween = difference/(1000*60*60*24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.getTaskLength().setText(String.valueOf(daysBetween));

        // Bouton de suppression
        holder.getDeleteTaskButton().setOnClickListener(view1 -> {
            this.taskList.remove(position);
            this.notifyItemRemoved(position);
            this.notifyItemRangeChanged(0, this.taskList.size());
            this.notifyDataSetChanged();

            Toast.makeText(view1.getContext(), R.string.taskDeletedToastMsg, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return this.taskList.size();
    }
}
