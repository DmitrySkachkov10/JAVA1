package by.dmitry_skachkov.projects.vote.core.dto;

import java.util.ArrayList;
import java.util.List;

public class Vote {
    private Artist artist;

    private List<Genre> genres = new ArrayList<>();

    private String about;

    public Vote() {
    }

    public Vote(Artist artist, List<Genre> genres, String about) {
        this.artist = artist;
        this.genres = genres;
        this.about = about;
    }


    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "artist=" + artist +
                ", genres=" + genres +
                ", about='" + about + '\'' +
                '}';
    }


}
