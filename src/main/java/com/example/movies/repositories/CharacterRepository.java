
package com.example.movies.repositories;


import com.example.movies.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;


@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
    @Query(value = "SELECT * FROM tb_character where character_name like %?%",
            nativeQuery = true)
    Collection<Character> findAllByName(String name);


}