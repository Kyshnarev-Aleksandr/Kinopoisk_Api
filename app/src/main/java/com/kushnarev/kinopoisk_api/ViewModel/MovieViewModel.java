package com.kushnarev.kinopoisk_api.ViewModel;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kushnarev.kinopoisk_api.ApiClient.RetrofitClient;
import com.kushnarev.kinopoisk_api.activity.MainActivity;
import com.kushnarev.kinopoisk_api.pojo.JSONResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {

    public MutableLiveData<JSONResponse> mutableLiveData = new MutableLiveData<>();

    public void getMovie(){

        RetrofitClient.getInstance().getMovie().enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                mutableLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });


    }


}
