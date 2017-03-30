package com.pradhanrishi.www.mord.activities;

/**
 * Created by yash on 24/3/17. Activity_splash
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.pradhanrishi.www.mord.ApplicationUtility;
import com.pradhanrishi.www.mord.R;

import java.util.Timer;
import java.util.TimerTask;

public class Activity_splash extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Timer t = new Timer();
        boolean checkConnection = new ApplicationUtility().checkConnection(this);
        if (checkConnection) {
            t.schedule(new splash(), 3000);
        } else {
            Toast.makeText(Activity_splash.this,
                    "Internet connection not available.", Toast.LENGTH_LONG).show();
        }
    }

    class splash extends TimerTask {

        @Override
        public void run() {
            Intent i = new Intent(Activity_splash.this, Activiity_login.class);
            finish();
            startActivity(i);
        }

    }


}