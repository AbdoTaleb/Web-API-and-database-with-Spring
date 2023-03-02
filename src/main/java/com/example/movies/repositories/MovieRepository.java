package com.example.movies.repositories;


import com.example.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {




//    @Query("select s from Movie s where s.title like %?1%")
//    Optional<Set<Movie>> findAllByTitle(String title);




}