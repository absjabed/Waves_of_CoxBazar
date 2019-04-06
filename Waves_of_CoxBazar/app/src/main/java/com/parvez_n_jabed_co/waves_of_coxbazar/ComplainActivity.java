package com.parvez_n_jabed_co.waves_of_coxbazar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapButtonGroup;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.parvez_n_jabed_co.waves_of_coxbazar.AlertSetup.AlertClass;
import com.parvez_n_jabed_co.waves_of_coxbazar.AlertSetup.AlertType;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class ComplainActivity extends AppCompatActivity {

    BootstrapEditText ETname, ETemail, ETphone, ETdescription;
    BootstrapButtonGroup type;
    BootstrapButton RBcomplain, RBbug, RBquery, RBsuggestion;
    String cmtype2 = null;
    LinearLayout layout; // In which layout we will add alert.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title_ixom2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_complain);

        ETname = (BootstrapEditText) findViewById(R.id.ETname);
        ETemail = (BootstrapEditText) findViewById(R.id.ETemail);
        ETdescription = (BootstrapEditText) findViewById(R.id.ETdescription);
        ETphone = (BootstrapEditText) findViewById(R.id.ETphone);
        type = (BootstrapButtonGroup) findViewById(R.id.radioGroupType);
        RBcomplain = (BootstrapButton) findViewById(R.id.RBcomplain);
        RBbug = (BootstrapButton) findViewById(R.id.RBbugreport);
        RBquery = (BootstrapButton) findViewById(R.id.RBquery);
        RBsuggestion = (BootstrapButton) findViewById(R.id.RBsuggestion);
        //alert = (BootstrapAlert) findViewById(R.id.dynamic_alert);

        layout = (LinearLayout)findViewById(R.id.alertLayout);


        RBcomplain.setOnCheckedChangedListener(new BootstrapButton.OnCheckedChangedListener() {
            @Override
            public void OnCheckedChanged(BootstrapButton bootstrapButton, boolean isChecked) {
                if (isChecked) {
                    cmtype2 = RBcomplain.getText().toString().trim();
                }
            }
        });
        RBsuggestion.setOnCheckedChangedListener(new BootstrapButton.OnCheckedChangedListener() {
            @Override
            public void OnCheckedChanged(BootstrapButton bootstrapButton, boolean isChecked) {
                if (isChecked) {
                    cmtype2 = RBsuggestion.getText().toString().trim();
                }
            }
        });
        RBbug.setOnCheckedChangedListener(new BootstrapButton.OnCheckedChangedListener() {
            @Override
            public void OnCheckedChanged(BootstrapButton bootstrapButton, boolean isChecked) {
                if (isChecked) {
                    cmtype2 = RBbug.getText().toString().trim();
                }
            }
        });
        RBquery.setOnCheckedChangedListener(new BootstrapButton.OnCheckedChangedListener() {
            @Override
            public void OnCheckedChanged(BootstrapButton bootstrapButton, boolean isChecked) {
                if (isChecked) {
                    cmtype2 = RBquery.getText().toString().trim();
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


    public void submitComplain(View view) {
        try {
            submitToServer(view);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void submitToServer(View v) throws JSONException {
        if(cmtype2 ==  null) {
        Toast.makeText(this, "Select any of the opinion types.", Toast.LENGTH_SHORT).show();
            AlertClass alert = new AlertClass(this,2500, AlertType.WARNING_ALERT,layout);
            alert.showAlert();
         }else{
            if (ETname.getText().toString() == null | ETname.getText().toString().isEmpty() | ETdescription.getText().toString() == null| ETdescription.getText().toString().isEmpty()| ETphone.getText().toString() == null|ETphone.getText().toString().isEmpty() ){
            Toast.makeText(this, "Fill up the required fildes.", Toast.LENGTH_SHORT).show();
                AlertClass alert = new AlertClass(this,2500, AlertType.DANGER_ALERT,layout);
                alert.showAlert();
        }else{

            final String ctype = cmtype2.trim();
            final String name = ETname.getText().toString().trim();
            final String description = ETdescription.getText().toString().trim();
            final String email = ETemail.getText().toString().trim();
            final String phone = ETphone.getText().toString().trim();

                //clearing UI components........
                cmtype2 = null;
                ETname.setText(null);
                ETdescription.setText(null);
                ETemail.setText(null);
                ETphone.setText(null);

        Toast.makeText(this, ctype+" "+name+" "+email+" "+description+" "+phone, Toast.LENGTH_SHORT).show();


            StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.COMPLAIN_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(ComplainActivity.this,response,Toast.LENGTH_LONG).show();
                            AlertClass alert = new AlertClass(ComplainActivity.this,2500, AlertType.SUCCESS_ALERT,layout);
                            alert.showAlert();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(ComplainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        }
                    }){
                @Override
                protected Map<String,String> getParams(){
                    Map<String,String> params = new HashMap<String, String>();
                    params.put(Config.KEY_COMPLAIN_TYPE,ctype);
                    params.put(Config.KEY_USER_NAME,name);
                    params.put(Config.KEY_USER_EMAIL,email);
                    params.put(Config.KEY_COMPLAIN,description);
                    params.put(Config.KEY_USER_PHONE,phone);
                    Log.d("test",params.get(Config.KEY_COMPLAIN_TYPE)+" "+ params.get(Config.KEY_USER_NAME)+" "+params.get(Config.KEY_USER_EMAIL)+" "+params.get(Config.KEY_USER_PHONE)+" "+params.get(Config.KEY_USER_PHONE));
                    return params;
                }

            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        }

        }
}
    }