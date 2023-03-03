package com.example.movies.repositories;


import com.example.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {





    // Find movie by its title
//    @Query(value = "SELECT * FROM tb_movie where movie_title like %?%",
//            nativeQuery = true)
//    Set<Movie> findAllByFirstName(String title);

    @Modifying
    @Query("update Movie s set s.franchise.id = ?2 where s.id = ?1")
    int updateMoviesFranchiseById(int movieId, int franchiseId);



}