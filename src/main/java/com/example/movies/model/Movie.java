package com.example.movies.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;
    @Column(name = "movie_title", length = 50, nullable = false)
    private String title;

    @Column(name = "movie_genre", length = 50)
    private String genre;

    @Column(name = "movie_release_date", length = 50, nullable = false)
    private int release_date;

    @Column(name = "movie_director", length = 50)
    private String director;

    @Column(name = "movie_poster_url", length = 200, nullable = false)
    private String poster_url;

    @Column(name = "movie_trailer", length = 200, nullable = false)
    private String trailer;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    @ManyToMany
    @JoinTable(
            name = "tb_movie_character",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    private Set<Character> characters;

    public Movie() {
    }

    public Movie(String title, String genre, int release_date, String director, String poster_url, String trailer) {
        this.title = title;
        this.genre = genre;
        this.release_date = release_date;
        this.director = director;
        this.poster_url = poster_url;
        this.trailer = trailer;
    }

// Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRelease_date() {
        return release_date;
    }

    public void setRelease_date(int release_date) {
        this.release_date = release_date;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPoster_url() {
        return poster_url;
    }

    public void setPoster_url(String poster_url) {
        this.poster_url = poster_url;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", release_date=" + release_date +
                ", director='" + director + '\'' +
                ", poster_url='" + poster_url + '\'' +
                ", trailer='" + trailer + '\'' +
                ", franchise=" + franchise +
                ", characters=" + characters +
                '}';
    }
}