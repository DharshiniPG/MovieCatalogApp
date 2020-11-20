package com.example.moviecatalogapp.services;


import com.example.moviecatalogapp.modal.Movies;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String BASE_URL = "https://api.tvmaze.com/shows/11/";
    @GET("episodes")
    Observable<List<Movies>> getMoviesList();
}
