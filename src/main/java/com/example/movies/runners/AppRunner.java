package com.example.movies.runners;

import com.example.movies.model.Character;
import com.example.movies.model.Franchise;
import com.example.movies.model.Movie;
import com.example.movies.repositories.CharacterRepository;
import com.example.movies.repositories.FranchiseRepository;
import com.example.movies.repositories.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Set;



@Component
public class AppRunner implements ApplicationRunner {



    @Override
    @Transactional  // To handle the Lazy Loading
    public void run(ApplicationArguments args) throws Exception {

    }


}