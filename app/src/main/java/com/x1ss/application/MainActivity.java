package com.x1ss.application;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b1;

    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button);
        spinner = findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);

        b1.setOnClickListener(v -> spinner.setVisibility(View.VISIBLE));
    }
}
