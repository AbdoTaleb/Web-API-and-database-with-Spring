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

    @Column(name = "franchise_description", length = 250, nullable = false)
    private String description;


    @OneToMany(mappedBy = "franchise")
    private Set<Movie> movies;


}
