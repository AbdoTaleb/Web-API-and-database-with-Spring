package com.example.movies.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_franchise")
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "franchise_id")
    private int id;

    @Column(name = "franchise_name", length = 50, nullable = false)
    private String name;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Column(name = "franchise_description", length = 250, nullable = false)
    private String description;


    @OneToMany(mappedBy = "franchise")
    private Set<Movie> movies;


}
