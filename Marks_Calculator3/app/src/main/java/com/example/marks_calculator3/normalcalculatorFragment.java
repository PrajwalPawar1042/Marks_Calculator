package com.example.marks_calculator3;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class normalcalculatorFragment extends Fragment implements View.OnClickListener {

    private TextView resultTv, solutionTv;
    private MaterialButton buttonC, buttonBrackOpen, buttonBrackClose;
    private MaterialButton buttonDivide, buttonMultiply, buttonPlus, buttonMinus, buttonEquals;
    private MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private MaterialButton buttonAC, buttonDot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_normalcalculator, container, false);

        // Initialize the views
        resultTv = view.findViewById(R.id.result_tv);
        solutionTv = view.findViewById(R.id.solution_tv);

        // Assign click listeners to buttons
        buttonC = view.findViewById(R.id.button_c);
        buttonBrackOpen = view.findViewById(R.id.button_open_bracket);
        buttonBrackClose = view.findViewById(R.id.button_close_bracket);
        buttonDivide = view.findViewById(R.id.button_divide);
        buttonMultiply = view.findViewById(R.id.button_multiply);
        buttonPlus = view.findViewById(R.id.button_plus);
        buttonMinus = view.findViewById(R.id.button_minus);
        buttonEquals = view.findViewById(R.id.button_equals);
        button0 = view.findViewById(R.id.button_0);
        button1 = view.findViewById(R.id.button_1);
        button2 = view.findViewById(R.id.button_2);
        button3 = view.findViewById(R.id.button_3);
        button4 = view.findViewById(R.id.button_4);
        button5 = view.findViewById(R.id.button_5);
        button6 = view.findViewById(R.id.button_6);
        button7 = view.findViewById(R.id.button_7);
        button8 = view.findViewById(R.id.button_8);
        button9 = view.findViewById(R.id.button_9);
        buttonAC = view.findViewById(R.id.button_ac);
        buttonDot = view.findViewById(R.id.button_dot);

        buttonC.setOnClickListener(this);
        buttonBrackOpen.setOnClickListener(this);
        buttonBrackClose.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonAC.setOnClickListener(this);
        buttonDot.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solutionTv.getText().toString();

        if (buttonText.equals("AC")) {
            solutionTv.setText("");
            resultTv.setText("0");
            return;
        }
        if (buttonText.equals("=")) {
            solutionTv.setText(resultTv.getText());
            return;
        }
        if (buttonText.equals("C")) {
            dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
        } else {
            dataToCalculate = dataToCalculate + buttonText;
        }
        solutionTv.setText(dataToCalculate);

        String finalResult = getResult(dataToCalculate);

        if (!finalResult.equals("Err")) {
            resultTv.setText(finalResult);
        }
    }

    private String getResult(String data) {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            if (finalResult.endsWith(".0")) {
                finalResult = finalResult.replace(".0", "");
            }
            return finalResult;
        } catch (Exception e) {
            return "Err";
        }
    }
}
