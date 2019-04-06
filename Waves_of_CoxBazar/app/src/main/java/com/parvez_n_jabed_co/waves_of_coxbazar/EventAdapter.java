package com.parvez_n_jabed_co.waves_of_coxbazar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by PARVEZ on 07-Feb-17.
 */

public class EventAdapter extends BaseAdapter {

    private final FruitItem[] items;

    EventAdapter(final FruitItem... items) {
        this.items = items;
    }

    private ViewGroup getViewGroup(
            final View reuse,
            final ViewGroup parent) {

        if(reuse instanceof ViewGroup) {
            return (ViewGroup)reuse;
        } else {
            final Context context = parent.getContext();
            final LayoutInflater inflater = LayoutInflater.from(context);

            final ViewGroup item = (ViewGroup)inflater.inflate(
                    R.layout.eventitem,
                    null);

            return item;
        }
    }

    public int getCount() {
        return items.length;
    }

    public Object getItem(final int index) {
        return items[index];
    }

    public long getItemId(final int index) {
        return index;
    }

    public View getView(
            final int index,
            final View reuse,
            final ViewGroup parent) {

        final ViewGroup view = getViewGroup(reuse, parent);
        final FruitItem item = items[index];

        final TextView text = ((TextView)view.findViewById(R.id.eventname));
        final ImageView image = ((ImageView)view.findViewById(R.id.eventicon));

        text.setText(item.name);
        //   image.setImageResource(item.image);
        image.setBackgroundResource(item.image);

        return view;
    }



}
