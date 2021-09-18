package com.kushnarev.kinopoisk_api.ApiClient;

import com.kushnarev.kinopoisk_api.pojo.Film;
import com.kushnarev.kinopoisk_api.pojo.JSONResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://api.kinopoisk.cloud/";


    private ApiInterface apiInterface;
    private static RetrofitClient INSTANCE;
    private Retrofit retrofit = null;

    public RetrofitClient(){

       retrofit = new Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static RetrofitClient getInstance(){
        if (null == INSTANCE){
            INSTANCE = new RetrofitClient();
        }
        return INSTANCE;
    }

    public Call<JSONResponse> getMovie(){
        return apiInterface.getMovies();
    }


}
