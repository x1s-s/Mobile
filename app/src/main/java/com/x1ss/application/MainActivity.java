package com.x1ss.application;

import android.app.ActionBar;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageSwitcher sw;
    private Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);

        sw = findViewById(R.id.imageSwitcher);
        sw.setFactory(() -> {
            ImageView myView = new ImageView(getApplicationContext());
            myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            myView.setLayoutParams(new
                    ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
                    ActionBar.LayoutParams.WRAP_CONTENT));
            return myView;
        });

        b1.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "previous Image",
                    Toast.LENGTH_LONG).show();
            sw.setImageResource(R.drawable.images);
        });

        b2.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Next Image",
                    Toast.LENGTH_LONG).show();
            sw.setImageResource(R.drawable.image);
        });
    }
}
