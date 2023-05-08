package com.x1ss.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2;
    Button b1, b2;

    private ClipboardManager myClipboard;
    private ClipData myClip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText2);

        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);

        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        b1.setOnClickListener(v -> {
            String text;
            text = ed1.getText().toString();

            myClip = ClipData.newPlainText("text", text);
            myClipboard.setPrimaryClip(myClip);

            Toast.makeText(getApplicationContext(), "Text Copied",
                    Toast.LENGTH_SHORT).show();
        });

        b2.setOnClickListener(v -> {
            ClipData abc = myClipboard.getPrimaryClip();
            ClipData.Item item = abc.getItemAt(0);

            String text = item.getText().toString();
            ed2.setText(text);

            Toast.makeText(getApplicationContext(), "Text Pasted",
                    Toast.LENGTH_SHORT).show();
        });
    }
}
