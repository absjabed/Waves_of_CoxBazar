package com.parvez_n_jabed_co.waves_of_coxbazar;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HospitalActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    String[] hospital_names= new String[20];
    TypedArray hospital_pics;
    String arr[] = new String[15];
    private static final int REQUEST_CALL = 1;
    Intent callIntent;
    String[] hospital_email;
    String[] hospital_mobile;

    List<RowItem> rowItems;
    ListView mylistview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title_ixom2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_hospital);

        rowItems = new ArrayList<RowItem>();

        hospital_names = getResources().getStringArray(R.array.hospital_names);


        /* <item></item>
        <item></item>
        <item></item>
        <item></item>
        <item></item>
        <item></item>
        <item></item>
        <item>01930529223</item>*/

        arr[0] = "01730324770";
        arr[1] = "034163606";
        arr[2] = "034164674";
        arr[3] = "034163911";
        arr[4] = "0341623120";
        arr[5] = "01843172100";
        arr[6] = "01558633683";
/*

        hospital_names[0] = "A";
        hospital_names[1] = "B";
        hospital_names[2] = "C";
        hospital_names[3] = "D";
        hospital_names[4] = "E";
        hospital_names[5] = "F";
        hospital_names[6] = "G";
        hospital_names[7] = "M";
        hospital_names[8] = "K";
*/


        hospital_pics = getResources().obtainTypedArray(R.array.hospital_pics);

        hospital_email = getResources().getStringArray(R.array.hospital_email);

        hospital_mobile = getResources().getStringArray(R.array.hospital_mobile);

        for (int i = 0; i < hospital_names.length; i++) {

            RowItem item = new RowItem(hospital_names[i], String.valueOf(hospital_pics.getResourceId(i,0)), hospital_email[i], hospital_mobile[i]);
            rowItems.add(i,item);
        }

        mylistview = (ListView) findViewById(R.id.listhos);
        CustomAdapter adapter = new CustomAdapter(this, rowItems);
        mylistview.setAdapter(adapter);

        mylistview.setOnItemClickListener(this);

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


    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HospitalActivity.this);
        alertDialogBuilder
                .setMessage(arr[position]+"\n"+getString(R.string.popUp))
                .setTitle(getString(R.string.permission))
                .setCancelable(true)
                .setPositiveButton(getString(R.string.doCall),
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                callIntent = new Intent(Intent.ACTION_CALL);
                                callIntent.setData(Uri.parse("tel:"+arr[position]));
                                if (ContextCompat.checkSelfPermission(HospitalActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    ActivityCompat.requestPermissions(HospitalActivity.this, new String[]{android.Manifest.permission.CALL_PHONE}, REQUEST_CALL);
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




}
