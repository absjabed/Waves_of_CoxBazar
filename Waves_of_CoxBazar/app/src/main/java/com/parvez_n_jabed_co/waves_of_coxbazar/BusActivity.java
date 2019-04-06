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

public class BusActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    String[] hospital_names= new String[20];
    TypedArray hospital_pics;

    String[] hospital_email;
    String[] hospital_mobile;
    String arr[] = new String[14];
    private static final int REQUEST_CALL = 1;
    Intent callIntent;
    List<RowItem> rowItems;
    ListView mylistview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title_ixom2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_bus);

        rowItems = new ArrayList<RowItem>();

        hospital_names = getResources().getStringArray(R.array.bus_names);


/*<item>Muhibur Rahman\n</item>
        <item>Shamim\n</item>
        <item>Rahim\n</item>
        <item>Swapan\n</item>
        <item>Titu\n</item>
        <item>Shah Alam\n</item>
        <item>Niru\n</item>
        <item>Alam\n</item>
        <item>Lutfar\n</item>
        <item>Sultan\n</item>
        <item>Reza\n</item>
        <item>Giyas\n</item>
        <item>Khorshed\n</item>*/

        arr[0] = "01713402634";
        arr[1] = "01818209627";
        arr[2] = "01928721484";
        arr[3] = "01818632276";
        arr[4] = "01722384499";
        arr[5] = "01710166252";
        arr[6] = "01919654811";
        arr[7] = "01711272183";
        arr[8] = "01733052201";
        arr[9] = "01970060045";
        arr[10] = "01719639447";
        arr[11] = "0182736110";
        arr[12] = "01819108584";
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


        hospital_pics = getResources().obtainTypedArray(R.array.bus_pics);

        hospital_email = getResources().getStringArray(R.array.bus_email);

        hospital_mobile = getResources().getStringArray(R.array.bus_mobile);

        for (int i = 0; i < hospital_names.length; i++) {

            RowItem item = new RowItem(hospital_names[i], String.valueOf(hospital_pics.getResourceId(i,0)), hospital_email[i], hospital_mobile[i]);
            rowItems.add(i,item);
        }

        mylistview = (ListView) findViewById(R.id.bus_listview);
        BusAdapter adapter = new BusAdapter(this, rowItems);
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

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(BusActivity.this);
        alertDialogBuilder
                .setMessage(arr[position]+"\n"+getString(R.string.popUp))
                .setTitle(getString(R.string.permission))
                .setCancelable(true)
                .setPositiveButton(getString(R.string.doCall),
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                callIntent = new Intent(Intent.ACTION_CALL);
                                callIntent.setData(Uri.parse("tel:"+arr[position]));
                                if (ContextCompat.checkSelfPermission(BusActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    ActivityCompat.requestPermissions(BusActivity.this, new String[]{android.Manifest.permission.CALL_PHONE}, REQUEST_CALL);
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
