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

    public  PetStore(List<Pet> pets){
        this.pets = pets;

    }

    public void addPet(Pet addPet) {
        pets.add(addPet);
    }

    public List<Pet> sortByFoodType(List<Pet> petsToSort) {
        petsToSort.sort(Comparator.comparing(Pet :: getFoodTypes));
        return petsToSort;
    }

    public List<Pet> sortByNumberOfFood(List<Pet> petsToSort) {
        petsToSort.sort(Comparator.comparing(Pet :: getNumberOfFood));
        return petsToSort;
    }

    public List<Pet> searchPetByTypeSortedByFoodType(Types typeToFind){
        return sortByFoodType(searchPetsByType(typeToFind));
    }

    private  List<Pet> searchPetsByType(Types typeToFind) {
        List<Pet> result = new LinkedList<>();
        for (Pet pet : pets ) {
            if (pet.getTypes().equals(typeToFind)) {
                result.add(pet);
            }
        }
        return result;
    }

    public List<Pet> searchPetByTypeSortedByFoodNumber(Types typeToFind){
        return sortByNumberOfFood(searchPetsByType(typeToFind));
    }


}
