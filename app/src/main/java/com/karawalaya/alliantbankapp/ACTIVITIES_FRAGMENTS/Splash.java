package com.karawalaya.alliantbankapp.ACTIVITIES_FRAGMENTS;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.karawalaya.alliantbankapp.R;

public class Splash extends AppCompatActivity {
//    private static int SPLASH_TIMEOUT = 5000;
    ImageView splashImage;
    TextView splashText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashImage = (ImageView) findViewById(R.id.splashImage);
        splashText = (TextView) findViewById(R.id.splashText);

        Animation animation = AnimationUtils.loadAnimation(Splash.this, R.anim.splash_animation);
        splashImage.startAnimation(animation);
        splashText.startAnimation(animation);

/*        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIMEOUT);*/

        final Intent intent = new Intent(this, MainActivity.class);
        Thread timer = new Thread() {
            @Override
            public void run() {
                try{
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                    finish();
                }
            }
        };

        timer.start();

    }
}
