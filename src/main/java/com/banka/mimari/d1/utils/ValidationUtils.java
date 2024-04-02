package com.banka.mimari.d1.utils;

import com.banka.mimari.d1.entity.Animal;

public class ValidationUtils {
    public static void checkId(Integer id){
        if (id == null || id<0){
            System.out.println("zero");
        }
    }

    public static void checkAnimal(Animal animal){
        if (animal.getId() <0){
            System.out.println("id");
        }
        if (animal.getName() == null || animal.getName().isEmpty()){
            System.out.println("null");
        }
    }
}
