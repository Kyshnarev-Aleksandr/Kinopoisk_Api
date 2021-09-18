package com.kushnarev.kinopoisk_api.pojo;

public class Film {

    private String title;
    private String description;
    private String year;
    private String poster;
    private String Kinopoisk_votes;
    private String premiere_world;
    private String id;
    private String rating_kinopoisk;

    public String getRating_kinopoisk() {
        return rating_kinopoisk;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getKinopoisk_votes() {
        return Kinopoisk_votes;
    }

    public String getPremiere_world() {
        return premiere_world;
    }

    public String getDescription() {
        return description;
    }

    public String getYear() {
        return  year;
    }

    public String getPoster() {
        return poster;
    }

}
