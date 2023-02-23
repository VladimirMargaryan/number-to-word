package com.example.numbertoword;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Range;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String ERROR_MESSAGE = "Input must be a number between 0 and 999 999 999";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText numberInput = findViewById(R.id.text_input);
        final Button convertButton = findViewById(R.id.button_convert);
        final TextView messageView = findViewById(R.id.message_textview);

        convertButton.setOnClickListener(view -> {
            final String input = numberInput.getText().toString();
            if (input.isEmpty()
                    || input.length() > 9
                    || !Range.create(0, 999_999_999).contains(Integer.parseInt(input))) {
                messageView.setText(ERROR_MESSAGE);
                messageView.setTextColor(Color.RED);
                messageView.setTypeface(null, Typeface.NORMAL);
            } else {
                messageView.setText(NumberToWordConverter.convert(Integer.parseInt(input)));
                messageView.setTextColor(Color.BLACK);
                messageView.setTypeface(null, Typeface.BOLD);
            }
        });
    }
}