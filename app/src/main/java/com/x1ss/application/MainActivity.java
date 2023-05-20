package com.x1ss.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    TextView tv;
    EditText ed1;

    String data;
    private final String file = "mydata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);

        ed1 = findViewById(R.id.editText);
        tv = findViewById(R.id.textView2);
        b1.setOnClickListener(v -> {
            data = ed1.getText().toString();
            try {
                FileOutputStream fOut = openFileOutput(file, MODE_PRIVATE);
                fOut.write(data.getBytes());
                fOut.close();
                Toast.makeText(getBaseContext(), "file saved", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        b2.setOnClickListener(v -> {
            try {
                FileInputStream fin = openFileInput(file);
                int c;
                StringBuilder temp = new StringBuilder();
                while ((c = fin.read()) != -1) {
                    temp.append((char) c);
                }
                tv.setText(temp.toString());
                Toast.makeText(getBaseContext(), "file read", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
