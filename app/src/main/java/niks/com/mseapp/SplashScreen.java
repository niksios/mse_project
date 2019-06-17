package niks.com.mseapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        Timer tm = new Timer();
        tm.schedule(new TimerTask() {
            @Override
            public void run() {

            Intent nik = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(nik);
            finish();

            }
        }, 1000);

    }
}
