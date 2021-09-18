package com.kushnarev.kinopoisk_api.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.kushnarev.kinopoisk_api.ApiClient.RetrofitClient;
import com.kushnarev.kinopoisk_api.R;
import com.kushnarev.kinopoisk_api.ViewModel.MovieViewModel;
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

    MovieViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.getMovie();

        movieViewModel.mutableLiveData.observe(this, new Observer<JSONResponse>() {
            @Override
            public void onChanged(JSONResponse jsonResponse) {
                filmList = new ArrayList<>(Arrays.asList(jsonResponse.getMovies()));
                putDataInToRecycleView(filmList);

            }
        });

    }

    private void putDataInToRecycleView(List<Film> filmList) {

        adapter = new MoviesAdapter(filmList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }


}