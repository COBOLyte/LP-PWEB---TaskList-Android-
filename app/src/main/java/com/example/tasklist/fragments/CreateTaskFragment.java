package com.example.tasklist.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tasklist.R;
import com.example.tasklist.classes.Task;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateTaskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateTaskFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreateTaskFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateTaskFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateTaskFragment newInstance(String param1, String param2) {
        CreateTaskFragment fragment = new CreateTaskFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_task, container, false);
        Button saveTaskButton = view.findViewById(R.id.btnAddTask);
        EditText newTaskTitle = view.findViewById(R.id.newTaskTitle);
        DatePicker newTaskEndDate = view.findViewById(R.id.newTaskEndDate);
        saveTaskButton.setOnClickListener(view1 -> {
            if (TextUtils.isEmpty(newTaskTitle.getText().toString())) Toast.makeText(view.getContext(), R.string.emptyNewTaskTitleAddedToastMsg, Toast.LENGTH_LONG).show();
            else {
                TasksFragment.addTask((new Task(newTaskTitle.getText().toString(), new Date(
                        newTaskEndDate.getYear() - 1900,
                        newTaskEndDate.getMonth(),
                        newTaskEndDate.getDayOfMonth()
                ))));

                newTaskTitle.setText("");
                Toast.makeText(view.getContext(), R.string.newTaskAddedToastMsg, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
