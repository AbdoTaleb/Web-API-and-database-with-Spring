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

    private final MovieRepository movieRepository;
    private final CharacterRepository characterRepository;
    private final FranchiseRepository franchiseRepository;

    public AppRunner(MovieRepository movieRepository, CharacterRepository characterRepository, FranchiseRepository franchiseRepository) {
        this.movieRepository = movieRepository;
        this.characterRepository = characterRepository;
        this.franchiseRepository = franchiseRepository;

    }

    @Override
    @Transactional  // To handle the Lazy Loading
    public void run(ApplicationArguments args) throws Exception {
//        System.out.println(movieRepository
//                .findById(2).get());
//        Movie newMovie = new Movie("Captain America: Civil War 222", "Action",
//                2016, "Anthony Russo",
//                "https://m.media-amazon.com/images/M/MV5BMjQ0MTgyNjAxMV5BMl5BanBnXkFtZTgwNjUzMDkyODE@._V1_SX300.jpg",
//                "https://www.youtube.com/watch?v=dKrVegVI0Us");
//        movieRepository.save(newMovie);
//        System.out.println("ID " + newMovie.getId());
//        update();
//        delete();

        //System.out.println(movieRepository.findAll());
        //movieRepository.deleteById(66);
//        Movie m;
//        m = movieRepository.findById(69).get();
//        movieRepository.delete(m);
//        franchiseRepository.deleteById(1);



    }

    public void addMovie(){
        Movie newMovie = new Movie("Captain America: Civil War 222", "Action",
                2016, "Anthony Russo",
                "https://m.media-amazon.com/images/M/MV5BMjQ0MTgyNjAxMV5BMl5BanBnXkFtZTgwNjUzMDkyODE@._V1_SX300.jpg",
                "https://www.youtube.com/watch?v=dKrVegVI0Us");
        movieRepository.save(newMovie);
    }
    public void update() {
        System.out.println("Updating Movie 67 with fran 38");
        int result = movieRepository.updateMoviesFranchiseById(68,38);

    }

    public void delete(){
        movieRepository.deleteById(68);
    }

}