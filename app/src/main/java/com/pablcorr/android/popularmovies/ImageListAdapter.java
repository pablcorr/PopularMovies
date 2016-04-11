package com.pablcorr.android.popularmovies;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by pablcorr on 4/4/2016.
 */
public class ImageListAdapter extends ArrayAdapter {

    private Context context;

    public ImageListAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId, new ArrayList<MovieDetails>());
        this.context = context;
    }

    private final String LOG_TAG = ImageListAdapter.class.getSimpleName();

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = (ImageView) convertView;
        if (imageView == null) {
            imageView = new ImageView(context);
        }

        MovieDetails movie = (MovieDetails) getItem(position);
        String url = movie.getPoster_url();

        Picasso.with(context)
                .load(url)
                .resize(525, 700)
                .into(imageView);

        return imageView;
    }
}
