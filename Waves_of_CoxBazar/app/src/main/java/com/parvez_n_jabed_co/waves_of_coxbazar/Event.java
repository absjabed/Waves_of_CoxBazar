package com.parvez_n_jabed_co.waves_of_coxbazar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Event extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title_ixom2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_event);

        GridView gridview = (GridView) findViewById(R.id.gridviewevent);

        gridview.setAdapter(new EventAdapter(
                new FruitItem(getString(R.string.icon_photographar),R.drawable.photograph),
                new FruitItem(getString(R.string.icon_beach_bike),R.drawable.beachbike),
                new FruitItem(getString(R.string.icon_jet_ski),R.drawable.jetski),
                new FruitItem(getString(R.string.icon_para_seiling),R.drawable.paraseling)/*,
                new FruitItem("Culture",R.drawable.culture)*/));


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                switch(position) {
                    case 0:
                        Toast.makeText(Event.this, getString(R.string.noData), Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Intent intent1 = new Intent(Event.this,BeachBike.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(Event.this,Jet2Activity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(Event.this,PeraActivity.class);
                        startActivity(intent3);
                        break;
//                    case 4:
//                        Intent intent4 = new Intent(Event.this,BlankActivity.class);
//                        startActivity(intent4);
//                        break;
                }
            }
        });
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

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
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }



}
