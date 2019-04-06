package com.parvez_n_jabed_co.waves_of_coxbazar;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.TypefaceProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HotelViewActivity extends AppCompatActivity {
    private NetworkImageView img1;
    private NetworkImageView img2;
    private NetworkImageView img3;
    private NetworkImageView img4;
    private NetworkImageView img5;
    private ImageLoader mImageLoader;
    private EditText editTextId;
    private Button buttonGet;
    BootstrapButton bookingBtn,queryBtn;
    private ImageView hotellogo;
    Typeface cursiveTypeface;
    private TextView tx1,tx2,tx3,tx4,tx5, tx6,tx7,tx8,tx9,tx10,tx11,tx12,tx13; //typeface fonts
    private TextView hotelNameTv,distanceTv, suitTv, internetTv, parkingTv, petsTv, shopsTv, businessTv, poolTv, fooddrinkTv, transportTv, receptionTv, cleaningTv, miscTv;
    // Data Variables--------------
    String id = "";
    String hotel_name="";
    String hotel_logo_name="";
    String hotel_img1_name = "";
    String hotel_img2_name = "";
    String hotel_img3_name = "";
    String hotel_img4_name = "";
    String hotel_img5_name = "";
    String hotel_booking_link = "";
    String hotel_email = "";
    String hotel_phone_number = "";
    String hotel_destination = "";
    String special_suit = "";
    String internet = "";
    String parking = "";
    String pets = "";
    String shops = "";
    String business_facility = "";
    String swiming_pool = "";
    String food_drink = "";
    String transport = "";
    String reception_service = "";
    String cleaning_service = "";
    String miscellaneous = "";
    String status = "";
    //-----------------------------
    String hotel_id;
    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title_ixom2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        TypefaceProvider.registerDefaultIconSets();
        setContentView(R.layout.activity_hotel_view);

        hotel_id = getIntent().getStringExtra("hotel_id");
        mImageLoader = CustomVolleyRequestQueueHotel.getInstance(this).getImageLoader();

        //setting hotel view typeface
        cursiveTypeface = Typeface.createFromAsset(getAssets(),"fonts/dancing-script.regular.ttf");
        tx1 = (TextView)findViewById(R.id.tx1);
        tx1.setTypeface(cursiveTypeface);
        tx2 = (TextView)findViewById(R.id.tx2);
        tx2.setTypeface(cursiveTypeface);
        tx3 = (TextView)findViewById(R.id.tx3);
        tx3.setTypeface(cursiveTypeface);
        tx4 = (TextView)findViewById(R.id.tx4);
        tx4.setTypeface(cursiveTypeface);
        tx5 = (TextView)findViewById(R.id.tx5);
        tx5.setTypeface(cursiveTypeface);
        tx6 = (TextView)findViewById(R.id.tx6);
        tx6.setTypeface(cursiveTypeface);
        tx7 = (TextView)findViewById(R.id.tx7);
        tx7.setTypeface(cursiveTypeface);
        tx8 = (TextView)findViewById(R.id.tx8);
        tx8.setTypeface(cursiveTypeface);
        tx9 = (TextView)findViewById(R.id.tx9);
        tx9.setTypeface(cursiveTypeface);
        tx10 = (TextView)findViewById(R.id.tx10);
        tx10.setTypeface(cursiveTypeface);
        tx11 = (TextView)findViewById(R.id.tx11);
        tx11.setTypeface(cursiveTypeface);
        tx12 = (TextView)findViewById(R.id.tx12);
        tx12.setTypeface(cursiveTypeface);
        tx13 = (TextView)findViewById(R.id.tx13);
        tx13.setTypeface(cursiveTypeface);
        //typeface setting ends


      //  editTextId = (EditText) findViewById(R.id.editTextId);
      //  buttonGet = (Button) findViewById(R.id.buttonGet);
        bookingBtn = (BootstrapButton) findViewById(R.id.bookingBtn);
        queryBtn = (BootstrapButton)findViewById(R.id.queryBtn);
       // hotellogo =(ImageView)findViewById(R.id.imglogoIv);
        hotelNameTv = (TextView) findViewById(R.id.hotelNameTv);
        distanceTv  = (TextView) findViewById(R.id.hotelDestinationTv);
        suitTv = (TextView) findViewById(R.id.suit);
        internetTv = (TextView) findViewById(R.id.internet);
        parkingTv = (TextView) findViewById(R.id.parking);
        petsTv = (TextView) findViewById(R.id.pets);
        shopsTv = (TextView) findViewById(R.id.shops);
        businessTv = (TextView) findViewById(R.id.business);
        poolTv = (TextView) findViewById(R.id.pool);
        fooddrinkTv = (TextView) findViewById(R.id.fooddrink);
        transportTv = (TextView) findViewById(R.id.transport);
        receptionTv = (TextView) findViewById(R.id.reception);
        cleaningTv = (TextView) findViewById(R.id.cleaning);
        miscTv = (TextView) findViewById(R.id.misc);
        img1 = (NetworkImageView)findViewById(R.id.img1);
        img2 = (NetworkImageView)findViewById(R.id.img2);
        img3 = (NetworkImageView)findViewById(R.id.img3);
        img4 = (NetworkImageView)findViewById(R.id.img4);
        img5 = (NetworkImageView)findViewById(R.id.img5);
try {
    //Toast.makeText(this, "hotel_id: "+hotel_id, Toast.LENGTH_SHORT).show();
            getData();
        }catch (Exception ex){
            Toast.makeText(this, getString(R.string.internet_error), Toast.LENGTH_LONG).show();
            loading.dismiss();
        }










    }

    private void getData() {
      /**  String id = editTextId.getText().toString().trim();
        if (id.equals("")) {
            Toast.makeText(this, "Please enter an id", Toast.LENGTH_LONG).show();
            return;
        }*/

        loading = ProgressDialog.show(this,getString(R.string.pleaseWait),"Fetching...",false,false);

        String url = Config.DATA_URL+hotel_id.trim();

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(HotelViewActivity.this,getString(R.string.internet_error),Toast.LENGTH_LONG).show();
                        loading.dismiss();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String response){


        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);
            JSONObject hotelData = result.getJSONObject(0);
            id = hotelData.getString(Config.KEY_id);
            hotel_name = hotelData.getString(Config.KEY_hotel_name);

            hotel_logo_name = hotelData.getString(Config.KEY_hotel_logo_name);
            hotel_img1_name = hotelData.getString(Config.KEY_hotel_img1_name);
            hotel_img2_name = hotelData.getString(Config.KEY_hotel_img2_name);
            hotel_img3_name = hotelData.getString(Config.KEY_hotel_img3_name);
            hotel_img4_name = hotelData.getString(Config.KEY_hotel_img4_name);
            hotel_img5_name = hotelData.getString(Config.KEY_hotel_img5_name);

            hotel_booking_link = hotelData.getString(Config.KEY_hotel_booking_link);
            hotel_email = hotelData.getString(Config.KEY_hotel_email);
            hotel_phone_number = hotelData.getString(Config.KEY_hotel_phone_number);
            hotel_destination = hotelData.getString(Config.KEY_hotel_destination);
            special_suit = hotelData.getString(Config.KEY_special_suit);
            internet = hotelData.getString(Config.KEY_internet);
            parking = hotelData.getString(Config.KEY_parking);
            pets = hotelData.getString(Config.KEY_pets);
            shops = hotelData.getString(Config.KEY_shops);
            business_facility = hotelData.getString(Config.KEY_business_facility);
            swiming_pool = hotelData.getString(Config.KEY_swiming_pool);
            food_drink = hotelData.getString(Config.KEY_food_drink);
            transport = hotelData.getString(Config.KEY_transport);
            reception_service = hotelData.getString(Config.KEY_reception_service);
            cleaning_service = hotelData.getString(Config.KEY_cleaning_service);
            miscellaneous = hotelData.getString(Config.KEY_miscellaneous);
            status = hotelData.getString(Config.KEY_status);
        } catch (JSONException e) {
            e.printStackTrace();
        }
       // textViewResult.setText("Name:\t"+name+"\nAddress:\t" +address+ "\nVice Chancellor:\t"+ vc);
        // hotelNameTv,distanceTv, suitTv, internetTv, parkingTv, petsTv, shopsTv, businessTv, poolTv, fooddrinkTv, transportTv, receptionTv, cleaningTv, miscTv



        mImageLoader.get(hotel_img1_name, ImageLoader.getImageListener(img1, R.drawable.loading, R.mipmap.ic_launcher));
        img1.setImageUrl(hotel_img1_name,mImageLoader);

        mImageLoader.get(hotel_img2_name, ImageLoader.getImageListener(img2, R.drawable.loading, R.mipmap.ic_launcher));
        img2.setImageUrl(hotel_img2_name,mImageLoader);

        mImageLoader.get(hotel_img3_name, ImageLoader.getImageListener(img3, R.drawable.loading, R.mipmap.ic_launcher));
        img3.setImageUrl(hotel_img3_name,mImageLoader);

        mImageLoader.get(hotel_img4_name, ImageLoader.getImageListener(img4, R.drawable.loading, R.mipmap.ic_launcher));
        img4.setImageUrl(hotel_img4_name,mImageLoader);

        mImageLoader.get(hotel_img5_name, ImageLoader.getImageListener(img5, R.drawable.loading, R.mipmap.ic_launcher));
        img5.setImageUrl(hotel_img5_name,mImageLoader);

        hotelNameTv.setText(hotel_name);
        distanceTv.setText(hotel_destination);
        suitTv.setText(special_suit);
        internetTv.setText(internet);
        parkingTv.setText(parking);
        petsTv.setText(pets);
        shopsTv.setText(shops);
        businessTv.setText(business_facility);
        poolTv.setText(swiming_pool);
        fooddrinkTv.setText(food_drink);
        transportTv.setText(transport);
        receptionTv.setText(reception_service);
        cleaningTv.setText(cleaning_service);
        miscTv.setText(miscellaneous);
    }



    public void RoomBookingButtonClick(View view) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HotelViewActivity.this);
        alertDialogBuilder
                .setMessage(getString(R.string.hweb1))
                .setTitle(getString(R.string.vpermission))
                .setCancelable(true)
                .setPositiveButton(getString(R.string.visit),
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                Intent webviewIntent = new Intent(HotelViewActivity.this,WebViewActivity.class);
                                webviewIntent.putExtra("URL",hotel_booking_link);
                                startActivity(webviewIntent);
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


    public void QueryButtonClick(View view) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (!isFinishing()){
                    new AlertDialog.Builder(HotelViewActivity.this)
                            .setTitle(getString(R.string.sendquery))
                            .setMessage(getString(R.string.q1)+hotel_email+getString(R.string.q2)+hotel_name+" "+getString(R.string.helpline))
                            .setCancelable(true)
                            .setPositiveButton(getString(R.string.qry), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String smsnumber = hotel_phone_number;
                                    String smstxt = getString(R.string.yqry);

                                    Uri uri = Uri.parse("smsto:"+smsnumber);
                                    Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                                    intent.putExtra("sms_body", smstxt);
                                    startActivity(intent);
                                }
                            }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // do nothing
                        }
                    })
                            .setIcon(android.R.drawable.ic_dialog_info)
                            .show();
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

   /** public void getDataClick(View view) {

    }*/
}