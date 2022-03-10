package com.TalanAppStore.App.Controller;


import com.TalanAppStore.App.Model.App;
import com.TalanAppStore.App.Service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AppController {

    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    // Get all apps
    @GetMapping("/app")
    public ResponseEntity<List<App>> getAllApps() {

        List<App> apps = (List<App>) appService.list(10);

        return new ResponseEntity<>(apps, HttpStatus.OK);


    }
    //Get app by Id

    @GetMapping("/find/{id}")
    public ResponseEntity<App> getAppById(@PathVariable("id") Long id) {
        App app = appService.findAppById(id);
        return new ResponseEntity<>(app, HttpStatus.OK);
    }

    //Insert app
    @PostMapping("/add")
    public ResponseEntity<App> addApp(@RequestBody App app) {
        App newApp = appService.create(app);
        return new ResponseEntity<>(newApp, HttpStatus.CREATED);
    }


    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<App> updateApp(@RequestBody App app) {
        App updateApp = appService.update(app);
        return new ResponseEntity<>(updateApp, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteApp(@PathVariable("id") Long id) {
        appService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

