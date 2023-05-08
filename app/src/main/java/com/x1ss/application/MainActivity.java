package com.x1ss.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1= findViewById(R.id.login);
        ed2= findViewById(R.id.password);
        b1= findViewById(R.id.button);

        b1.setOnClickListener(v -> {
            IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
            Intent batteryStatus = registerReceiver(null, ifilter);

            int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED,-1);
            boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;

            if(usbCharge){
                Toast.makeText(getApplicationContext(),"Mobile is charging on USB",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(),"Mobile isn't charging on USB",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
