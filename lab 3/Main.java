package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PetStore store = new PetStore();
        store.addPet(new Pet("Cat", Types.MAMMALS, 123, FoodTypes.CANNEDFOOD, 30, AccomodationTypes.CAGE));
        store.addPet(new Pet("Dog", Types.MAMMALS, 123, FoodTypes.FELICACIES, 50, AccomodationTypes.CAGE));
        store.addPet(new Pet("Ant", Types.INSECTS, 123, FoodTypes.GRAIN, 130, AccomodationTypes.CAGE));
        store.addPet(new Pet("Fish", Types.FISH, 123, FoodTypes.FEED, 350, AccomodationTypes.AQUARIUM));
        store.addPet(new Pet("Cat", Types.MAMMALS, 123, FoodTypes.FRUITS, 302, AccomodationTypes.CAGE));
        store.addPet(new Pet("GoldFish", Types.FISH, 200, FoodTypes.FEED,100, AccomodationTypes.AQUARIUM));
        store.addPet(new Pet("silverFish", Types.FISH, 300, FoodTypes.FEED,120, AccomodationTypes.AQUARIUM));
        store.addPet(new Pet("shark", Types.FISH, 400, FoodTypes.FEED,302, AccomodationTypes.AQUARIUM));
        store.addPet(new Pet("TigerShark", Types.FISH, 250, FoodTypes.FEED,280, AccomodationTypes.AQUARIUM));
        store.addPet(new Pet("Nemo", Types.FISH, 260, FoodTypes.FEED,115, AccomodationTypes.AQUARIUM));


        boolean menu = true;
        while (menu) {

            System.out.println("Menu");
            System.out.println(" 1 - Print list of pets;");
            System.out.println(" 2 - Search by type of pet;");
            System.out.println(" 3 - Print list of pets sorted by food type;");
            System.out.println(" 4 - Print list of pets sorted by number of food;");
            System.out.println(" 5 - Exit;");

            Scanner in = new Scanner(System.in);
            int num = in.nextInt();
            //in.close();
            switch (num) {
                case 1: {
                    System.out.println(store.getPets().toString());
                    break;
                }
                case 2: {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter the type: ");
                    String type = scanner.nextLine();
                    //scanner.close();
                    if (type.equals("Mammals") || type.equals("MAMMALS") || type.equals("mammals")) {
                        System.out.println(store.searchPetByType(Types.MAMMALS).toString());
                    } else if (type.equals("Birds") || type.equals("BIRDS") || type.equals("birds")) {
                        System.out.println(store.searchPetByType(Types.BIRDS).toString());
                    } else if (type.equals("AMPHIBIANS") || type.equals("Amphibians") || type.equals("amphibians")) {
                        System.out.println(store.searchPetByType(Types.AMPHIBIANS).toString());
                    } else if (type.equals("REPTILES") || type.equals("Reptiles") || type.equals("reptiles")) {
                        System.out.println(store.searchPetByType(Types.REPTILES).toString());
                    } else if (type.equals("Fish") || type.equals("FISH") || type.equals("fish")) {
                        System.out.println(store.searchPetByType(Types.FISH).toString());
                    } else if (type.equals("Insects") || type.equals("INSECTS") || type.equals("insects")) {
                        System.out.println(store.searchPetByType(Types.INSECTS).toString());
                    } else if (type.equals("CRUSTACEANS") || type.equals("Crustaceans") || type.equals("crustaceans")) {
                        System.out.println(store.searchPetByType(Types.CRUSTACEANS).toString());
                    } else if (type.equals("MOLLUSKS") || type.equals("Mollusks") || type.equals("mollusks")) {
                        System.out.println(store.searchPetByType(Types.MOLLUSKS).toString());
                    } else if (type.equals("SPIDERSHAPED") || type.equals("Spidershaped") || type.equals("spidershaped")) {
                        System.out.println(store.searchPetByType(Types.SPIDERSHAPED).toString());
                    }
                    break;
                }
                case 3: {
                    System.out.println(store.sortByFoodType().toString());
                    break;
                }
                case 4: {
                    System.out.println(store.sortByNumberOfFood().toString());
                    break;
                }
                case 5:
                default: {
                    System.out.println("Exited programm");
                    menu = false;
                    break;
                }
            }

        }
    }
}