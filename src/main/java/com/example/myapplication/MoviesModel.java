package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;



public class MoviesModel {

    ArrayList<Movie>results;
    @SerializedName("total_pages")
    String totalPages;
    @SerializedName("total_results")
    int  resultsNumber;
    public ArrayList<Movie> getMovies() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {this.results = results;}

    public void setTotalPages(String totalPages) {this.totalPages = totalPages;}

    public void setResultsNumber(int resultsNumber) {this.resultsNumber = resultsNumber;}

    public ArrayList<Movie> getResults() {
        return results;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public int getResultsNumber() {
        return resultsNumber;
    }
}
