package com.parvez_n_jabed_co.waves_of_coxbazar;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LifeStylenew extends AppCompatActivity {
    BaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title_ixom2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_life_stylenew);


        ListView ainshriListview;

        final ArrayList<JetshiItem> arrayList;


        ainshriListview =(ListView) findViewById(R.id.lifestyleListview);
        arrayList = new ArrayList<>();

        arrayList.add(new JetshiItem(getString(R.string.item_shopping_centre)));
        arrayList.add(new JetshiItem(getString(R.string.item_cultural_centre)));
        arrayList.add(new JetshiItem(getString(R.string.item_events)));
        arrayList.add(new JetshiItem(getString(R.string.item_entertainment)));


        adapter = new BaseAdapter() {

            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            @Override
            public View getView(int position, View view, ViewGroup viewGroup) {

                if (view == null) {

                    view = inflater.inflate(R.layout.new_list_item, null);
                }

                TextView nameTextView=(TextView) view.findViewById(R.id.desc);
                // TextView mobileTextView=(TextView) view.findViewById(R.id.jetskimobileTextView);

                nameTextView.setText(arrayList.get(position).getJetname());

                // mobileTextView.setText(arrayList.get(position).getMobilenumber());

                return view;
            }

            @Override
            public long getItemId(int position) {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public Object getItem(int position) {

                return arrayList.get(position);
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return arrayList.size();
            }
        };

        ainshriListview.setAdapter(adapter);

        ainshriListview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View view,
                                           int position, long ID) {

//Toast.makeText(getBaseContext(), "Item long pressed!", Toast.LENGTH_SHORT).show();

                return false;
            }
        });
        ainshriListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        Intent intent = new Intent(LifeStylenew.this,Shopping_Malls.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(LifeStylenew.this, getString(R.string.noData), Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(LifeStylenew.this, getString(R.string.noData), Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(LifeStylenew.this, getString(R.string.noData), Toast.LENGTH_SHORT).show();
                        break;
                }
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

