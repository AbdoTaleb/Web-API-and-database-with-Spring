package com.example.movies.repositories;


import com.example.movies.model.Character;
import com.example.movies.model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface FranchiseRepository extends JpaRepository<Franchise, Integer>  {

//    @Query(value = "SELECT * FROM tb_character where character_name like %?%",
//            nativeQuery = true)
//    Collection<Character> findAllByName(String name);
}
