package com.example.authentic;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CounterFragment extends Fragment {

    private TextView textCounter;
    private int counterValue;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "counter_pref";
    private static final String COUNTER_KEY = "counter";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = requireActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        // Ambil nilai counter dari SharedPreferences saat pembuatan fragment
        counterValue = sharedPreferences.getInt(COUNTER_KEY, 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counter, container, false);
        textCounter = view.findViewById(R.id.text_counter);

        // Menambahkan event listener ke tombol-tombol
        Button buttonIncrement = view.findViewById(R.id.button_increment);
        Button buttonDecrement = view.findViewById(R.id.button_decrement);
        Button buttonReset = view.findViewById(R.id.button_reset);

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment(v);
            }
        });

        buttonDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrement(v);
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset(v);
            }
        });

        // Set nilai counter pada TextView saat pembuatan tampilan
        textCounter.setText(String.valueOf(counterValue));

        return view;
    }

    public void increment(View view) {
        // Tambahkan nilai counter
        counterValue++;
        // Update tampilan dan simpan nilai counter yang diperbarui
        updateCounterText();
    }

    public void decrement(View view) {
        // Kurangi nilai counter
        counterValue--;
        // Update tampilan dan simpan nilai counter yang diperbarui
        updateCounterText();
    }

    public void reset(View view) {
        // Reset nilai counter
        counterValue = 0;
        // Update tampilan dan simpan nilai counter yang diperbarui
        updateCounterText();
    }

    private void updateCounterText() {
        // Set nilai counter pada TextView
        textCounter.setText(String.valueOf(counterValue));
        // Simpan nilai counter yang diperbarui ke dalam SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COUNTER_KEY, counterValue);
        editor.apply();
    }
}
