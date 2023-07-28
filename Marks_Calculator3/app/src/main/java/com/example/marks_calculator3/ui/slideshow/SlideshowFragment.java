package com.example.marks_calculator3.ui.slideshow;

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

public class SlideshowFragment extends Fragment {

    private EditText cgpaEditText;
    private Button calculateButton;
    private TextView resultTextView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        cgpaEditText = root.findViewById(R.id.edit_cgpa);
        calculateButton = root.findViewById(R.id.calculateButton);
        resultTextView = root.findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePercentage();
            }
        });

        return root;
    }

    private void calculatePercentage() {
        String cgpaStr = cgpaEditText.getText().toString();

        if (cgpaStr.isEmpty()) {
            // Handle empty input field
            return;
        }


        double cgpa = Double.parseDouble(cgpaStr);
        double percentage = cgpa * 9.5;

        // Display the result in the resultTextView
        resultTextView.setText("Percentage: " + String.format("%.2f", percentage) + "%");
        String toastMessage = "Average Percentage: " + percentage + "%";
        Toast.makeText(getContext(), toastMessage, Toast.LENGTH_SHORT).show();

    }
}
