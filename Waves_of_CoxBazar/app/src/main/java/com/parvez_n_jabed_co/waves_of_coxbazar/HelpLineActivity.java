package com.parvez_n_jabed_co.waves_of_coxbazar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
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

public class HelpLineActivity extends AppCompatActivity {

    String arr[] = new String[14];
    private static final int REQUEST_CALL = 1;
    Intent callIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title_ixom2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_help_line);

        arr[0] = "01769690740";
        arr[1] = "01769690734";
        arr[2] = "01769690732";
        arr[3] = "01769690734";
        arr[4] = "01769690732";
        arr[5] = "01676840804";
        arr[6] = "01818466584";
        arr[7] = "01711102829";


        ListView contListView;

        final ArrayList<JetshiItem> arrayList;
        BaseAdapter adapter;




        contListView=(ListView) findViewById(R.id.contListView);
        arrayList=new ArrayList<JetshiItem>();

        arrayList.add(new JetshiItem("হট লাইন ১",
                        "\tমোবাইল : ০১৭৬৯৬৯০৭৪০"));
        arrayList.add(new JetshiItem("হট লাইন ২",
                        "\tমোবাইল : ০১৭৬৯৬৯০৭৩৪"));
        arrayList.add(new JetshiItem("হট লাইন ৩",
                        "\tমোবাইল : ০১৭৬৯৬৯০৭৩২"));
        arrayList.add(new JetshiItem("সহকারি পুলিশ সুপার","\tটুরিস্ট পুলিশ \n" +
                "\tমোবাইল : ০১৭৬৯৬৯০৭৩৪"));
        arrayList.add(new JetshiItem("অতিরিক্ত পুলিশ সুপার","\tটুরিস্ট পুলিশ \n" +
                "\tমোবাইল : ০১৭৬৯৬৯০৭৩২"));
        arrayList.add(new JetshiItem("সী সেইফ লাইফ গার্ড","\tজনাব ইমতিয়াজ আহমেদ\n" +
                "\tম্যানেজার \n" +
                "\tফোন- ০১৬৭৬-৮৪০৮০৪"));
        arrayList.add(new JetshiItem("রবি লাইফ গার্ড","\tজনাব সৈয়দ নুর\n" +
                "\tম্যানেজার\n" +
                "\tফোন- ০১৮১৮-৪৬৬৫৮৪"));
        arrayList.add(new JetshiItem("ইয়াছির লাইফ গার্ড","\tজনাব মোস্তফা কামাল \n" +
                "\tম্যানেজার\n" +
                "\tফোন- ০১৭১১-১০২৮২৯\n"));

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

        contListView.setAdapter(adapter);

contListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HelpLineActivity.this);
        alertDialogBuilder
                .setMessage(arr[position]+"\n"+getString(R.string.popUp))
                .setTitle(getString(R.string.permission))
                .setCancelable(true)
                .setPositiveButton(getString(R.string.doCall),
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                callIntent = new Intent(Intent.ACTION_CALL);
                                callIntent.setData(Uri.parse("tel:"+arr[position]));
                                if (ContextCompat.checkSelfPermission(HelpLineActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    ActivityCompat.requestPermissions(HelpLineActivity.this, new String[]{android.Manifest.permission.CALL_PHONE}, REQUEST_CALL);
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
});


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
