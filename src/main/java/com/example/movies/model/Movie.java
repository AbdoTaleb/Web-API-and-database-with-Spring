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
    private Set<Character> characters;

    // Getters and setters
}