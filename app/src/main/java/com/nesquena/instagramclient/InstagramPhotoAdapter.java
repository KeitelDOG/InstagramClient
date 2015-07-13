package com.nesquena.instagramclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class InstagramPhotoAdapter extends ArrayAdapter<InstagramPhoto> {
    // What data do we need from the activity
    // Context, Data Source
    public InstagramPhotoAdapter(Context context, List<InstagramPhoto> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }

    // What our items looks
    // Use the template to display each photo

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        InstagramPhoto photo = getItem(position);
        // Check if we are using a recycled view, if not we need to inflate
        if (convertView == null) {
            // Create a new view for template
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }
        // Lookup the view for populating the data (image, caption)
        TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
        ImageView IvPhoto = (ImageView) convertView.findViewById(R.id.IvPhoto);
        // Insert the model data into each of the view items
        tvCaption.setText(photo.caption);
        // Clear out the imageView
        IvPhoto.setImageResource(0);
        // Insert the image using picasso
        Picasso.with(getContext()).load(photo.imageUrl).into(IvPhoto);
        // Return the created item as a view
        return convertView;

    }
}
