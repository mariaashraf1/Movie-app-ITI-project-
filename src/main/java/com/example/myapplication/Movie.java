package com.example.myapplication;

public class Movie {
    private String id;
    private String title;
    private String overview;
    private String poster_path;
    private String release_date;
    private String backdrop_path;
    private float vote_average;
    private boolean isFavourite;

    public Movie() {

    }

    public Movie(String title, String release_date) {
        this.title = title;
        this.release_date = release_date;
    }

    public Movie(String title, String poster_path, String overview) {
        this.title = title;
        this.poster_path = poster_path;
        this.overview = overview;
    }

    public Movie(String id, String title, String overview, String poster_path, String release_date, String backdrop_path, float vote_average, boolean isFavourite) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.backdrop_path = backdrop_path;
        this.vote_average = vote_average;
        this.isFavourite = isFavourite;
    }

    public boolean isFavourite() {
        return isFavourite;
    }
    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {this.title = title;}

    public String getOverview() {return overview;}
    public void setOverview(String overview) {this.overview = overview;}

    public String getPoster_path() {return poster_path;}
    public void setPoster_path(String poster_path) {this.poster_path = poster_path;}

    public String getRelease_date() {return release_date;}
    public void setRelease_date(String release_date) {this.release_date = release_date;}

    public String getBackdrop_path() {return backdrop_path;}
    public void setBackdrop_path(String backdrop_path) {this.backdrop_path = backdrop_path;}

    public float getVote_average() {return vote_average;}
    public void setVote_average(float vote_average) {this.vote_average = vote_average;}

    public String getPosterUrl() {return poster_path;}
    public void setPosterUrl(String posterUrl) {this.poster_path = posterUrl;}


}
