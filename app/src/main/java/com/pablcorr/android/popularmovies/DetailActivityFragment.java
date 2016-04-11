package com.pablcorr.android.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    private MovieDetails movieDetails;

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        // The detail Activity called via intent.  Inspect the intent for movie data.
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra(MovieDetails.EXTRA_MOVIE_DATA)) {
            movieDetails = (MovieDetails) intent.getSerializableExtra(MovieDetails.EXTRA_MOVIE_DATA);

            ((TextView) rootView.findViewById(R.id.item_movie_title_textview))
                    .setText(movieDetails.getTitle());

            ((TextView) rootView.findViewById(R.id.item_movie_synopsis_textview))
                    .setText(movieDetails.getSynopsis());

            ((TextView) rootView.findViewById(R.id.item_movie_release_date_textview))
                    .setText(movieDetails.getReleaseDate());

            ((TextView) rootView.findViewById(R.id.item_movie_rating_textview))
                    .setText(movieDetails.getRating());

            Picasso.with(getActivity())
                    .load(movieDetails.getThumbnail_url())
                    .resize(1000, 560)
                    .into((ImageView) rootView.findViewById(R.id.item_movie_poster_imageview));

        }

        return rootView;
    }
}
