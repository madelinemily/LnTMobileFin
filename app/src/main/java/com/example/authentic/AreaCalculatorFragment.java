package com.example.authentic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AreaCalculatorFragment extends Fragment {

    private EditText editTextWidth;
    private EditText editTextHeight;
    private TextView textViewResult;
    private Button buttonCalculate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_area_calculator, container, false);

        // Initialize views
        editTextWidth = view.findViewById(R.id.edit_text_width);
        editTextHeight = view.findViewById(R.id.edit_text_height);
        textViewResult = view.findViewById(R.id.text_view_result);
        buttonCalculate = view.findViewById(R.id.button_calculate);

        // Set click listener for the calculate button
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateArea();
            }
        });

        return view;
    }

    private void calculateArea() {
        // Get the width and height input
        String widthStr = editTextWidth.getText().toString();
        String heightStr = editTextHeight.getText().toString();

        // Check if input is empty
        if (widthStr.isEmpty() || heightStr.isEmpty()) {
            textViewResult.setText(getString(R.string.error_empty_fields));
            return;
        }

        // Parse input to double
        double width = Double.parseDouble(widthStr);
        double height = Double.parseDouble(heightStr);

        // Calculate area for square, triangle, and circle
        double squareArea = width * width;
        double triangleArea = 0.5 * width * height;
        double circleArea = Math.PI * Math.pow(width / 2, 2);

        // Prepare result string
        String result = getString(R.string.result_square, squareArea)
                + "\n" + getString(R.string.result_triangle, triangleArea)
                + "\n" + getString(R.string.result_circle, circleArea);

        // Display result
        textViewResult.setText(result);
    }
}
