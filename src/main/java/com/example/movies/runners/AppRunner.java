package com.example.movies.runners;

import com.example.movies.model.Movie;
import com.example.movies.repositories.MovieRepository;
import jakarta.transaction.Transactional;
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
    @Transactional  // To handle the Lazy Loading
    public void run(ApplicationArguments args) throws Exception {
//        System.out.println(movieRepository
//                .findById(2).get());
        Movie newMovie = new Movie("Captain America: Civil War 222", "Action",
                2016, "Anthony Russo",
                "https://m.media-amazon.com/images/M/MV5BMjQ0MTgyNjAxMV5BMl5BanBnXkFtZTgwNjUzMDkyODE@._V1_SX300.jpg",
                "https://www.youtube.com/watch?v=dKrVegVI0Us");
        movieRepository.save(newMovie);
        System.out.println("ID " + newMovie.getId());

    }
}