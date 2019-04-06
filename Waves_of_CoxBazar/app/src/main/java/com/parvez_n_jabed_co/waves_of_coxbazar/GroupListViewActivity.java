package com.parvez_n_jabed_co.waves_of_coxbazar;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GroupListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    String[] hospital_names= new String[200];
    TypedArray hospital_pics;

    String[] hospital_email;
    String[] hospital_mobile;
    int activity;
    List<RowItem> rowItems;
    ListView mylistview;
    String json_response;
    JSONObject jsonObject;
    JSONArray jsonArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title_ixom2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_group_list_view);

        rowItems = new ArrayList<RowItem>();


/*

        Bundle bundle = getIntent().getExtras();
        int image_res_address = bundle.getInt("RES_IMAGE");
        int name_res_address  = bundle.getInt("RES_NAME");
        int email_res_address  = bundle.getInt("RES_EMAIL");
        int mobile_res_address  = bundle.getInt("RES_MOBILE");
         activity = bundle.getInt("ACTIVITY");
        hospital_names = getResources().getStringArray(name_res_address);
        hospital_pics = getResources().obtainTypedArray(image_res_address);
        hospital_email = getResources().getStringArray(email_res_address);
        hospital_mobile = getResources().getStringArray(mobile_res_address);

*/


         json_response = getIntent().getExtras().getString("jsonData");

        try {
            jsonObject = new JSONObject(json_response);
            jsonArray = jsonObject.getJSONArray(Config.JSON_ARRAY);
            int count =0;
            String id, hotel_name,hotel_logo_name,hotel_email,hotel_phone_number,status;
            while(count<jsonArray.length()){

                JSONObject JO = jsonArray.getJSONObject(count);
                id = JO.getString("id");
                hotel_name = JO.getString("hotel_name");
                hotel_logo_name = JO.getString("hotel_logo_name");
                hotel_email = JO.getString("hotel_email");
                hotel_phone_number = JO.getString("hotel_phone_number");
                status = JO.getString("status");

                RowItem item = new RowItem(hotel_name, hotel_logo_name, hotel_email, hotel_phone_number);
                rowItems.add(count,item);
                count++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }



       /* for (int i = 0; i < hospital_names.length; i++) {

            RowItem item = new RowItem(hospital_names[i], hospital_pics.getResourceId(i,0), hospital_email[i], hospital_mobile[i]);
            rowItems.add(i,item);
        }*/



        mylistview = (ListView) findViewById(R.id.res_listview);
        RestaurantAdapter adapter = new RestaurantAdapter(this, rowItems);
        mylistview.setAdapter(adapter);

        mylistview.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        String hospital_name = rowItems.get(position).getHospital_name();
        Toast.makeText(getApplicationContext(), "" + hospital_name,
                Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(GroupListViewActivity.this,HotelViewActivity.class);
        intent.putExtra("hotel_id",String.valueOf(position+1));
        startActivity(intent);


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
        if (id == R.id.hotellist) {
            Intent infoIntent = new Intent(this,Hotelmotel2Activity.class);
            startActivity(infoIntent);
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
