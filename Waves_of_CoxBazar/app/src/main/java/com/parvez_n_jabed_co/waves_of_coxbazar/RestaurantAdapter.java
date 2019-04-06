package com.parvez_n_jabed_co.waves_of_coxbazar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by PARVEZ on 07-Feb-17.
 */

public class RestaurantAdapter extends BaseAdapter {

    Context context;
    List<RowItem> rowItems;
/*
    RestaurantAdapter(Context context, List<RowItem> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }*/
private ImageLoader mImageLoader;


    public RestaurantAdapter(Context context, List<RowItem> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
        mImageLoader = CustomVolleyRequestQueue.getInstance(context).getImageLoader();
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }
    @Override

    public int getViewTypeCount() {

        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }


    /* private view holder class */
    private class ViewHolder {
        NetworkImageView hospital_pic;
        TextView hospital_name;
        TextView hospital_email;
        TextView hospital_mobile;
        //	Button hospital_btn;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.resturentitem, null);
            holder = new ViewHolder();

            holder.hospital_name = (TextView) convertView.findViewById(R.id.resturent_name);
            holder.hospital_pic = (NetworkImageView)convertView.findViewById(R.id.resturent_pic);
            holder.hospital_email = (TextView) convertView.findViewById(R.id.resturent_email);
            holder.hospital_mobile = (TextView) convertView.findViewById(R.id.resturent_mobile);
            //   holder.hospital_btn  = (Button) convertView.findViewById(R.id.button);
            RowItem row_pos = rowItems.get(position);

            mImageLoader.get(rowItems.get(position).getHospital_pic_id(), ImageLoader.getImageListener(holder.hospital_pic, R.drawable.loading, R.mipmap.ic_launcher));
           /* ImageLoader.ImageContainer imageContainer =  mImageLoader.get(rowItems.get(position).getHospital_pic_id(), ImageLoader.getImageListener(holder.hospital_pic, R.drawable.loading, R.mipmap.ic_launcher));
             imageContainer.getBitmap();
*/
            holder.hospital_pic.setImageUrl(rowItems.get(position).getHospital_pic_id(),mImageLoader);

            holder.hospital_name.setText(row_pos.getHospital_name());
            holder.hospital_email.setText(row_pos.getHospital_email());
            holder.hospital_mobile.setText(row_pos.getHospital_mobile());
		/*	holder.hospital_btn.setText("parvez");
			holder.hospital_btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Toast.makeText(context, "parvez btn" ,
							Toast.LENGTH_SHORT).show();

				}
			});*/

            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();
        }


        return convertView;
    }

}
