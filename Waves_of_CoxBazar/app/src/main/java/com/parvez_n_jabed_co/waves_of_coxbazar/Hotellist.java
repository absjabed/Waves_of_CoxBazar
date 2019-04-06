package com.parvez_n_jabed_co.waves_of_coxbazar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
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

public class Hotellist extends AppCompatActivity implements AdapterView.OnItemClickListener {

    TypedArray hospital_pics;

    List<Hotel_Item> rowItems;
    ListView mylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title_ixom2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_hotellist);

        rowItems = new ArrayList<Hotel_Item>();



        hospital_pics = getResources().obtainTypedArray(R.array.hotel_demo_pics);

        //hospital_pics = getResources().obtainTypedArray(R.array.hotel_demo_pics);

        for (int i = 0; i < hospital_pics.length(); i++) {

            Hotel_Item item = new Hotel_Item( hospital_pics.getResourceId(i,0));
            rowItems.add(i,item);
        }

        mylistview = (ListView) findViewById(R.id.hotel_listview);
        Hotel_CustomAdapter adapter = new Hotel_CustomAdapter(this, rowItems);
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
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/allegro-holiday-suites.en-gb.html?label=gen173nr-1BCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGoAgM;sid=3bdd7d8551229a87bacb241d7de8dcc3;room1=A%2CA;dest_type=city;dest_id=211349;m_occ=2");
            startActivity(intent);
        }
        else if(position==1)
        {
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/needs-bay-watch.en-gb.html?label=gen173nr-1BCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGoAgM;sid=3bdd7d8551229a87bacb241d7de8dcc3;room1=A%2CA;dest_type=city;dest_id=211349;m_occ=2");
            startActivity(intent);
        }

        else if(position==2)
        {
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/palm-riviera.en-gb.html?label=gen173nr-1BCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGoAgM;sid=3bdd7d8551229a87bacb241d7de8dcc3;room1=A%2CA;dest_type=city;dest_id=211349;m_occ=2");
            startActivity(intent);
        }
        else if(position==3)
        {
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/zaman-sea-heights.en-gb.html?label=gen173nr-1BCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGoAgM;sid=3bdd7d8551229a87bacb241d7de8dcc3;room1=A%2CA;dest_type=city;dest_id=211349;m_occ=2");
            startActivity(intent);
        }

        else if(position==4)
        {
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/saint-martin-resort.en-gb.html?label=gen173nr-1FCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGCAgFsqAID;sid=c70e69dd857d6b03d70ae179fe70642a;room1=A,A;m_occ=2");
            startActivity(intent);
        }
        else if(position==5)
        {
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/mishuk.en-gb.html?label=gen173nr-1BCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGoAgM;sid=3bdd7d8551229a87bacb241d7de8dcc3;room1=A%2CA;dest_type=city;dest_id=211349;m_occ=2");
            startActivity(intent);
        }

        else if(position==6)
        {
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/unity-inn.en-gb.html?label=gen173nr-1BCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGoAgM;sid=3bdd7d8551229a87bacb241d7de8dcc3;room1=A%2CA;dest_type=city;dest_id=211349;m_occ=2");
            startActivity(intent);
        }
        else if(position==7)
        {
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/sea-crown.en-gb.html?label=gen173nr-1BCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGoAgM;sid=3bdd7d8551229a87bacb241d7de8dcc3;room1=A%2CA;dest_type=city;dest_id=211349;m_occ=2");
            startActivity(intent);
        }

        else if(position==8)
        {
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/muscat-holiday-resort.en-gb.html?label=gen173nr-1BCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGoAgM;sid=3bdd7d8551229a87bacb241d7de8dcc3;room1=A%2CA;dest_type=city;dest_id=211349;m_occ=2");
            startActivity(intent);
        }
        else if(position==9)
        {
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/neeshorgo.en-gb.html?label=gen173nr-1BCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGoAgM;sid=3bdd7d8551229a87bacb241d7de8dcc3;room1=A%2CA;dest_type=city;dest_id=211349;m_occ=2");
            startActivity(intent);
        }

        else if(position==10)
        {
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/beach-way.en-gb.html?label=gen173nr-1BCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGoAgM;sid=3bdd7d8551229a87bacb241d7de8dcc3;room1=A%2CA;dest_type=city;dest_id=211349;m_occ=2");
            startActivity(intent);
        }
        else if(position==11)
        {
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/long-beach-cox-39-s-bazar.en-gb.html?label=gen173nr-1BCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGoAgM;sid=3bdd7d8551229a87bacb241d7de8dcc3;room1=A%2CA;dest_type=city;dest_id=211349;m_occ=2");
            startActivity(intent);
        }

        else if(position==12)
        {
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/bay-touch.en-gb.html?label=gen173nr-1BCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGoAgM;sid=3bdd7d8551229a87bacb241d7de8dcc3;room1=A%2CA;dest_type=city;dest_id=211349;m_occ=2");
            startActivity(intent);
        }
        else if(position==13)
        {
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/coral-reef.en-gb.html?label=gen173nr-1BCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGoAgM;sid=3bdd7d8551229a87bacb241d7de8dcc3;room1=A%2CA;dest_type=city;dest_id=211349;m_occ=2");
            startActivity(intent);
        }

        else if(position==14)
        {
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/prime-park.en-gb.html?label=gen173nr-1BCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGoAgM;sid=3bdd7d8551229a87bacb241d7de8dcc3;room1=A%2CA;dest_type=city;dest_id=211349;m_occ=2");
            startActivity(intent);
        }
        else if(position==15)
        {
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/cox-39-s-hilton-ltd.en-gb.html?label=gen173nr-1BCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGoAgM;sid=3bdd7d8551229a87bacb241d7de8dcc3;room1=A%2CA;dest_type=city;dest_id=211349;m_occ=2");
            startActivity(intent);
        }
        else if(position==16)
        {
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/white-orchid.en-gb.html?label=gen173nr-1BCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGoAgM;sid=3bdd7d8551229a87bacb241d7de8dcc3;room1=A%2CA;dest_type=city;dest_id=211349;m_occ=2");
            startActivity(intent);
        }
        else if(position==17)
        {
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/suite-sadaf.en-gb.html?label=gen173nr-1BCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGoAgM;sid=3bdd7d8551229a87bacb241d7de8dcc3;room1=A%2CA;dest_type=city;dest_id=211349;m_occ=2");
            startActivity(intent);
        }
        else if(position==18)
        {
            Intent intent = new Intent(Hotellist.this,WebViewActivity.class);
            intent.putExtra("URL","http://m.booking.com/hotel/bd/windy-terrace-boutique.en-gb.html?label=gen173nr-1BCAEoggJCAlhYSDNiBW5vcmVmaBSIAQGYAS64AQjIAQzYAQHoAQGoAgM;sid=3bdd7d8551229a87bacb241d7de8dcc3;room1=A%2CA;dest_type=city;dest_id=211349;m_occ=2");
            startActivity(intent);
        }


    }
}
