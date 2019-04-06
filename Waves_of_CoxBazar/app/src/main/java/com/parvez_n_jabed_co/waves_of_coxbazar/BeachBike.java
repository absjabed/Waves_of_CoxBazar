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
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BeachBike extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title_ixom2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_beach_bike);



        ListView beachbikeListView;

        final ArrayList<JetshiItem> arrayList;
        BaseAdapter adapter;




        beachbikeListView=(ListView) findViewById(R.id.beachbikeListView);
        arrayList=new ArrayList<JetshiItem>();

        arrayList.add(new JetshiItem("মো: আব্দুর রাজ্জাক","পিতাঃ মোঃ হাবিবুল্লাহ \n" +
                "ঠিকানাঃ ঝাউতলা,১১ নং ওয়ার্ড\n" +
                "মোবাইল : ০১৮২২৮৬৯৯৮৫"));
        arrayList.add(new JetshiItem("মো: খোরশেদ আলম","পিতাঃ আলাম ভাণ্ডারী \n" +
                "ঠিকানাঃ সমিতি পাড়া, ০১ নং ওয়ার্ড \n" +
                "মোবাইল : ০১৮৭২৩৭৯৮৮৮"));
        arrayList.add(new JetshiItem("সৈয়দ হোসেন","পিতাঃ আবুল বশর\n" +
                "ঠিকানাঃ পুর্ব হামজার ডেইল, খুরুশকুল \n" +
                "মোবাইল :"));
        arrayList.add(new JetshiItem("মো: রায়হান","পিতাঃ জিন্নাহ আলী \n" +
                "ঠিকানাঃ দক্ষিন কলাতলী\n" +
                "মোবাইল : ০১৮৫১৮৭৪৪০১"));
        arrayList.add(new JetshiItem("মোঃ আলম","পিতাঃ মোস্তাফিজুর রহমান  \n" +
                "ঠিকানাঃ মধ্যম বাহারছড়া \n" +
                "মোবাইল : ০১৮১৩১৪২১২৯"));
        arrayList.add(new JetshiItem("মোঃ হুমায়ন রশিদ ","পিতাঃ মৃত আমির হোসেন   \n" +
                "ঠিকানাঃ মধ্যম বাহারছড়া \n" +
                "মোবাইল : ০১৮৫৫৭৪৬৮২৬ "));
        //---------------------------------------------
        arrayList.add(new JetshiItem("জনাব অসীম কুমার মোহন্ত","পিতা- শ্রী অক্ষয় চন্দ্র মোহন্ত,\n" +
                "সাং- মালুমঘাট, কক্সবাজার। \t\n" +
                "মোবাইল :০১৮১৪-১২২৯২৩\n"));
        arrayList.add(new JetshiItem("জনাব মোঃ আনোয়ার ইসলাম হিরু","পিতা- মোঃ হাবিব উল্লাহ,\n" +
                "সাং- বাহারছড়া, কক্সবাজার। \t\n" +
                "মোবাইল :০১৭১৯-৩২৩১৬২\n"));
        arrayList.add(new JetshiItem("জনাব মোঃ রিয়াদ হোসেন রাসেল","পিতা- আলতাফ হোসেন,\n" +
                "সাং- বাহারছড়া, কক্সবাজার। \t\n" +
                "মোবাইল :০১৮৬৭-৯৬৪৭৭৭\n"));
        arrayList.add(new JetshiItem("জনাব মোঃ সোহেল,","পিতা- ওমর ফারুক,\n" +
                "সাং- দক্ষিণ বাহারছড়া, কক্সবাজার। \t\n" +
                "মোবাইল :০১৮১৫-১১৬১৬৪\n"));
        arrayList.add(new JetshiItem("জনাব ওমর শরীফ","পিতা- দিল মুহাম্মদ\n" +
                "সাং- দক্ষিণ বাহারছড়া, কক্সবাজার।\t\n" +
                "মোবাইল :০১৮২৬-৩০৩২১২\n"));
        arrayList.add(new JetshiItem("জনাব তৌহিদুল ইসলাম","পিতা- মৃত মোঃ শফিউল হক,\n" +
                "সাং- পশ্চিম বাহারছড়া, কক্সবাজার। \t\n" +
                "মোবাইল :০১৮৭৫-৫১১৫৪৫\n"));
        arrayList.add(new JetshiItem("জনাম মোঃ আব্দুল শুক্কুর","পিতা- শুরা মিয়া,\n" +
                "সাং- দক্ষিণ বাহারছড়া, কক্সবাজার।\t\n" +
                "মোবাইল :০১৮১৪-৭৭০২৬৩\n"));
        arrayList.add(new JetshiItem("জনাব মোঃ আলম উদ্দিন","পিতা- আব্দুল লতিফ খলিফা,\n" +
                "সাং- দক্ষিণ বাহারছড়া, কক্সবাজার।\t\n" +
                "মোবাইল :০১৮১১-৩৪৪৫৩২\n"));
        arrayList.add(new JetshiItem("জনাম মোঃ ফরিদুল আলম","পিতা- মোঃ লোকমান,\n" +
                "সাং- দক্ষিণ বাহারছড়া, কক্সবাজার।\t\n" +
                "মোবাইল :০১৮২৬-৩০৪০৪৫\n"));
        arrayList.add(new JetshiItem("জনাব আলীম উদ্দিন","পিতা- মৃত ফজলুল হক,\n" +
                "সাং- দক্ষিণ বাহারছড়া, কক্সবাজার।\t\n"));
        arrayList.add(new JetshiItem("জনাম মোঃ রাসেল","পিতা- আহম্মদ হোসেন\n" +
                "সাং- মোহাজের পাড়া, কক্সবাজার।\t\n" +
                "মোবাইল :০১৮৮১-২২১৬৯২\n"));
        arrayList.add(new JetshiItem("জনাম আব্দুল জব্বার","পিতা- মৃত হাজী ছোলাইমান\n" +
                "সাং- সমিতি পাড়া, কক্সবাজার।\t\n" +
                "মোবাইল :০১৮৩১-০৭৪০৪১\n"));
        arrayList.add(new JetshiItem("জনাব শাহাদাত হোসেন","পিতা- হাজ্বী আবু শামা,\n" +
                "সাং- চাউল বাজার, কক্সবাজার।\t\n" +
                "মোবাইল :০১৮৩৩-২৭২১৯৬\n"));
        arrayList.add(new JetshiItem("জনাম নাজিম উদ্দিন","পিতা- ফজলুল হক,\n" +
                "সাং- ছড়িরাপাড়া, পদুয়া, লোহাগাড়া, চট্টগ্রাম। \t\n" +
                "মোবাইল :০১৮১২-৩৬৯২৮৩\n"));
        arrayList.add(new JetshiItem("জনাব আব্দুল মালেক","পিতা- আবুল কাশেম,\n" +
                "সাং- ঝাউতলা গাড়ীর মাঠ, কক্সবাজার।\t\n" +
                "মোবাইল :০১৫৫৮-৮৪৪৩১৫\n"));


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

        beachbikeListView.setAdapter(adapter);


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
