package com.parvez_n_jabed_co.waves_of_coxbazar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abs pc1 on 2017-05-19.
 */

public class HotelsAdapter extends ArrayAdapter {
    List list = new ArrayList();

    public HotelsAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(Hotels object)
    {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {

        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row = convertView;
        HotelHolder hotelHolder;
        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            hotelHolder = new HotelHolder();
            //hotelHolder.tx_id = row.findViewById(R.id.tx_id);
            hotelHolder.tx_hotel_name =(TextView) row.findViewById(R.id.txt_hotel_name);
           // hotelHolder.tx_hotel_logo_name =(TextView) row.findViewById(R.id.logoname); <= will be used for logo image
            hotelHolder.tx_hotel_email =(TextView) row.findViewById(R.id.txt_hotel_email);
            hotelHolder.tx_hotel_phone_number =(TextView) row.findViewById(R.id.txt_hotel_phone);
          //  hotelHolder.tx_status =(TextView) row.findViewById(R.id.status); <= for status of hotel;
            row.setTag(hotelHolder);
        }else{
            hotelHolder = (HotelHolder) row.getTag();
        }

        Hotels hotels = (Hotels)this.getItem(position);
        hotelHolder.tx_hotel_name.setText(hotels.getHotel_name());
        hotelHolder.tx_hotel_email.setText(hotels.getHotel_email());
        hotelHolder.tx_hotel_phone_number.setText(hotels.getHotel_phone_number());

        return row;
    }

    static class HotelHolder{
        TextView tx_id, tx_hotel_name, tx_hotel_logo_name, tx_hotel_email, tx_hotel_phone_number, tx_status;
    }
}
