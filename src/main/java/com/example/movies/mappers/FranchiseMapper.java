package com.example.movies.mappers;

import com.example.movies.model.dto.franchise.FranchiseDTO;

import com.example.movies.model.Franchise;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface FranchiseMapper {
    @Mapping(target = "movies", source = "movies")
    FranchiseDTO toFranchiseDto(Franchise franchise);

    Franchise toFranchise(FranchiseDTO dto);
}
