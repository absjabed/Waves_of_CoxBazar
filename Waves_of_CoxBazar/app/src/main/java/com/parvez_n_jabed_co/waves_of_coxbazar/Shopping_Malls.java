package com.parvez_n_jabed_co.waves_of_coxbazar;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

public class Shopping_Malls extends AppCompatActivity {
    BaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title_ixom2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_shopping__malls);


        ListView ainshriListview;

        final ArrayList<JetshiItem> arrayList;

        ainshriListview=(ListView) findViewById(R.id.shopListview);
        arrayList=new ArrayList<JetshiItem>();

        arrayList.add(new JetshiItem(getString(R.string.market1),getString(R.string.market2)));
        arrayList.add(new JetshiItem(getString(R.string.market3),getString(R.string.market4)));
        arrayList.add(new JetshiItem(getString(R.string.market5),getString(R.string.market6)));
        arrayList.add(new JetshiItem(getString(R.string.market7),getString(R.string.market8)));
        arrayList.add(new JetshiItem(getString(R.string.market9),getString(R.string.market10)));
        arrayList.add(new JetshiItem(getString(R.string.market11),getString(R.string.market12)));
        arrayList.add(new JetshiItem(getString(R.string.market13),getString(R.string.market14)));
        arrayList.add(new JetshiItem(getString(R.string.market15),getString(R.string.market16)));
        arrayList.add(new JetshiItem(getString(R.string.market17),getString(R.string.market18)));
        arrayList.add(new JetshiItem(getString(R.string.market19),getString(R.string.market20)));
        arrayList.add(new JetshiItem(getString(R.string.market21),getString(R.string.market22)));
        arrayList.add(new JetshiItem(getString(R.string.market23),getString(R.string.market24)));
        arrayList.add(new JetshiItem(getString(R.string.market25),getString(R.string.market26)));
        arrayList.add(new JetshiItem(getString(R.string.market27),getString(R.string.market28)));


        adapter=new BaseAdapter() {

            LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            @Override
            public View getView(int position, View view, ViewGroup viewGroup) {
                if (view==null) {
                    view=inflater.inflate(R.layout.jeski_list_item, null);
                }
                TextView nameTextView=(TextView) view.findViewById(R.id.jetskilistItemTextView);
                TextView mobileTextView=(TextView) view.findViewById(R.id.jetskimobileTextView);

                nameTextView.setText(arrayList.get(position).getJetname());

                mobileTextView.setText(arrayList.get(position).getMobilenumber());

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


                //Toast.makeText(getBaseContext(), "One Item Removed", Toast.LENGTH_SHORT).show();

                return false;
            }
        });
        ainshriListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {


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
