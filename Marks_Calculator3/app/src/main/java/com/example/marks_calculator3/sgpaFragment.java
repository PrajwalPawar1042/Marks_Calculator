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

public class sgpaFragment extends Fragment {

    private EditText sgpaEditText;
    private Button calculateButton;
    private TextView percentageTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sgpa, container, false);

        sgpaEditText = view.findViewById(R.id.sgpaEditText);
        calculateButton = view.findViewById(R.id.calculateButton);
        percentageTextView = view.findViewById(R.id.percentageTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePercentage();
            }
        });

        return view;
    }


    private void calculatePercentage() {
        String sgpaText = sgpaEditText.getText().toString().trim();
        if (!sgpaText.isEmpty()) {
            double sgpa = Double.parseDouble(sgpaText);
            double percentage = (sgpa * 10) - 7.5;
            percentageTextView.setText(String.format("%.2f", percentage) + "%");
            String toastMessage = "Average Percentage: " + percentage + "%";
            Toast.makeText(getContext(), toastMessage, Toast.LENGTH_SHORT).show();
        } else {
            percentageTextView.setText("Please enter SGPA.");

        }
    }
}
