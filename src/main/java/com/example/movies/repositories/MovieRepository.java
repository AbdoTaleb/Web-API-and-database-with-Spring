package com.example.movies.repositories;


import com.example.movies.model.Movie;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {




//    @Query("select s from Movie s where s.title like %?1%")
//    Optional<Set<Movie>> findAllByTitle(String title);

    @Modifying
    @Query("update Movie s set s.franchise.id = ?2 where s.id = ?1")
    int updateMoviesFranchiseById(int movieId, int franchiseId);


//    @Modifying
//    @Query(value = "insert into tb_movie_character (movie_id,character_id) VALUES (:movie_id,:character_id)", nativeQuery = true)
//    @Transactional
//    void updateMoviesCharacterById(@Param("movie_id") int movie_id, @Param("character_id") int character_id);


    Collection<Movie> findAllByTitle(String title);






}