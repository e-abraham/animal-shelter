package com.example.animalshelter.controller;

import com.example.animalshelter.model.Dog;
import com.example.animalshelter.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping(path="/dogs")
public class DogController {

    private final DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public String viewDogs(Model model){
        model.addAttribute("dogList", dogService.getDogs());
        return "dogs";
    }

    @PostMapping
    public @ResponseBody void registerDog(@RequestBody Dog dog){
        dogService.addDog(dog);
    }

    @DeleteMapping(path="{dogId}")
    public void removeDog(@PathVariable("dogId") Long dogId){
        dogService.deleteDog(dogId);
    }

    @PutMapping(path="{dogId}")
    public void updateDog(@PathVariable("dogId") Long dogId, @RequestParam(required=false) String name, @RequestParam(required=false) String gender, @RequestParam(required=false) String breed, @RequestParam(required=false) boolean sterilized, @RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate arrival){
        dogService.updateDog(dogId, name, gender, breed, sterilized, arrival);
    }

}
