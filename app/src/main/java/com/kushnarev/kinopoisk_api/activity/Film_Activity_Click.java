package com.kushnarev.kinopoisk_api.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.kushnarev.kinopoisk_api.R;
import com.squareup.picasso.Picasso;

public class Film_Activity_Click extends AppCompatActivity {

    ActionBar actionBar;
    String Title,description,year,poster,rating,premiere_world;
    ImageView posterImage;
    TextView premiere, Year ,desc, kinopoisk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film___click);

        getData();

        premiere = findViewById(R.id.premiere);
        Year = findViewById(R.id.year);
        desc = findViewById(R.id.desc);
        kinopoisk = findViewById(R.id.kinopoisk);
        posterImage = findViewById(R.id.poster_image);

        Picasso.get().load( poster).into(posterImage);
        premiere.setText("Примьера: "+ premiere_world);
        Year.setText("Год: " + year);
        desc.setText(description);
        kinopoisk.setText("Рейтинг от Кинопоиск: "+rating);



        actionBar = getSupportActionBar();
        actionBar.setTitle(Title);

        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    private void getData() {
        Intent intent = getIntent();
        Title = intent.getStringExtra("Title");
        description = intent.getStringExtra("description");
        year = intent.getStringExtra("year");
        poster = intent.getStringExtra("poster");
        rating = intent.getStringExtra("rating");
        premiere_world = intent.getStringExtra("premiere_world");

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}