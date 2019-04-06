package com.parvez_n_jabed_co.waves_of_coxbazar;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BlankActivity extends AppCompatActivity {

    LinearLayout layout1,layout2,layout3,layout4,layout5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title_ixom2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_blank);

        layout1 = (LinearLayout)findViewById(R.id.layout11);
        layout2 = (LinearLayout)findViewById(R.id.layout22);
        layout3 = (LinearLayout)findViewById(R.id.layout33);
        layout4 = (LinearLayout)findViewById(R.id.layout44);
        layout5 = (LinearLayout)findViewById(R.id.layout55);
        /*<item>Biman Bangladesh Airlines</item>
        <item>US-Bangla Airlines</item>
        <item>Novoair</item>
        <item>Regent Airways</item>
        <item>United Airways</item>*//*
        Biman Bangladesh Airlines
        https://www.biman-airlines.com/

        US-Bangla Airlines
        https://us-banglaairlines.com/flight_destination/fares

        Novoair
        https://flynovoair.com/index.php/destinations/domestic/coxsbazar

        Regent Airways
        http://www.flyregent.com/fare-chart

        United Airways
        http://www.uabdl.com/fare.html*/
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(BlankActivity.this);
                alertDialogBuilder
                        .setMessage(getString(R.string.airweb)+" "+getString(R.string.bdair)+" "+getString(R.string.airweb2))
                        .setTitle(getString(R.string.vpermission))
                        .setCancelable(true)
                        .setPositiveButton(getString(R.string.visit),
                                new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent = new Intent(BlankActivity.this,WebViewActivity.class);
                                        intent.putExtra("URL","https://www.biman-airlines.com/");
                                        startActivity(intent);
                                    }
                                });

                alertDialogBuilder.setNegativeButton(getString(R.string.restartCancle), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        //finish();
                    }
                });
                AlertDialog alert = alertDialogBuilder.create();
                alert.show();
            }
        });

        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(BlankActivity.this);
                alertDialogBuilder
                        .setMessage(getString(R.string.airweb)+" "+getString(R.string.usbd)+" "+getString(R.string.airweb2))
                        .setTitle(getString(R.string.vpermission))
                        .setCancelable(true)
                        .setPositiveButton(getString(R.string.visit),
                                new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog, int id) {

                                        Intent intent = new Intent(BlankActivity.this,WebViewActivity.class);
                                        intent.putExtra("URL","https://us-banglaairlines.com/flight_destination/fares");
                                        startActivity(intent);                                    }
                                });

                alertDialogBuilder.setNegativeButton(getString(R.string.restartCancle), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        //finish();
                    }
                });
                AlertDialog alert = alertDialogBuilder.create();
                alert.show();

            }
        });

        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(BlankActivity.this);
                alertDialogBuilder
                        .setMessage(getString(R.string.airweb)+" "+getString(R.string.novo)+" "+getString(R.string.airweb2))
                        .setTitle(getString(R.string.vpermission))
                        .setCancelable(true)
                        .setPositiveButton(getString(R.string.visit),
                                new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog, int id) {

                                        Intent intent = new Intent(BlankActivity.this,WebViewActivity.class);
                                        intent.putExtra("URL","https://flynovoair.com/index.php/destinations/domestic/coxsbazar");
                                        startActivity(intent);                                    }
                                });

                alertDialogBuilder.setNegativeButton(getString(R.string.restartCancle), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        //finish();
                    }
                });
                AlertDialog alert = alertDialogBuilder.create();
                alert.show();

            }
        });

        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(BlankActivity.this);
                alertDialogBuilder
                        .setMessage(getString(R.string.airweb)+" "+getString(R.string.regent)+" "+getString(R.string.airweb2))
                        .setTitle(getString(R.string.vpermission))
                        .setCancelable(true)
                        .setPositiveButton(getString(R.string.visit),
                                new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent = new Intent(BlankActivity.this,WebViewActivity.class);
                                        intent.putExtra("URL","http://www.flyregent.com/fare-chart");
                                        startActivity(intent);                                    }
                                });

                alertDialogBuilder.setNegativeButton(getString(R.string.restartCancle), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        //finish();
                    }
                });
                AlertDialog alert = alertDialogBuilder.create();
                alert.show();
            }
        });

        layout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(BlankActivity.this);
                alertDialogBuilder
                        .setMessage(getString(R.string.airweb)+" "+getString(R.string.united)+" "+getString(R.string.airweb2))
                        .setTitle(getString(R.string.vpermission))
                        .setCancelable(true)
                        .setPositiveButton(getString(R.string.visit),
                                new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog, int id) {

                                        Intent intent = new Intent(BlankActivity.this,WebViewActivity.class);
                                        intent.putExtra("URL","http://www.uabdl.com/fare.html*/");
                                        startActivity(intent);                                    }
                                });

                alertDialogBuilder.setNegativeButton(getString(R.string.restartCancle), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        //finish();
                    }
                });
                AlertDialog alert = alertDialogBuilder.create();
                alert.show();

            }
        });



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
            Intent infoIntent = new Intent(this,InfoActivity.class);
            startActivity(infoIntent);
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
        String shareBody = "Wave of Cox's Bazar - Powered by Cox's Bazar DC Office. DownLoad Link: https://goo.gl/QwrkLL";//com.parvez_n_jabed_co.waves_of_coxbazar
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Wave of Cox's Bazar - Cox's Bazar at your finger tips."); // https://play.google.com/store/apps/details?id=com.orioninformatics.digitaldhaka
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

}
