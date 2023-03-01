package com.example.movies.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_character")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private int id;
    @Column(name = "character_name", length = 50, nullable = false)
    private String name;

    @Column(name = "character_alias", length = 50)
    private String alias;

    @Column(name = "character_gender", length = 50, nullable = false)
    private int gender;

    @Column(name = "movie_director", length = 50)
    private String director;

    @Column(name = "character_picture_url", length = 200, nullable = false)
    private String picture_url;

    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies;

     // Getters and setters
}
