package com.example.marks_calculator3.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.marks_calculator3.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private EditText subjectNameEditText;
    private EditText subjectWeightEditText;
    private EditText subjectMarksEditText;
    private Button addButton;
    private Button calculateButton;
    private TextView resultTextView;

    private List<Subject> subjectsList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        subjectNameEditText = root.findViewById(R.id.edit_subject_name);
        subjectWeightEditText = root.findViewById(R.id.edit_subject_weight);
        subjectMarksEditText = root.findViewById(R.id.edit_subject_marks);
        addButton = root.findViewById(R.id.addButton);
        calculateButton = root.findViewById(R.id.calculateButton);
        resultTextView = root.findViewById(R.id.resultTextView);

        subjectsList = new ArrayList<>();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSubject();
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateWeightedAverage();
            }
        });

        return root;
    }

    private void addSubject() {
        String subjectName = subjectNameEditText.getText().toString();
        String subjectWeightStr = subjectWeightEditText.getText().toString();
        String subjectMarksStr = subjectMarksEditText.getText().toString();

        if (subjectName.isEmpty() || subjectWeightStr.isEmpty() || subjectMarksStr.isEmpty()) {
            // Handle empty input fields
            return;
        }

        double subjectWeight = Double.parseDouble(subjectWeightStr);
        double subjectMarks = Double.parseDouble(subjectMarksStr);

        Subject subject = new Subject(subjectName, subjectWeight, subjectMarks);
        subjectsList.add(subject);

        // Clear the input fields after adding the subject
        subjectNameEditText.getText().clear();
        subjectWeightEditText.getText().clear();
        subjectMarksEditText.getText().clear();
    }

    private void calculateWeightedAverage() {
        if (subjectsList.isEmpty()) {
            // Handle case when no subjects are added
            resultTextView.setText("No subjects added");
            return;
        }

        double totalWeightedMarks = 0;
        double totalWeight = 0;

        for (Subject subject : subjectsList) {
            double weight = subject.getWeight();
            double marks = subject.getMarks();

            totalWeightedMarks += weight * marks;
            totalWeight += weight;
        }

        double weightedAverage = totalWeightedMarks / totalWeight;

        // Display the result in the resultTextView
        resultTextView.setText("Weighted Average: " + weightedAverage);
        // Display the result in a toast message
        String toastMessage = "Average Percentage: " + weightedAverage + "%";
        Toast.makeText(getContext(), toastMessage, Toast.LENGTH_SHORT).show();
    }

    private static class Subject {
        private String name;
        private double weight;
        private double marks;

        public Subject(String name, double weight, double marks) {
            this.name = name;
            this.weight = weight;
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public double getWeight() {
            return weight;
        }

        public double getMarks() {
            return marks;
        }
    }
}
