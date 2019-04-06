package com.parvez_n_jabed_co.waves_of_coxbazar;


import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog loading;
    String json_response, internet = null;
    ImageButton imfb, iminsta, imtwitter, imweb;
    LinearLayout mainUILayout;
    Button imtvv;
    private static final int REQUEST_CALL = 1;
    Intent callIntent;
    TextView cityField, detailsField, currentTemperatureField, weatherIcon, updatedField;
    Typeface weatherFont;
    private LinearLayout mGallery;
    private int[] mImgIds;
    private LayoutInflater mInflater;
    private HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.testlayout);

        mainUILayout = (LinearLayout) findViewById(R.id.mainUILayout);


        if (!isNetworkAvailable()) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder
                    .setMessage(getString(R.string.noInternetMessage))
                    .setTitle(getString(R.string.noInternetTitle))
                    .setCancelable(false)
                    .setPositiveButton(getString(R.string.enableInternet),
                            new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int id) {
                                    Toast.makeText(MainActivity.this, getString(R.string.restartWave), Toast.LENGTH_LONG).show();
                                    finish();
                                    Intent dialogIntent = new Intent(Settings.ACTION_SETTINGS);
                                    dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    getBaseContext().startActivity(dialogIntent);
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
        } else {
            internet = "off";
            try {
                getData();
            } catch (Exception e) {
                Toast.makeText(this, getString(R.string.internet_error), Toast.LENGTH_SHORT).show();
            }
        }





        //------------Weather fields

        weatherFont = Typeface.createFromAsset(getAssets(), "fonts/weathericons-regular-webfont.ttf");

        cityField = (TextView) findViewById(R.id.city_field);
        updatedField = (TextView) findViewById(R.id.updated_field);
        detailsField = (TextView) findViewById(R.id.details_field);
        currentTemperatureField = (TextView) findViewById(R.id.current_temperature_field);
        weatherIcon = (TextView) findViewById(R.id.weather_icon);
        weatherIcon.setTypeface(weatherFont);


        mInflater = LayoutInflater.from(this);
        initData();
        initView();

        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.horigalary);
        final ObjectAnimator animator;

        animator = ObjectAnimator.ofInt(horizontalScrollView, "scrollX", mImgIds.length * 279);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setStartDelay(200);
        animator.setDuration(15000);

        animator.start();


        imfb = (ImageButton) findViewById(R.id.btnfb);
        iminsta = (ImageButton) findViewById(R.id.btninsta);
        imtwitter = (ImageButton) findViewById(R.id.btntwitter);
        imweb = (ImageButton) findViewById(R.id.btnweb);
        imfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent webviewIntent = new Intent(MainActivity.this, WebViewActivity.class);
                webviewIntent.putExtra("URL", "https://www.facebook.com/dcofficecoxsbazar/");
                startActivity(webviewIntent);

            }
        });


        iminsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent webviewIntent = new Intent(MainActivity.this, WebViewActivity.class);
                webviewIntent.putExtra("URL", "https://www.youtube.com");
                startActivity(webviewIntent);

            }
        });

        imtwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent webviewIntent = new Intent(MainActivity.this, WebViewActivity.class);
                webviewIntent.putExtra("URL", "http://www.coxsbazar.gov.bd");
                startActivity(webviewIntent);
            }
        });


        imweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showChangeLangDialog();

            }
        });


        horizontalScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                animator.setRepeatCount(0);
                animator.cancel();
                animator.setRepeatCount(ValueAnimator.INFINITE);
                animator.setStartDelay(6000);
                animator.start();
                return false;
            }
        });


        mGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGallery.getChildAt(1);

            }
        });


        GridView gridview = (GridView) findViewById(R.id.gridview);

        gridview.setAdapter(new FruitAdapter(

                new FruitItem("", R.drawable.transport),

                new FruitItem(getString(R.string.icon_transport), R.drawable.ico_transport),
                new FruitItem(getString(R.string.icon_hotel_motel), R.drawable.ico_hotel),
                new FruitItem("", R.drawable.transport),
                new FruitItem(getString(R.string.icon_tour_travels), R.drawable.ico_tourtravels),
                new FruitItem(getString(R.string.icon_restaurant), R.drawable.ico_resturent),
                new FruitItem(getString(R.string.icon_hospital), R.drawable.ico_hospital),
                new FruitItem(getString(R.string.icon_beach_activities), R.drawable.ico_beachactivities),
                new FruitItem(getString(R.string.icon_life_style), R.drawable.ico_lifestyle),
                new FruitItem(getString(R.string.icon_location), R.drawable.ico_location),
                new FruitItem(getString(R.string.icon_tidal_forcast), R.drawable.ico_tide),
                new FruitItem(getString(R.string.icon_impt_numbers), R.drawable.ico_safety),
                new FruitItem("", R.drawable.transport),
                new FruitItem(getString(R.string.icon_opinion), R.drawable.ico_complain),
                new FruitItem(getString(R.string.icon_helpline), R.drawable.ico_helpline),
                new FruitItem("", R.drawable.transport)
        ));


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                switch (position) {

                    case 1:

                        Intent intent1 = new Intent(MainActivity.this, TransportActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        getHotelList();
                        break;

                    case 4:
                        Intent intent7 = new Intent(MainActivity.this, ToakActivity.class);
                        startActivity(intent7);
                        break;
                    case 5:
                        //resturant
                        Intent intent_3 = new Intent(MainActivity.this, RestaurantActivity.class);
                        startActivity(intent_3);
                        break;
                    case 6:
                        //medical help
                        Intent intent = new Intent(MainActivity.this, HospitalActivity.class);
                        startActivity(intent);
                        break;
                    case 7:
                        //beach activity
                        Intent intent5 = new Intent(MainActivity.this, Event.class);
                        startActivity(intent5);
                        break;
                    case 8:
                        //lifestyle
                        Intent intent3 = new Intent(MainActivity.this, LifeStylenew.class);
                        startActivity(intent3);
                        break;
                    case 9:
                        //location
                        if (internet != null) {
                        Intent intent4 = new Intent(MainActivity.this, MapsActivityCurrentPlace.class);
                        startActivity(intent4);
                        break;
                        }else{
                            Toast.makeText(MainActivity.this, getString(R.string.internet_error), Toast.LENGTH_SHORT).show();
                            break;
                        }

                    case 10:
                        //Tide forecast
                        if (internet != null) {
                            Intent intent6 = new Intent(MainActivity.this, TideActivity.class);
                            startActivity(intent6);
                            break;
                        }else{
                            Toast.makeText(MainActivity.this, getString(R.string.internet_error), Toast.LENGTH_SHORT).show();
                            break;
                        }

                    case 11:
                        //sefty security numbers
                        Intent intent8 = new Intent(MainActivity.this, HelpLineActivity.class);
                        startActivity(intent8);
                        break;
                    case 13:
                        //Complain Activity
                        Intent intent9 = new Intent(MainActivity.this, ComplainActivity.class);
                        startActivity(intent9);
                        break;
                    case 14:
                        //Call centre
                       /* callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:01733373127"));
                        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                        } else {
                            startActivity(callIntent);
                        }*/
                        Intent intent10 = new Intent(MainActivity.this, HotlineActivity.class);
                        startActivity(intent10);
                        break;


                }
            }
        });


        TextView textView = (TextView) findViewById(R.id.tx);

        textView.setSelected(true);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSingleLine(true);

        Function.placeIdTask asyncTask = new Function.placeIdTask(new Function.AsyncResponse() {
            public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {

                cityField.setText(weather_city);
                updatedField.setText(weather_updatedOn);
                detailsField.setText(weather_description);
                currentTemperatureField.setText(weather_temperature);
                weatherIcon.setText(Html.fromHtml(weather_iconText));

            }
        });
        asyncTask.execute("21.453239", "91.979767"); //  asyncTask.execute("Latitude", "Longitude")


        SharedPreferences settings;
        settings = PreferenceManager.getDefaultSharedPreferences(this);
        Configuration config = getBaseContext().getResources().getConfiguration();

        String lang = settings.getString("LANG", "");
        if (! "".equals(lang) && ! config.locale.getLanguage().equals(lang)) {
            Locale locale = new Locale(lang);
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }


        CyclicTransitionDrawable ctd = new CyclicTransitionDrawable(new Drawable[] {
                getResources().getDrawable(R.drawable.mainui2),
                getResources().getDrawable(R.drawable.mainui3),
                getResources().getDrawable(R.drawable.mainui4),
                getResources().getDrawable(R.drawable.mainui6),
                getResources().getDrawable(R.drawable.mainui7)
        });

        mainUILayout.setBackground(ctd);

        ctd.startTransition(2500, 7500);

    }

    public void getHotelList() {
        try {
            if (json_response == null) {
                Toast.makeText(this, getString(R.string.internet_error), Toast.LENGTH_SHORT).show();
                Intent infoIntent = new Intent(MainActivity.this,Hotelmotel2Activity.class);
                startActivity(infoIntent);

            } else {
                Intent intent = new Intent(MainActivity.this, GroupListViewActivity.class);
                intent.putExtra("jsonData", json_response);
                startActivity(intent);
            }
        } catch (Exception ex) {
            Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show();
            loading.dismiss();
        }
    }

    private void getData() {
        // get all hotel data
        loading = ProgressDialog.show(this, getString(R.string.wait), getString(R.string.greet), false, false);

        String url = Config.HOTEL_DATA_URL.trim();

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response != null && !response.isEmpty()){
                    loading.dismiss();
                    json_response = response;
                }else{
                    loading.dismiss();
                    Toast.makeText(MainActivity.this, getString(R.string.internet_error), Toast.LENGTH_SHORT).show();
                }

                //showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.dismiss();
                        Toast.makeText(MainActivity.this, getString(R.string.internet_error), Toast.LENGTH_LONG).show();


                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    private void initData() {
        mImgIds = new int[]{R.drawable.longbeachl, R.drawable.hotelshaibal, R.drawable.oceanparadise, R.drawable.coxtoday, R.drawable.neshorgol, R.drawable.bestwestern, R.drawable.seagul, R.drawable.seaprinces
        };
    }

    private void initView() {
        mGallery = (LinearLayout) findViewById(R.id.id_gallery);
        int id;
        for (int i = 0; i < mImgIds.length; i++) {

            View view = mInflater.inflate(R.layout.activity_gallery_item,
                    mGallery, false);
            ImageView img = (ImageView) view.findViewById(R.id.id_index_gallery_item_image);

            img.setImageResource(mImgIds[i]);
            final TextView txt = (TextView) view
                    .findViewById(R.id.id_index_gallery_item_text);
            txt.setText("info "+i);
            mGallery.addView(view);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String temp = txt.getText().toString();

                    if (internet != null && json_response != null) {

                        if (temp.equals("info 0")) {
                            Intent intent = new Intent(MainActivity.this,HotelViewActivity.class);
                            intent.putExtra("hotel_id","1");
                            startActivity(intent);
                        }
                        if (temp.equals("info 1")) {
                            Intent intent = new Intent(MainActivity.this,HotelViewActivity.class);
                            intent.putExtra("hotel_id","2");
                            startActivity(intent);
                        }
                        if (temp.equals("info 2")) {
                            Intent intent = new Intent(MainActivity.this,HotelViewActivity.class);
                            intent.putExtra("hotel_id","3");
                            startActivity(intent);
                        }
                        if (temp.equals("info 3")) {
                            Intent intent = new Intent(MainActivity.this,HotelViewActivity.class);
                            intent.putExtra("hotel_id","4");
                            startActivity(intent);
                        }
                        if (temp.equals("info 4")) {
                            Intent intent = new Intent(MainActivity.this,HotelViewActivity.class);
                            intent.putExtra("hotel_id","5");
                            startActivity(intent);
                        }
                        if (temp.equals("info 5")) {
                            Intent intent = new Intent(MainActivity.this,HotelViewActivity.class);
                            intent.putExtra("hotel_id","6");
                            startActivity(intent);
                        }
                        if (temp.equals("info 6")) {
                            Intent intent = new Intent(MainActivity.this,HotelViewActivity.class);
                            intent.putExtra("hotel_id","7");
                            startActivity(intent);
                        }
                        if (temp.equals("info 7")) {
                            Intent intent = new Intent(MainActivity.this,HotelViewActivity.class);
                            intent.putExtra("hotel_id","8");
                            startActivity(intent);
                        }
                    }else{
                        Toast.makeText(MainActivity.this, getString(R.string.internet_error), Toast.LENGTH_SHORT).show();
                    }


/*                    Toast.makeText(getApplicationContext(), "" + txt.getText().toString(),
                            Toast.LENGTH_SHORT).show();*/


                }
            });
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CALL: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivity(callIntent);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void showChangeLangDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.language_dialog, null);
        dialogBuilder.setView(dialogView);

        final Spinner spinner1 = (Spinner) dialogView.findViewById(R.id.spinner1);

        dialogBuilder.setTitle(getResources().getString(R.string.lang_dialog_title));
        dialogBuilder.setMessage(getResources().getString(R.string.lang_dialog_message));
        dialogBuilder.setPositiveButton(getString(R.string.change), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                int langpos = spinner1.getSelectedItemPosition();
                switch (langpos) {
                    case 0: //English
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "en").apply();
                        setLangRecreate("en");
                        return;
                    case 1: //Bangla
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "bn").apply();
                        setLangRecreate("bn");
                        return;
                    default: //By default set to english
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "en").apply();
                        setLangRecreate("en");
                        return;
                }
            }
        });
        dialogBuilder.setNegativeButton(getString(R.string.cancleGps), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void setLangRecreate(String langval) {
        Configuration config = getBaseContext().getResources().getConfiguration();
        Locale locale = new Locale(langval);
        Locale.setDefault(locale);
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }


    public void onAbout(View view) {
        Intent infoIntent = new Intent(this,InfoActivity.class);
        startActivity(infoIntent);
    }
}
