package com.parvez_n_jabed_co.waves_of_coxbazar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TransportActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    String[] hospital_names= new String[20];
    TypedArray trans_pic;

    List<TransportItem> rowItems;
    ListView mylistview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title_ixom2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_transport);

        rowItems = new ArrayList<TransportItem>();

        hospital_names = getResources().getStringArray(R.array.trans_types);

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


        trans_pic = getResources().obtainTypedArray(R.array.trans_pics);


        for (int i = 0; i < hospital_names.length; i++) {

            TransportItem item = new TransportItem(hospital_names[i], trans_pic.getResourceId(i,0));
            rowItems.add(i,item);
        }

        mylistview = (ListView) findViewById(R.id.trans_list_view);
        TransportAdepter adapter = new TransportAdepter(this, rowItems);
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position==0)
        {
            //Car rental
            Toast.makeText(this, "No Data available.", Toast.LENGTH_SHORT).show();
        }
        else if(position==1)
        {
            //Bus service
            Intent intent = new Intent(TransportActivity.this,BusActivity.class);
            startActivity(intent);
        }
        else  if(position==2)
        {
            //Airline
            Intent intent = new Intent(TransportActivity.this,BlankActivity.class);
            startActivity(intent);
        }/*
        else if(position==3)
        {
            //out of service
            Intent intent = new Intent(TransportActivity.this,Jet2Activity.class);
            startActivity(intent);
        }*/

    }




}
