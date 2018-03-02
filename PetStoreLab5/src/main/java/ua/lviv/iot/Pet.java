package ua.lviv.iot;

public class Pet {
    private String species;
    private int numberOfFood; // in kgs
    private int price; // in hrn
    private Types type;
    private FoodTypes food;
    private AccomodationTypes accomodation;


    public Pet(final String newSpecies, final Types newType,
               final int newPrice, final FoodTypes newFood,
               final int newNumberOfFood, final AccomodationTypes newAccomodation) {
        setSpecies(newSpecies);
        setNumberOfFood(newNumberOfFood);
        setPrice(newPrice);
        setTypes(newType);
        setFoodTypes(newFood);
        setAccomodationTypes(newAccomodation);

    }

    @Override
    public final String toString() {
        return " Pet called " + species + " of type + "
                + this.type + " costs " + this.price
                + " eats " + this.numberOfFood + " of " + this.food
                + " and lives in " + this.accomodation + "\n";

    }

    public final String getSpecies() {
        return species;
    }

    public final void setSpecies(final String newSpecies) {
        this.species = newSpecies;
    }

    public final int getPrice() {
        return price;
    }

    public final void setPrice(final int newPrice) {
        this.price = newPrice;
    }

    public final Types getTypes() {
        return type;
    }

    public final void setTypes(final Types newType) {
        this.type = newType;
    }


    public final FoodTypes getFoodTypes() {
        return food;
    }

    public final void setFoodTypes(final FoodTypes newFood) {
        this.food = newFood;

    }

    public final AccomodationTypes getAccomodation() {
        return accomodation;
    }

    public final void setAccomodationTypes(final AccomodationTypes newAccomodation) {
        this.accomodation = newAccomodation;
    }

    public final int getNumberOfFood() {
        return numberOfFood;
    }

    public final void setNumberOfFood(final int newNumberOfFood) {
        this.numberOfFood = newNumberOfFood;
    }
}
