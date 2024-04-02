package com.banka.mimari.d1.controller;

import com.banka.mimari.d1.entity.Animal;
import com.banka.mimari.d1.utils.ValidationUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals;

    public void init(){
        animals = new HashMap<>();
        animals.put(1, new Animal(1, "maymun"));
    }

    @GetMapping

    public List<Animal> getAnimals(){
        System.out.println("---get all triggered----");
        return new ArrayList<>(this.animals.values());
    }

    @GetMapping(path = "/{id}")
    public Animal get(@PathVariable("id") Integer id){
        System.out.println("---get by ıd -----");
        ValidationUtils.checkId(id);
        return animals.get(id);
    }

    @PostMapping
    public void addAnimal(@RequestBody Animal animal) {
        ValidationUtils.checkAnimal(animal);
        this.animals.put(animal.getId(),animal);
    }

    @PutMapping(path = "/{id}")
    public Animal updateAnimal(@PathVariable("id") Integer existingRecordId, @RequestBody Animal newAnimal){
        ValidationUtils.checkAnimal(newAnimal);
        this.animals.replace(existingRecordId, newAnimal);
        return this.animals.get(existingRecordId);
    }

    @DeleteMapping(path = "/{id}")
    public void  deleteAnimal(@PathVariable Integer id){
        this.animals.remove(id);
    }

}
