package com.kushnarev.kinopoisk_api.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.kushnarev.kinopoisk_api.ApiClient.RetrofitClient;
import com.kushnarev.kinopoisk_api.R;
import com.kushnarev.kinopoisk_api.adapter.MoviesAdapter;
import com.kushnarev.kinopoisk_api.pojo.Film;
import com.kushnarev.kinopoisk_api.pojo.JSONResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MoviesAdapter adapter;
    List<Film> filmList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        RetrofitClient.getInstance().getMovie().enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body();
                filmList = new ArrayList<>(Arrays.asList(jsonResponse.getMovies()));

                putDataInToRecycleView(filmList);

            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "оооошшшииибкааааа" + t, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void putDataInToRecycleView(List<Film> filmList) {

        adapter = new MoviesAdapter(filmList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }


}