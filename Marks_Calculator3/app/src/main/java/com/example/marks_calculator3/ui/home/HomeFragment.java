package com.example.marks_calculator3.ui.home;

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

public class HomeFragment extends Fragment {

    private EditText obtainedMarksEditText;
    private EditText totalMarksEditText;
    private Button calculateButton;
    private TextView resultTextView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        obtainedMarksEditText = root.findViewById(R.id.edit_obtained_marks);
        totalMarksEditText = root.findViewById(R.id.edit_total_marks);
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
        String obtainedMarksStr = obtainedMarksEditText.getText().toString();
        String totalMarksStr = totalMarksEditText.getText().toString();

        if (obtainedMarksStr.isEmpty() || totalMarksStr.isEmpty()) {
            // Handle empty input fields
            return;
        }

        double obtainedMarks = Double.parseDouble(obtainedMarksStr);
        double totalMarks = Double.parseDouble(totalMarksStr);
        double percentage = (obtainedMarks / totalMarks) * 100;

        // Display the result in the resultTextView
        resultTextView.setText("Percentage: " + String.format("%.2f", percentage) + "%");
        // Display the result in a toast message
        String toastMessage = "Average Percentage: " +percentage + "%";
        Toast.makeText(getContext(), toastMessage, Toast.LENGTH_SHORT).show();
    }
}
