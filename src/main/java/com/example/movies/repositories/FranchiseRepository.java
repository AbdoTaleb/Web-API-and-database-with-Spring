package com.example.movies.repositories;


import com.example.movies.model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseRepository extends JpaRepository<Franchise, Integer>  {
}
