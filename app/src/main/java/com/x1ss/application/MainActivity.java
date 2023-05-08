package com.x1ss.application;

import static android.Manifest.permission.ACCESS_NOTIFICATION_POLICY;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    Button mode, ring, vibrate, silent;
    private AudioManager myAudioManager;
    private final int RequestPermissionCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mode = (Button) findViewById(R.id.button);
        ring = (Button) findViewById(R.id.button2);
        vibrate = (Button) findViewById(R.id.button3);
        silent = (Button) findViewById(R.id.button4);

        myAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        NotificationManager n = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        if(n.isNotificationPolicyAccessGranted()) {
            AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
            audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        }else{
            // Ask the user to grant access
            Intent intent = new Intent(android.provider.Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
            startActivityForResult(intent, 0);
        }

        vibrate.setOnClickListener(v -> {
            myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            Toast.makeText(MainActivity.this, "Now in Vibrate Mode",
                    Toast.LENGTH_LONG).show();
        });

        ring.setOnClickListener(v -> {
            myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            Toast.makeText(MainActivity.this, "Now in Ringing Mode",
                    Toast.LENGTH_LONG).show();
        });

        silent.setOnClickListener(v -> {
            myAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            Toast.makeText(MainActivity.this, "Now in silent Mode",
                    Toast.LENGTH_LONG).show();
        });

        mode.setOnClickListener(v -> {
            switch (myAudioManager.getRingerMode()) {
                case AudioManager.RINGER_MODE_SILENT ->
                    Toast.makeText(MainActivity.this, "Now in Silent Mode", Toast.LENGTH_LONG).show();
                case AudioManager.RINGER_MODE_VIBRATE ->
                        Toast.makeText(MainActivity.this, "Now in Vibrate Mode", Toast.LENGTH_LONG).show();
                case AudioManager.RINGER_MODE_NORMAL ->
                        Toast.makeText(MainActivity.this, "Now in Ringing Mode", Toast.LENGTH_LONG).show();
            }
        });
    }
}
