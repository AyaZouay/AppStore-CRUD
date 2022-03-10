package com.TalanAppStore.App.Controller;
import com.TalanAppStore.App.Model.App;
import com.TalanAppStore.App.Model.Developer;

import com.TalanAppStore.App.Service.DeveloperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class DeveloperController {


    private final DeveloperService DeveloperService;

    public DeveloperController(DeveloperService DeveloperService) {
        this.DeveloperService = DeveloperService;
    }

    @GetMapping("/developers/all")
    public ResponseEntity<List<Developer>> getAllDevelopers() {

        List<Developer> Developers = (List<Developer>) DeveloperService.list(10);

        return new ResponseEntity<>(Developers, HttpStatus.OK);


    }


    //Get developer by Id

    @GetMapping("/developers/find/{id}")
    public ResponseEntity<Developer> getDeveloperById(@PathVariable("id") Long id) {
        Developer Developer = DeveloperService.findDeveloperById(id);
        return new ResponseEntity<>(Developer, HttpStatus.OK);
    }

    //Insert Developer
    @PostMapping("/developers/add")
    public ResponseEntity<Developer> addDeveloper(@RequestBody Developer Developer) {
        Developer newDeveloper = DeveloperService.create(Developer);
        return new ResponseEntity<>(newDeveloper, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/developers/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Developer> updateDeveloper(@RequestBody Developer Developer) {
        Developer updateDeveloper = DeveloperService.update(Developer);
        return new ResponseEntity<>(updateDeveloper, HttpStatus.OK);

    }

    @DeleteMapping("/developers/delete/{id}")
    public ResponseEntity<?> deleteDeveloper(@PathVariable("id") Long id) {
        DeveloperService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
