package com.parvez_n_jabed_co.waves_of_coxbazar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TideActivity extends AppCompatActivity {
    private WebView wv1,wv2;
    ProgressDialog prDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title_ixom2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_tide);

        wv1 = (WebView) findViewById(R.id.webView);
        wv2 = (WebView) findViewById(R.id.webView1);

        wv1.getSettings().setJavaScriptEnabled(false);

        wv2.setWebViewClient(new MyBrowser());
        wv2.getSettings().setLoadsImagesAutomatically(true);
        wv2.getSettings().setJavaScriptEnabled(true);
        wv2.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv2.loadUrl("https://www.tide-forecast.com/locations/Cox-s-Bazaar/tides/latest");


        //new thread
        new LoadData().execute();
    }


    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

        }
    }

    private class  LoadData extends AsyncTask<Void,Void,Void> {
        //String primeDiv="msw-js-tide-list";
        //String html = new String();
        Document doc = null;
        Elements myDiv;

        @Override
        protected Void doInBackground(Void... params) {

            try {
/*
                doc2 = Jsoup.connect("https://www.tide-forecast.com/locations/Cox-s-Bazaar/tides/latest")
                        .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0")
                        .get();*/

                    //get total document
                doc = Jsoup.connect("http://magicseaweed.com/Kolatoli-Point-Surf-Report/4229/Tide/index.html")
                        .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0")
                        .timeout(100000)
                        .get();
               // doc = Jsoup.connect("https://www.tide-forecast.com/locations/Cox-s-Bazaar/tides/latest.html").timeout(100000).get();
            } catch (IOException e) {
                e.printStackTrace();
            }


            //select specific div
            myDiv = doc.select("div#msw-js-tide-list");
            //myDiv = doc.select("section.tide-events.not_in_print");
            //myDiv = doc.select("table");

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            prDialog = new ProgressDialog(TideActivity.this);
            prDialog.setMessage(getString(R.string.pleaseWait));
            prDialog.show();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void result) {

            super.onPostExecute(result);
            wv1.loadDataWithBaseURL(null,myDiv.outerHtml(),
                    "text/html", "utf-8", null);
            if (prDialog != null) {
                prDialog.dismiss();
            }

        }

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
