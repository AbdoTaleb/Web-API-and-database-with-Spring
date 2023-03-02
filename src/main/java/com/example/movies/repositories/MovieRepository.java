package com.example.movies.repositories;


import com.example.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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

    Collection<Movie> findAllByName(String movieName);

//    @Modifying
//    @Query("update Movie s set s.characters = ?2 where s.id = ?1")
//    int updateMoviesCharacterById(int movieId, int characterId);




}