package com.example.movies.runners;

import com.example.movies.repositories.MovieRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    private final MovieRepository movieRepository;

    public AppRunner(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        System.out.println(movieRepository
//                .findById(1).get());
    }
}