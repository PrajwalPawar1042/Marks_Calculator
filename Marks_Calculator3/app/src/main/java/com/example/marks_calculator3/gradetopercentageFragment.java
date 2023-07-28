package com.example.marks_calculator3;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class gradetopercentageFragment extends Fragment {

    private EditText editTextSubject1;
    private EditText editTextSubject2;
    private EditText editTextSubject3;
    private TextView textViewResult;
    private Button calculateButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gradetopercentage, container, false);

        // Initialize the views
        editTextSubject1 = view.findViewById(R.id.editTextSubject1);
        editTextSubject2 = view.findViewById(R.id.editTextSubject2);
        editTextSubject3 = view.findViewById(R.id.editTextSubject3);
        textViewResult = view.findViewById(R.id.textViewResult);
        calculateButton =  view.findViewById(R.id.calculateButton);

        // Set click listener for the calculate button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePercentage();
            }
        });

        return view;
    }

    private void calculatePercentage() {
        // Get grades entered by the user
        String grade1 = editTextSubject1.getText().toString();
        String grade2 = editTextSubject2.getText().toString();
        String grade3 = editTextSubject3.getText().toString();

        // Calculate the percentage based on the grades (Add your calculation logic here)
        // You can use if-else statements or a switch case to map the grades to percentages
        // For simplicity, let's assume each grade represents 10% (e.g., A = 90%, B = 80%, etc.)
        int percentage1 = getPercentageFromGrade(grade1);
        int percentage2 = getPercentageFromGrade(grade2);
        int percentage3 = getPercentageFromGrade(grade3);

        // Calculate the average percentage
        int averagePercentage = (percentage1 + percentage2 + percentage3) / 3;

        // Display the result
        textViewResult.setText("Average Percentage: " + averagePercentage + "%");

        // Display the result in a toast message
        String toastMessage = "Average Percentage: " + averagePercentage + "%";
        Toast.makeText(getContext(), toastMessage, Toast.LENGTH_SHORT).show();
    }

    private int getPercentageFromGrade(String grade) {
        // Add your logic here to convert grades to percentages
        // Return the corresponding percentage based on the grade received
        // Example logic: A = 90-100, B = 80-89, C = 70-79, etc.
        // Adjust the percentage ranges based on your grading system

        int percentage;
        switch (grade) {
            case "A":
                percentage = 95;
                break;
            case "B":
                percentage = 85;
                break;
            case "C":
                percentage = 75;
                break;
            // Add more cases for other grades if needed
            default:
                percentage = 0; // Return 0 if the grade is not recognized
        }
        return percentage;
    }
}

