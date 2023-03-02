
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


    @Modifying
    @Query("update Character s set s.id = ?2 where s.id = ?1")
    int updateStudentsProfessorById(int studentId, int professorId);
    Collection<Character> findAllByName(String name);
}