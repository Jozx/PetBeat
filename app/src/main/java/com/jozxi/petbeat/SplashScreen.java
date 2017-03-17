package com.jozxi.petbeat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by jsara on 04/03/2017.
 */

public class SplashScreen extends Activity {
    private ProgressBar mProgress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Show the splash screen
        setContentView(R.layout.splash_screen);
        mProgress = (ProgressBar) findViewById(R.id.splash_screen_progress_bar);

        // Start lengthy operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                doWork();
                startApp();
                finish();
            }
        }).start();
    }

    private void doWork() {
        for (int progress=0; progress<100; progress+=10) {
            try {
                Thread.sleep(500);
                mProgress.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();
                Log.i("Error ",e.toString());
            }
        }
    }

    private void startApp() {

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("Refreshed token: " ,refreshedToken);

        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
    }
}

