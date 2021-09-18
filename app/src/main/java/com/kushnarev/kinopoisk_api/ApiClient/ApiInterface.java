package com.kushnarev.kinopoisk_api.ApiClient;

import com.kushnarev.kinopoisk_api.pojo.Film;
import com.kushnarev.kinopoisk_api.pojo.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("movies/all/page/666/token/4652a1a2d4f964fb228700eb68c27ac6")
    Call<JSONResponse> getMovies();

}
