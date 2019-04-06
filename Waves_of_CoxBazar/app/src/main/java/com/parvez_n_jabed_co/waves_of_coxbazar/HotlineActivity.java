
package com.parvez_n_jabed_co.waves_of_coxbazar;

import android.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
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

public class HotlineActivity extends AppCompatActivity {

    LinearLayout hotline1,hotline2,hotline3;

    private static final int REQUEST_CALL = 1;
    Intent callIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title_ixom2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_hotline);

        hotline1 = (LinearLayout)findViewById(R.id.layout11m);
        hotline2 = (LinearLayout)findViewById(R.id.layout22p);
        hotline3 = (LinearLayout)findViewById(R.id.layout21m);



        hotline1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HotlineActivity.this);
                alertDialogBuilder
                        .setMessage(getString(R.string.num11)+"\n"+getString(R.string.popUp))
                        .setTitle(getString(R.string.permission))
                        .setCancelable(true)
                        .setPositiveButton(getString(R.string.doCall),
                                new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog, int id) {
                                        callIntent = new Intent(Intent.ACTION_CALL);
                                        callIntent.setData(Uri.parse("tel:01733373127"));
                                        if (ContextCompat.checkSelfPermission(HotlineActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                            ActivityCompat.requestPermissions(HotlineActivity.this, new String[]{android.Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                                        } else {
                                            startActivity(callIntent);
                                        }
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

        hotline2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HotlineActivity.this);
                alertDialogBuilder
                        .setMessage(getString(R.string.num22)+"\n"+getString(R.string.popUp))
                        .setTitle(getString(R.string.permission))
                        .setCancelable(true)
                        .setPositiveButton(getString(R.string.doCall),
                                new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog, int id) {
                                        callIntent = new Intent(Intent.ACTION_CALL);
                                        callIntent.setData(Uri.parse("tel:01769690732"));
                                        if (ContextCompat.checkSelfPermission(HotlineActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                            ActivityCompat.requestPermissions(HotlineActivity.this, new String[]{android.Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                                        } else {
                                            startActivity(callIntent);
                                        }
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


        hotline3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HotlineActivity.this);
                alertDialogBuilder
                        .setMessage(getString(R.string.num33)+"\n"+getString(R.string.popUp))
                        .setTitle(getString(R.string.permission))
                        .setCancelable(true)
                        .setPositiveButton(getString(R.string.doCall),
                                new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog, int id) {
                                        callIntent = new Intent(Intent.ACTION_CALL);
                                        callIntent.setData(Uri.parse("tel:01799900066"));
                                        if (ContextCompat.checkSelfPermission(HotlineActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                            ActivityCompat.requestPermissions(HotlineActivity.this, new String[]{android.Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                                        } else {
                                            startActivity(callIntent);
                                        }
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
