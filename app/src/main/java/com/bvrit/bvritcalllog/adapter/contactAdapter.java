package com.bvrit.bvritcalllog.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bvrit.bvritcalllog.R;
import com.bvrit.bvritcalllog.model.contact;

import java.util.List;

/**
 * Created by sushma on 13-10-2016.
 */

public class contactAdapter extends ArrayAdapter<contact> {
    public contactAdapter(Context context,  List<contact> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View returnView = convertView;
        if(returnView == null){
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            returnView = li.inflate(R.layout.contact_layout,null);
        }
        contact currentContact = getItem(position);

        TextView contactName = (TextView) returnView.findViewById(R.id.contact_name);
        contactName.setText(currentContact.getName());

        TextView contactNumber = (TextView) returnView.findViewById(R.id.contact_number);
        contactNumber.setText(currentContact.getNumber());

        ImageView contactImage = (ImageView) returnView.findViewById(R.id.contact_icon);
        contactImage.setImageResource(currentContact.getImageRes());

        return returnView;
    }
}
