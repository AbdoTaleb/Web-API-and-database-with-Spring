package com.example.movies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
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
    private String gender;

    @Column(name = "character_picture_url", length = 250, nullable = false)
    private String picture_url;

    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies;

    public Character() {

    }

    public Character(String name, String alias, String gender, String picture_url) {
        this.name = name;
        this.alias = alias;
        this.gender = gender;
        this.picture_url = picture_url;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}