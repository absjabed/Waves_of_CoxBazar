package com.parvez_n_jabed_co.waves_of_coxbazar;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {

    Typeface cursiveTypeface;
    TextView email, sms, share, play, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title_ixom2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_info);


        cursiveTypeface = Typeface.createFromAsset(getAssets(),"fonts/dancing-script.regular.ttf");

        email = (TextView) findViewById(R.id.email);
        email.setTypeface(cursiveTypeface);
        sms = (TextView) findViewById(R.id.sms);
        sms.setTypeface(cursiveTypeface);
        share = (TextView) findViewById(R.id.share);
        share.setTypeface(cursiveTypeface);
        play = (TextView) findViewById(R.id.play);
        play.setTypeface(cursiveTypeface);
        about = (TextView) findViewById(R.id.about);
        about.setTypeface(cursiveTypeface);


    }

    public void onClickAboutUs(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(InfoActivity.this);
        alertDialogBuilder
                .setMessage("Wave of Cox's Bazar Developers:\n\n" +
                        "Mohammad Abu Bakar Siddqe Jabed\n" +
                        "Email: absjabed@gmail.com\n"+
                        "Phone: +8801676749372\n\n"+
                        "And \n\n" +
                        "Md. Khaled Mosharraf Parvez\n" +
                        "Email: kmparvez2@gmail.com\n"+
                        "Phone: +8801843298326\n")
                .setTitle("About Developers")
                .setCancelable(false)
                .setPositiveButton(" OK ",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(InfoActivity.this, "Thanks for your interest.", Toast.LENGTH_LONG).show();
                            }
                        });
        AlertDialog alert = alertDialogBuilder.create();
        alert .setIcon(android.R.drawable.ic_dialog_info);
        alert.show();
    }

    public void onClickPlay(View view) {
        //playstore link
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.parvez_n_jabed_co.waves_of_coxbazar"));
        String title = "Open with another application";
        Intent chooser = Intent.createChooser(intent, title);
        startActivity(chooser);
        /*
        String androidID = System.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        String deviceName = android.os.Build.MODEL;
        String deviceMan = android.os.Build.MANUFACTURER;*/

    }

    public void onClickShare(View view) {
        shareIt();
    }

    public void onClickMessage(View view) {
        String samsung = "Samsung";
        String smsnumber;

        if(Build.MANUFACTURER.equals(samsung)){
            smsnumber = "01676749372, 01843298326";
        }else{
            smsnumber = "01676749372; 01843298326";
        }

        String smstxt = "Any thing you want to know from us, developers............\n\n\n\n-Wave of Cox's Bazar App";

        Uri uri = Uri.parse("smsto:"+smsnumber);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", smstxt);
        startActivity(intent);
    }

    public void onClickEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Put your mail subject here..");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"absjabed@gmailcom","kmparvez2@gmail.com","automateinfosysbd@gmail.com"});
        Intent mailer = Intent.createChooser(intent, "Send feedback / Contact with Developers");
        startActivity(mailer);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.allmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {
            Toast.makeText(this, getString(R.string.youarehere), Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.action_share) {
            //Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
            shareIt();
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareIt() {
//sharing implementation here
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Waves of Cox's Bazar - Powered by Cox's Bazar DC Office. DownLoad Link: https://goo.gl/QwrkLL";//com.parvez_n_jabed_co.waves_of_coxbazar
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Wave of Cox's Bazar - Cox's Bazar at your finger tips."); // https://play.google.com/store/apps/details?id=com.orioninformatics.digitaldhaka
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}
