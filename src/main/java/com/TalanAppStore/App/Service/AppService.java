package com.TalanAppStore.App.Service;

import com.TalanAppStore.App.Model.App;
import com.TalanAppStore.App.Repository.AppRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

import static java.lang.Boolean.TRUE;
import static net.bytebuddy.ClassFileVersion.of;

@Service
@Transactional
@Slf4j
public class AppService {
    private final AppRepository appRepo;

    @Autowired
    public AppService(AppRepository appRepo) {
        this.appRepo = appRepo;
    }

    public App create(App app) {
        log.info("Saving new app : {}, app.getName())");
       // app.setImageUrl(setAppImageUrl());
        return appRepo.save(app);
    }

    public Collection<App> list(int limit) { //findAllapps
        log.info("Fetching all apps");
        return appRepo.findAll(PageRequest.of(0, limit)).toList();

    }

    public App findAppById(Long id) {
        log.info("Fetching app by id {}: ", id);
        return appRepo.findById(id).get();


    }

    public App update(App app){
        log.info("Updating app: {}",app.getName());
        return appRepo.save(app);


    }

    public Boolean delete(Long id){
        log.info("deleting app by ID : {}",id);
       appRepo.deleteById(id);
        return TRUE;

    }


    private String setAppImageUrl() {
        return null;
    }


}
