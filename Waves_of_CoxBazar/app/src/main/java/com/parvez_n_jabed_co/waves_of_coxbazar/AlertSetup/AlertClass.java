package com.parvez_n_jabed_co.waves_of_coxbazar.AlertSetup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.parvez_n_jabed_co.waves_of_coxbazar.R;

/**
 * Created by abs pc1 on 2017-06-03.
 */

public class AlertClass {

    Context ctx;
    LinearLayout layout; //In which layout we have to add view
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    View child;

    private int ALERT_DISMISS_TIME_SEC;
    private String ALERT_TYPE;


    public int getALERT_DISMISS_TIME_SEC() {
        return ALERT_DISMISS_TIME_SEC;
    }

    public void setALERT_DISMISS_TIME_SEC(int ALERT_DISMISS_TIME_SEC) {
        this.ALERT_DISMISS_TIME_SEC = ALERT_DISMISS_TIME_SEC;
    }

    public String getALERT_TYPE() {
        return ALERT_TYPE;
    }

    public void setALERT_TYPE(String ALERT_TYPE) {
        this.ALERT_TYPE = ALERT_TYPE;
    }

    public AlertClass(Context ctx, int ALERT_DISMISS_TIME_SEC, String ALERT_TYPE,LinearLayout layout) {
        this.ctx = ctx;
        this.ALERT_DISMISS_TIME_SEC = ALERT_DISMISS_TIME_SEC;
        this.ALERT_TYPE = ALERT_TYPE;
        this.layout = layout;
    }

    public void showAlert(){
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

        if(ALERT_TYPE.equals("danger")){
            child = inflater.inflate(R.layout.danger_alert, null);
        }else if(ALERT_TYPE.equals("success")){
            child = inflater.inflate(R.layout.success_alert, null);
        }else if(ALERT_TYPE.equals("warning")){
            child = inflater.inflate(R.layout.warning_alert, null);
        }else if(ALERT_TYPE.equals("info")){
            child = inflater.inflate(R.layout.warning_alert, null);
        }else if(ALERT_TYPE.equals("primary")){
            child = inflater.inflate(R.layout.warning_alert, null);
        }

       layout.addView(child);
       child.postDelayed(new Runnable() { public void run() { child.setVisibility(View.GONE);
           layoutParams.weight = 0.0f;
           layout.setLayoutParams(layoutParams);} }, ALERT_DISMISS_TIME_SEC);
    }
}
