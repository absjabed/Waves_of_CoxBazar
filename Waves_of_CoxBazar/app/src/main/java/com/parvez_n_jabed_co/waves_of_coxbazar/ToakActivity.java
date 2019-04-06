package com.parvez_n_jabed_co.waves_of_coxbazar;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class ToakActivity extends AppCompatActivity  implements ExpandableListView.OnChildClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title_ixom2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_toak);

        final PizzaCatagory[] catagories = new PizzaCatagory[]{


                new PizzaCatagory("ইউনিভার্সেল ট্যুরিজম এন্ড ট্রাভেলস্",

                        new PizzaTopping("এম রেজাউল করিম\n" +
                                "মোবাইল: ০১৮১৮০৯৯০৮৯")),
                new PizzaCatagory("বাংলা ট্যুরস্",

                        new PizzaTopping("কারুজ্জামান ওবাইদুল\n" +
                                "মোবাইল : ০১৯১১৮৮৬১৯৯")),
                new PizzaCatagory("ট্রাভেল মার্কক এডভেঞ্চার এন্ড ট্যুরিজম",

                        new PizzaTopping("মিজানুর রহমান মিল্কি\n" +
                                "মোবাইল: ০১৯১১৮১৭১৬৭")),
                new PizzaCatagory("এঞ্জেল ট্যুরিজম এন্ড ট্রাভেল",

                        new PizzaTopping("আসাফ উদ দৌলা\n" +
                                "মোবাইল: ০১৮২৬৫৪০৯৩৬")),
                new PizzaCatagory("পিদিম ইভেন্ট ম্যানেজমেন্ট এন্ড ট্যুরিজম",

                        new PizzaTopping("মোহাম্মদ আরিফ\n" +
                                "মোবাইল : ০১৯১৫৪৫৮৩৬৭")),
                new PizzaCatagory("আইল্যান্ড ট্যুরিজম",

                        new PizzaTopping("জসিম উদ্দিন\n" +
                                "মোবাইল: ০১৮১৪১৪৯১৯৩")),
                new PizzaCatagory("ষ্টিম টার্চ ট্যুরস্",

                        new PizzaTopping("মোহাম্মদ আরকান\n" +
                                "মোবাইল: ০১৮১৮১৮৮৮০৩")),
                new PizzaCatagory("ইজি ওয়ে প্যাকেজ ট্যুরস্",

                        new PizzaTopping("ফোরকান জুয়েল\n" +
                                "মোবাইল: ০১৭১৯০৫৬৫৬৮")),
                new PizzaCatagory("ইউরেকা ট্যুরস্ এন্ড সার্ভিস ",

                        new PizzaTopping("ইকবাল হোসেন সাজ্জাদ\n" +
                                "মোবাইল: ০১৬১৪১০০৭০০")),
                new PizzaCatagory("স্বপ্নচূড়া ট্যুরস্",

                        new PizzaTopping("নূর মোহাম্মদ মনির\n" +
                                "মোবাইল: ০১৮১৯১০৯৬৮২।")),
                new PizzaCatagory("ট্রাভেল টিউন",
                        new PizzaTopping("বেলাল আবেদীন ভূট্টো\n" +
                                "মোবাইল :০১৮১৩৩৮৬১৯৫ ")),
                new PizzaCatagory("ফ্রিডম ট্যুরস্",
                        new PizzaTopping("কাজল মহাজন\n" +
                                "মোবাইল :০১৮১৪৪৭৬২৯৫ ")),
                new PizzaCatagory("সী ওয়ে প্যাকেজ ট্যুরস্",
                        new PizzaTopping("কামাল হোসেন খোকন\n" +
                                "মোবাইল :০১৬৭৩১১২৮২৩ ")),
                new PizzaCatagory("দেশবন্ধু ট্যুরস্",
                        new PizzaTopping("কাদের খাঁন\n" +
                                "মোবাইল : ০১৭১৪৯৭৮১৯৯")),
                new PizzaCatagory("লং বীচ ভিউ ট্যুরস্",
                        new PizzaTopping("মোহাম্মদ ফাহাদ\n" +
                                "মোবাইল : ০১৭১৭৯৬২৭৬১")),
                new PizzaCatagory("ট্রাভেল কেয়ার",
                        new PizzaTopping("এম.এ. হাসিব বাদল\n" +
                                "মোবাইল : ০১৮১৮১০৯৩৩৬")),
                new PizzaCatagory("সী হিলটপ ট্যুরস্ এন্ড ট্রাভেলস্",
                        new PizzaTopping("এস.এম. কিবরিয়া খাঁন\n" +
                                "মোবাইল :০১৭১৫৮৭৯১১৭ ")),
                new PizzaCatagory("গ্রীন হলিডেজ ট্যুরস্",
                        new PizzaTopping("বোরহান উদ্দিন\n" +
                                "মোবাইল :০১৯২২২৫৫৫৫০ ")),
                new PizzaCatagory("কক্স  কুইন ট্যুারিজম",
                        new PizzaTopping("কামরুল ইসলাম\n" +
                                "মোবাইল : ০১৭১১১১৭৮৪৩")),
                new PizzaCatagory("ফ্যান্টাসি ট্যুরস্ এন্ড ট্রাভেলস্",
                        new PizzaTopping("শাহনেওয়াজ গুংগু\n" +
                                "মোবাইল : ০১৭১৫৮৭৯১১৩")),
                new PizzaCatagory("গ্রীন ভিউ ট্যুরস্",
                        new PizzaTopping("ছৈয়দুল হক\n" +
                                "মোবাইল :০১৮১১৪২০০১২ ")),
                new PizzaCatagory("সী গ্রেট এন্টারটেইনমেন্ট এন্ড ট্যুারিজম",
                        new PizzaTopping("মফিজুর রহমান\n" +
                                "মোবাইল :০১৭১১১৪৮৬৫৪ ")),
                new PizzaCatagory("বীচ ট্যুারিজম নেটওয়ার্ক",
                        new PizzaTopping("মোঃ শফি উল্লাহ\n" +
                                "মোবাইল :০১৮১৯৫১২৫৯৫ ")),
                new PizzaCatagory("সী আইলেন্ড ট্যুারিজম",
                        new PizzaTopping("জিয়াউর রহমান\n" +
                                "মোবাইল : ০১৮১৮১২৯৩৯৪")),
                new PizzaCatagory("ফারসেম  ট্যুারিজম",
                        new PizzaTopping("আল্ আমিন বিশ্বাস তুষার\n" +
                                "মোবাইল :০১৯১৩১৪৮৯১৯ ")),
                new PizzaCatagory("রাঙ্গামাটি কক্স ট্যুারিজম",
                        new PizzaTopping("আনোয়ার কামাল\n" +
                                "মোবাইল : ০১৭১১৩১৫৩১৫")),
                new PizzaCatagory("ড্রীম ট্যুরিজম সার্ভিস",
                        new PizzaTopping("মোহাম্মদ শাহাজাহান\n" +
                                "মোবাইল :০১৮১৯৮৭১৪৫২ ")),
                new PizzaCatagory("ডিসকভারি প্যাকেজ ট্যুরস্",
                        new PizzaTopping("শাহ্ আলম\n" +
                                "মোবাইল : ০১৮১৯৫২৪৬৮০")),
                new PizzaCatagory("দি লিংক ট্যুারিজম",
                        new PizzaTopping("মোঃ কফিল উদ্দিন\n" +
                                "মোবাইল : ০১৫৫৬৯৮০৩০০")),
                new PizzaCatagory("স্বর্ণদীপ ট্যুারিজম",
                        new PizzaTopping("মিজানুর রহমান\n" +
                                "মোবাইল : ০১৮১৪৫০৫৭৬০")),
                new PizzaCatagory("গ্লোবাল ট্যুারিজম",
                        new PizzaTopping("ফেরদৌস রহমান\n" +
                                "মোবাইল : ০১৭৩২২১৩৫০৫")),
                new PizzaCatagory("ওয়াচ ট্যুারিজম",
                        new PizzaTopping("বেলাল উদ্দিনবে\n" +
                                "মোবাইল :০১৮১৩৬৭২১৩৪ ")),
                new PizzaCatagory("বু-পার্ল ট্যুারিজম",
                        new PizzaTopping("মোহাম্মদ সেলিম\n" +
                                "মোবাইল :০১৮১৭০৬৪৬৮২ ")),
                new PizzaCatagory("সীল্ক ওয়ে ট্যুারিজম",
                        new PizzaTopping("নাসিরুল ইসলাম\n" +
                                "মোবাইল :০১৮১৯০৮২৬৪৯ ")),
                new PizzaCatagory("নাইস ট্যুরস্ এন্ড ট্রাভেলস্",
                        new PizzaTopping("শাহিদুল্লাহ নাঈম\n" +
                                "মোবাইল :০১৮১৭২৪৪৪৫৫০ ")),
                new PizzaCatagory("মিলিনিয়াম ট্যুরস্",
                        new PizzaTopping("তহিদুল ইসলাম তোহা\n" +
                                "মোবাইল :০১৯১৩৯৯৬৮০৬ ")),
                new PizzaCatagory("গ্রীন সাফারি ট্যুরস্",
                        new PizzaTopping("ইফতেকার চেীধুরী\n" +
                                "মোবাইল : ০১৭১৫০০৬৪৬০")),
                new PizzaCatagory("সিটি গার্ডেন ট্যুরস্",
                        new PizzaTopping("মোঃ দিদার হোসেন\n" +
                                "মোবাইল :০১৭১৩৪০৯৭৯৭ ")),
                new PizzaCatagory("শৈবাল ট্যুারিজম",
                        new PizzaTopping("সাইফুল ইসলাম\n" +
                                "মোবাইল :০১৭১৯১৪৭০৩৭ ")),
                new PizzaCatagory("ওশান ভিউ ট্যুরস্",
                        new PizzaTopping("রফিকুল ইসলাম\n" +
                                "মোবাইল : ০১৭২৬২২৯৬২২")),
                new PizzaCatagory("ওভারং ট্যুরস্ এন্ড সার্ভিস",
                        new PizzaTopping("মোঃ আরিফুল রহমান\n" +
                                "মোবাইল : ০১৭৩৯৬৩৫৫৩২")),
                new PizzaCatagory("সেভেন ওয়াল্ডার্স ট্যুরস্",
                        new PizzaTopping("এম.এ মতিন\n" +
                                "মোবাইল : ০১৫৫৮৩৬৩৩১৬")),
                new PizzaCatagory("কক্স কিং ট্যুারিজম",
                        new PizzaTopping("মোঃ হাবিব উল্লাহ\n" +
                                "মোবাইল :০১৮১৩০৩৮১৮৩ ")),
                new PizzaCatagory("বুবীচ ট্যুারিজম",
                        new PizzaTopping("মনিবুর রহমান টিটু\n" +
                                "মোবাইল :০১৭১৯৩২৩২৩২ ")),
                new PizzaCatagory("রেনেঁসা ইকো ট্যুরিজম",
                        new PizzaTopping("মোঃ ফারুক আজম\n" +
                                "মোবাইল :০১৮১৩৩৮৬৩৯৫ ")),
                new PizzaCatagory("ট্যুর প্লাস",
                        new PizzaTopping("মোহাম্মদ ইদ্রিস\n" +
                                "মোবাইল :০১৭১২২৬৫৭৬১")),
                new PizzaCatagory("পার্ক ট্যুরস্",
                        new PizzaTopping("মোঃ আসলাম খাঁন\n" +
                                "মোবাইল :০১৮১৫১২০৬৭৭ ")),
                new PizzaCatagory("অনামিকা সী ট্যুরস",
                        new PizzaTopping("আবুল কালাম\n" +
                                "মোবাইল :০১৮১৪২৬১১০৫ ")),
                new PizzaCatagory("লাক্সারিয়া ট্যুারিজম",
                        new PizzaTopping("রিয়াজ উদ্দিন\n" +
                                "মোবাইল : ০১৮১৩৮৮২১৯১")),
                new PizzaCatagory("ছেড়াঁদ্বীপ ট্যুারিজম",
                        new PizzaTopping("আব্দুছ সাত্তার\n" +
                                "মোবাইল :০১৮১৫৫৪২২৪৪৪ ")),
                new PizzaCatagory("রিভার ভিউ ট্যুরস",
                        new PizzaTopping("মোঃ মুকিম খাঁন\n" +
                                "মোবাইল :০১৮১৪৮৯৯০৯ ")),
                new PizzaCatagory("বাংলাদেশ ট্রাভেলস্ প্ল্যানাস এন্ড লজিষ্ট্রিক",
                        new PizzaTopping("নার্গিস আহমেদ\n" +
                                "মোবাইল :০১৮২৯৭২৬২৭৪ ")),
                new PizzaCatagory("জয় ট্যুারিজম",
                        new PizzaTopping("আবুল মনসুর (মোঃ নুর)\n" +
                                "মোবাইল :০১৮১৫৪২০৮৯৭ ")),
                new PizzaCatagory("আই ট্যুরস",
                        new PizzaTopping("মোঃ ইসমাইল\n" +
                                "মোবাইল :০১৬৭৪১০৮৭৭৪ ")),
                new PizzaCatagory("মাই ট্যুরস্ লিঃ",
                        new PizzaTopping("মাহবুব হোসাইন সুমন\n" +
                                "মোবাইল :০১৭২৬৩২৬৩৬৩ ")),
                new PizzaCatagory("রাজধানী ট্যুারিজম",
                        new PizzaTopping("এস.এ. কাজল\n" +
                                "মোবাইল :০১৮১৯৬০৫৫৫৭ ")),
                new PizzaCatagory("এক্সাপ্লোর ট্যুরস্",
                        new PizzaTopping("রুপক মল্লিক\n" +
                                "মোবাইল :০১৮১২৪৪৯৬২০ ")),
                new PizzaCatagory("প্যাসিফিক ট্যুরস্ এন্ড লজিস্টিক",
                        new PizzaTopping("এনামুল হক মান্না\n" +
                                "মোবাইল : ০১৮২০০০৩৭৭৩")),
                new PizzaCatagory("ডলফিন ট্যুরিজম",
                        new PizzaTopping("নাছির উদ্দিন \n" +
                                "মোবাইল : ০১৮২৭৭২৩১৯২")),
                new PizzaCatagory("ইয়াহু ট্যুরস্ এন্ড ট্রাভেলস্",
                        new PizzaTopping("মোঃ পারভেজ সিকদার\n" +
                                "মোবাইল :০১৮৩০০৭১০৯১ ")),
                new PizzaCatagory("ফরহান এক্সপ্রেস ট্যুরিজম ",
                        new PizzaTopping("হোসাইন ইসলাম বাহাদুর\n" +
                                "মোবাইল : ০১৮১৮৭৭৪৩১১")),
                new PizzaCatagory("সী-হলিডে ট্যুরস্",
                        new PizzaTopping("এমাঃ নাছির উদ্দিন\n" +
                                "মোবাইল :০১৮১৯৮০০২৯৪ ")),
                new PizzaCatagory("বিজয় বাংলা ট্যুরস্",
                        new PizzaTopping("মোহাম্মদ তাহের\n" +
                                "মোবাইল : ০১৮১৭৭১৯৯২৬")),
                new PizzaCatagory("এভারগ্রীন ট্যুরিজম সার্ভিস",
                        new PizzaTopping("মোঃ শহীদুল ইসলাম\n" +
                                "মোবাইল :০১৮১২৪২৭০৩৪ ")),
                new PizzaCatagory("পিদিম ট্যুরিজম এন্ড ট্রাভেলস্",
                        new PizzaTopping("মোঃ জালাল উদ্দিন মিন্টু\n" +
                                "মোবাইল :০১৮১৯৬৩৬৩০৭ ")),
                new PizzaCatagory("এ,কে ট্যুর এন্ড ট্রাভেলস্",
                        new PizzaTopping("মোঃ খোরশেদ আলম\n" +
                                "মোবাইল : ০১৮২৪৪৭১২৬১")),
                new PizzaCatagory("গ্রীন প্রেরী ট্যুরিজম",
                        new PizzaTopping("আশরাফুল আরোফিন\n" +
                                "মোবাইল :০১৮৪৫৯৯৫৫৫৯ ")),
                new PizzaCatagory("রুপসী বাংলা ট্যুরিজম",
                        new PizzaTopping("মোঃ সাইফুল ইসলাম\n" +
                                "মোবাইল : ০১৭১৫২৫১৮৪৬")),
                new PizzaCatagory("ওশান গার্ল ট্যুরস্",
                        new PizzaTopping("ইয়াছিন আরাফাত\n" +
                                "মোবাইল :০১৮১২৫২১৪৮৮ ")),
                new PizzaCatagory("ড্রীম আইল্যান্ড ট্যুরস্",
                        new PizzaTopping("শিলা আক্তার\n" +
                                "মোবাইল :০১৮৬৩০৭১৯৩৬ ")),
                new PizzaCatagory("সোনারতরী ট্যুরিজম",
                        new PizzaTopping("মোঃ সাহেদুল ইসলাম\n" +
                                "মোবাইল :০১৮১৯৩১৩৭৭২ ")),
                new PizzaCatagory("ট্রাভেল বক্স",
                        new PizzaTopping("মোঃ জাহেদ\n" +
                                "মোবাইল : ০১৭৫৭০৭০৭০")),
                new PizzaCatagory("এ,কে  মিলিয়াম ট্যুরস্",
                        new PizzaTopping("মোঃ আবুল কালাম\n" +
                                "মোবাইল : ০১৫৫৮৪৫৩৭৬০")),
                new PizzaCatagory("গ্রীন বাংলাদেশ ট্যুরস্",
                        new PizzaTopping("হুমায়ন কবির আজাদ\n" +
                                "মোবাইল :০১৮২২৩৬৫৭২৫ ")),
                new PizzaCatagory("এস.এইচ.এম. ট্যুরস্ এন্ড ট্রাভেলস্",
                        new PizzaTopping("মোঃ হাফিজ উদ্ দৌল্লাহ\n" +
                                "মোবাইল :০১৮১৮৭৩৭৬৯৯ ")),
                new PizzaCatagory("ট্যুরিজম উইন্ডো",
                        new PizzaTopping("আবুল আলা মূঃ ফারুক\n" +
                                "মোবাইল :০১৮১৩৭৯৩২২০ ")),
                new PizzaCatagory("কমপোর্ট ট্যুরস এন্ড ইন্ডেন্ট",
                        new PizzaTopping("শফিউল আলাম\n" +
                                "মোবাইল :০১৮৪৫১০০০১ ")),
                new PizzaCatagory("কক্স ইম্পেরিয়া ট্যুরস",
                        new PizzaTopping("আজমল হুদা\n" +
                                "মোবাইল :০১৭৪৯০০৪৫৮৯ ")),
                new PizzaCatagory("রয়েল ট্যুরস এন্ড ট্রাভেলস",
                        new PizzaTopping("মোঃ সাইদ ফরহাদ\n" +
                                "মোবাইল : ০১৭৩৬০৩৫৫২৩")),
                new PizzaCatagory("এম.এম ট্যুরস এন্ড ট্রাভেলস",
                        new PizzaTopping("মোঃ ফারুক হোসাইন\n" +
                                "মোবাইল :০১৮১২৯৯৬৭৬৬ ")),
                new PizzaCatagory("কক্সবাংলা এন্টারপ্রাইজ এন্ড ট্রাভেলস",
                        new PizzaTopping("মোঃ শফিকুর রহমান\n" +
                                "মোবাইল :০১৮১২৯৯৬৯৪৯ ")),
                new PizzaCatagory("এমাজিং ট্রাভেলস",
                        new PizzaTopping("আলমগীর হোসেন বাবু\n" +
                                "মোবাইল :০১৮৫৬৮৮৪২৪১ ")),
                new PizzaCatagory("ডিলাইট হলিডেজ",
                        new PizzaTopping("রিয়াজ উদ্দিন তারেক\n" +
                                "মোবাইল : ০১৮২৩৫৩১৫৩৯")),
                new PizzaCatagory("নীলাচল ট্যুরস",
                        new PizzaTopping("মোঃ মিজানুর রহমান\n" +
                                "মোবাইল :০১৮১৯১৪১২৯৬ ")),
        };

        final ExpandableListView list =
                (ExpandableListView)findViewById(R.id.pizzasToak);

        list.setAdapter(new PizzaToppingsAdapter(catagories));
        list.setOnChildClickListener(this);

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
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        return false;
    }
}
