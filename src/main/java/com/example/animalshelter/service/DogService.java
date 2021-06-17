package com.example.animalshelter.service;

import com.example.animalshelter.model.Dog;
import com.example.animalshelter.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service
public class DogService {

    private final DogRepository dogRepository;

    @Autowired
    public DogService(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    public List<Dog> getDogs(){
        return dogRepository.findAll();
    }

    public void addDog(Dog dog){
        Optional<Dog> dogOptional = dogRepository.findDogByName(dog.getName());
        if(dogOptional.isPresent()){
            throw new IllegalStateException("Dog already exists");
        }
        dogRepository.save(dog);
    }

    public void deleteDog(Long dogId){
        boolean exists = dogRepository.existsById(dogId);
        if(!exists){
            throw new IllegalStateException("Dog not found");
        }
        dogRepository.deleteById(dogId);
    }

    @Transactional
    public void updateDog(Long dogId, String name, String gender, String breed, boolean sterilized, LocalDate arrival){
        Dog dog = dogRepository.findById(dogId).orElseThrow(() -> new IllegalStateException("Dog not found"));
        Optional<Dog> dogOptional = dogRepository.findDogByName(name);
        if(dogOptional.isPresent()){
            throw new IllegalStateException("Name already exists");
        } else if(name != null && !dog.getName().equals(name)){
            dog.setName(name);
        }
//        if(age != 0 && dog.getAge() != age){
//            dog.setAge(age);
//        }
        if(gender != null && !dog.getGender().equals(gender)){
            dog.setGender(gender);
        }
        if(breed != null && !dog.getBreed().equals(breed)){
            dog.setBreed(breed);
        }
//        if(weight != 0 && dog.getWeight() != weight){
//            dog.setWeight(weight);
//        }
        if(sterilized != dog.isSterilized()){
            dog.setSterilized(sterilized);
        }
        if(arrival != null && !dog.getArrival().isEqual(arrival)){
            dog.setArrival(arrival);
        }
    }
}
