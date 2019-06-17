package niks.com.mseapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen_Menu extends AppCompatActivity {

   ImageButton screen1, screen2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen_menu);


        screen1 = (ImageButton)findViewById(R.id.screen1);
        screen2 = (ImageButton)findViewById(R.id.screen2);


        screen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nik = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(nik);
                finish();

            }
        });


        screen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nik = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(nik);
                finish();

            }
        });


    }//oncreate

    @Override
    public void onBackPressed() {

                new AlertDialog.Builder(SplashScreen_Menu.this)
                .setMessage("Do you want to exit!")
                .setIcon(R.mipmap.ando)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                        homeIntent.addCategory(Intent.CATEGORY_HOME);
                        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(homeIntent);
                        finish();



                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).show();


    }


}//main
