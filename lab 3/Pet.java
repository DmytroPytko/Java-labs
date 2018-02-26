package com.company;

public class Pet {
    private String species;
    private int numberOfFood; // in kgs
    private int price; // in hrn
    private Types type;
    private FoodTypes food;
    private AccomodationTypes accomodation;


    public Pet (String species, Types type, int price, FoodTypes food, int numberOfFood, AccomodationTypes accomodation) {
        setSpecies(species);
        setNumberOfFood(numberOfFood);
        setPrice(price);
        setTypes(type);
        setFoodTypes(food);
        setAccomodationTypes(accomodation);

    }

    @Override
    public String toString() {
        return " Pet called " + species + " of type + " + this.type + " costs " + this.price +
                " eats " + this.numberOfFood + " of " + this.food + " and lives in " + this.accomodation + "\n";

    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Types getTypes(){
        return type;
    }

    public void setTypes(Types type) {
        this.type = type;
    }


    public FoodTypes getFoodTypes(){
        return food;
    }

    public void setFoodTypes(FoodTypes food){
        this.food = food;

    }

    public AccomodationTypes getAccomodation() {
        return accomodation;
    }

    public void setAccomodationTypes(AccomodationTypes accomodation) {
        this.accomodation = accomodation;
    }

    public int getNumberOfFood(){
        return numberOfFood;
    }

    public void setNumberOfFood(int numberOfFood) {
        this.numberOfFood = numberOfFood;
    }
}
