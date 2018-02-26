package com.company;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class PetStore {
    private List<Pet> pets = new LinkedList();

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Pet> getPets() {
        return this.pets;
    }

    public PetStore() {}

    public  PetStore (List<Pet> pets){
        this.pets = pets;

    }

    public void addPet(Pet addPet) {
        pets.add(addPet);
    }



    public List<Pet> sortByFoodType() {
        pets.sort(Comparator.comparing(Pet :: getFoodTypes));
        return pets;
    }

    public List<Pet> sortByNumberOfFood() {
        pets.sort(Comparator.comparing(Pet :: getNumberOfFood));
        return pets;
    }

    public List<Pet> searchPetByType(Types typeToFind){
        List<Pet> result = new LinkedList<>();
        for (Pet pet : pets ) {
            if (pet.getTypes().equals(typeToFind)) {
                result.add(pet);
            }

        }
        return result;
    }



}



