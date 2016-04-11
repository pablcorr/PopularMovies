package com.pablcorr.android.popularmovies;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by pablcorr on 4/7/2016.
 */
public class MovieDetails implements Serializable {

    public static final String EXTRA_MOVIE_DATA = "MovieDetails";
    private String title;
    private String poster_url;
    private String rating;
    private String Synopsis;
    private String releaseDate;
    private String thumbnail_url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_url() {
        return poster_url;
    }

    public void setPoster_url(String poster_url) {
        this.poster_url = poster_url;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSynopsis() {
        return Synopsis;
    }

    public void setSynopsis(String synopsis) {
        Synopsis = synopsis;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public MovieDetails (String movieJsonStr) {
        JSONObject movieInfo;

        try {
            movieInfo = new JSONObject(movieJsonStr);
            setPoster_url("http://image.tmdb.org/t/p/w185/" + movieInfo.getString("poster_path"));
            setTitle(movieInfo.getString("original_title"));
            setRating(movieInfo.getString("vote_average"));
            setSynopsis(movieInfo.getString("overview"));
            setReleaseDate(movieInfo.getString("release_date"));
            setThumbnail_url("http://image.tmdb.org/t/p/w185/" + movieInfo.getString("backdrop_path"));

        } catch (JSONException e) {
            Log.e("MovieDetails", "Error parsing JSON Object:" + e.toString(), e);
        }

    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }
}
