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

public class VolumeCalculatorFragment extends Fragment {

    private EditText editTextLength;
    private EditText editTextWidth;
    private EditText editTextHeight;
    private TextView textViewResult;
    private Button buttonCalculate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_volume_calculator, container, false);

        // Initialize views
        editTextLength = view.findViewById(R.id.edit_text_length);
        editTextWidth = view.findViewById(R.id.edit_text_width);
        editTextHeight = view.findViewById(R.id.edit_text_height);
        textViewResult = view.findViewById(R.id.text_view_result);
        buttonCalculate = view.findViewById(R.id.button_calculate);

        // Set click listener for the calculate button
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateVolume();
            }
        });

        return view;
    }

    private void calculateVolume() {
        // Get the length, width, and height input
        String lengthStr = editTextLength.getText().toString();
        String widthStr = editTextWidth.getText().toString();
        String heightStr = editTextHeight.getText().toString();

        // Check if input is empty
        if (lengthStr.isEmpty() || widthStr.isEmpty() || heightStr.isEmpty()) {
            textViewResult.setText(getString(R.string.error_empty_fields));
            return;
        }

        // Parse input to double
        double length = Double.parseDouble(lengthStr);
        double width = Double.parseDouble(widthStr);
        double height = Double.parseDouble(heightStr);

        // Calculate volume for cuboid, pyramid, and cylinder
        double cuboidVolume = length * width * height;
        double pyramidVolume = (length * width * height) / 3;
        double cylinderVolume = Math.PI * Math.pow(width / 2, 2) * height;

        // Prepare result string
        String result = getString(R.string.result_cuboid, cuboidVolume)
                + "\n" + getString(R.string.result_pyramid, pyramidVolume)
                + "\n" + getString(R.string.result_cylinder, cylinderVolume);

        // Display result
        textViewResult.setText(result);
    }
}
