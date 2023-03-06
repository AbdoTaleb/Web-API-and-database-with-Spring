package com.example.movies.mappers;


import com.example.movies.model.dto.movie.MovieDTO;
import com.example.movies.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import com.example.movies.model.Character;
import com.example.movies.model.Franchise;
import org.mapstruct.Qualifier;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public abstract class MovieMapper {



//    @Mapping(target = "characters", source = "characters")
//    @Mapping(target = "franchise", source = "franchise")
//    //@Mapping(target = "characters", source = "characters")
      public abstract MovieDTO movieToMovieDto(Movie movie);

    public abstract Movie movieDtoToMovie(MovieDTO dto);
//
//    @Named("charactersToIds")
//    Set<Integer> map(Set<Character> source) {
//        if(source == null)
//            return null;
//        return source.stream()
//                .map(s -> s.getId()).collect(Collectors.toSet());
//    }
//
     public abstract Collection<MovieDTO> movieToMovieDtoGetAll(Collection<Movie> students);






}
