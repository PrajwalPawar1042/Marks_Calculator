package com.example.marks_calculator3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class birthdayFragment extends Fragment {

    private DatePicker datePicker;
    private Button calculateButton;
    private TextView ageResultText;
    private TextView daysToBirthdayText;
    private TextView currentAgeText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_birthday, container, false);

        datePicker = view.findViewById(R.id.datePicker);
        calculateButton = view.findViewById(R.id.calculateButton);
        ageResultText = view.findViewById(R.id.ageResultText);
        daysToBirthdayText = view.findViewById(R.id.days_to_birthday_text);
        currentAgeText = view.findViewById(R.id.current_age_text);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAgeAndBirthday();
            }
        });

        return view;
    }

    private void calculateAgeAndBirthday() {
        // Get the selected date from the DatePicker
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        // Create a Calendar instance for the current date
        Calendar currentDate = Calendar.getInstance();

        // Set the selected date to the Calendar instance
        Calendar selectedDate = Calendar.getInstance();
        selectedDate.set(year, month, day);

        // Calculate the age in years
        int ageInYears = currentDate.get(Calendar.YEAR) - selectedDate.get(Calendar.YEAR);

        // Calculate the days to the next birthday
        Calendar nextBirthday = Calendar.getInstance();
        nextBirthday.set(currentDate.get(Calendar.YEAR), month, day);

        if (nextBirthday.before(currentDate)) {
            nextBirthday.add(Calendar.YEAR, 1); // Set the next birthday to the next year
        }

        int daysToBirthday = (int) ((nextBirthday.getTimeInMillis() - currentDate.getTimeInMillis()) / (24 * 60 * 60 * 1000));

        // Format the dates for display
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        String currentAge = getString(R.string.current_age_format, ageInYears, dateFormat.format(currentDate.getTime()));
        String nextBirthdayText = getString(R.string.days_to_birthday_format, daysToBirthday, dateFormat.format(nextBirthday.getTime()));

        // Update the text views with the calculated values
        ageResultText.setText(getString(R.string.age_result_format, ageInYears));
        daysToBirthdayText.setText(nextBirthdayText);
        currentAgeText.setText(currentAge);
    }
}
