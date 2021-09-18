package com.kushnarev.kinopoisk_api.ApiClient;

import com.kushnarev.kinopoisk_api.pojo.Film;
import com.kushnarev.kinopoisk_api.pojo.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("movies/all/page/666/token/2c5e05554766b5f32bb8890e282fad9e")
    Call<JSONResponse> getMovies();

}
