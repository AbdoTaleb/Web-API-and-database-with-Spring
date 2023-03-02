package com.example.movies.services;

import com.example.movies.model.Franchise;

import com.example.movies.repositories.FranchiseRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class FranchiseServiceImpl implements FranchiseService{

    private final Logger logger = LoggerFactory.getLogger(FranchiseServiceImpl.class);
    private final FranchiseRepository franchiseRepository;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository){
        this.franchiseRepository = franchiseRepository;
    }
    @Override
    public Franchise findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Franchise> findAll() {
        return null;
    }

    @Override
    public Franchise add(Franchise entity) {
        return null;
    }

    @Override
    public Franchise update(Franchise entity) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if(franchiseRepository.existsById(id)) {
            Franchise franchise = franchiseRepository.findById(id).get();
            franchise.getMovies().forEach(s -> s.setFranchise(null));
            franchise.getMovies().forEach(s -> s.setFranchise(null));
            franchiseRepository.delete(franchise);
        }
        else
            logger.warn("No Franchise exists with ID: " + id);

    }

    @Override
    public void delete(Franchise entity) {

    }
}
