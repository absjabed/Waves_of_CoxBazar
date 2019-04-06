package com.parvez_n_jabed_co.waves_of_coxbazar;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.vansuita.library.CheckNewAppVersion;

public class SplashActivity extends AppCompatActivity {

    ImageView image;
    private static int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_splash);
       FirebaseMessaging.getInstance().subscribeToTopic("COX");


        new CheckNewAppVersion(this).setOnTaskCompleteListener(new CheckNewAppVersion.ITaskComplete() {
            @Override
            public void onTaskComplete(CheckNewAppVersion.Result result) {

                //Checks if there is a new version available on Google Play Store.
                if(result.hasNewVersion()){
                    //Get the new published version code of the app.
                    result.getNewVersionCode();

                    //Get the app current version code.
                    result.getOldVersionCode();

                    //Opens the Google Play Store on your app page to do the update.
                    result.openUpdateLink();
                }else{
                    new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                        @Override
                        public void run() {
                            // This method will be executed once the timer is over
                            // Start your app main activity
                            //frameAnimation.stop();
                            try {
                                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                                startActivity(i);
                            }catch (Exception ex){
                                Toast.makeText(SplashActivity.this, "There is a problem with Mobile Settings.", Toast.LENGTH_SHORT).show();
                            }


                            // close this activity
                            finish();
                        }
                    }, SPLASH_TIME_OUT);
                }

            }
        }).execute();


    }




}
