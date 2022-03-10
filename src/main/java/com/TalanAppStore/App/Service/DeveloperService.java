package com.TalanAppStore.App.Service;


import com.TalanAppStore.App.Model.Developer;
import com.TalanAppStore.App.Repository.DeveloperRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

import static java.lang.Boolean.TRUE;

@Service
@Transactional
@Slf4j
public class DeveloperService {
    private final DeveloperRepository DeveloperRepo;

    @Autowired
    public DeveloperService(DeveloperRepository DeveloperRepo) {
        this.DeveloperRepo = DeveloperRepo;
    }

    public Developer create(Developer Developer) {
        log.info("Saving new Developer : {}, Developer.getName())");
        return DeveloperRepo.save(Developer);
    }

    public Collection<Developer> list(int limit) { //findAllDevelopers
        log.info("Fetching all Developers");
        return DeveloperRepo.findAll(PageRequest.of(0, limit)).toList();

    }

    public Developer findDeveloperById(Long id) {
        log.info("Fetching Developer by id {}: ", id);
        return DeveloperRepo.findById(id).get();


    }

    public Developer update(Developer Developer){
        
        return DeveloperRepo.save(Developer);


    }

    public Boolean delete(Long id){
        log.info("deleting Developer by ID : {}",id);
        DeveloperRepo.deleteById(id);
        return TRUE;

    }







}
