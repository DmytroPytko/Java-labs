package ua.lviv.iot;

public class Pet {
    private Integer id;
    private String species;
    private int numberOfFood; // in kgs
    private int price; // in hrn
    private Types type;
    private FoodTypes food;
    private AccomodationTypes accomodation;

    public Pet(){

    }

    public void setType(Types type) {
        this.type = type;
    }

    public String getSpecies() {
        return species;
    }

    public int getPrice() {
        return price;
    }

    public Types getType() {
        return type;
    }

    public FoodTypes getFood() {
        return food;
    }

    public AccomodationTypes getAccomodation() {
        return accomodation;
    }

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

//    public String getHeaders() {
//        return "Species, numberOfFood, price, Types, FoodTypes, AccommodationTypes ";
//    }
//
//    public String toCSV() {
//        return getSpecies() + ", " + getNumberOfFood() + ", " + getPrice() + ", " + getTypes() + ", " + getFoodTypes() + ", " + getAccomodationTypes() + ". ";
//    }

    public final void setSpecies(final String newSpecies) {
        this.species = newSpecies;
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

    public final void setAccomodationTypes(final AccomodationTypes newAccomodation) {
        this.accomodation = newAccomodation;
    }

    public final AccomodationTypes getAccomodationTypes() {
        return accomodation;
    }

    public int getNumberOfFood() {
        return numberOfFood;
    }

    public final void setNumberOfFood(final int newNumberOfFood) {
        this.numberOfFood = newNumberOfFood;
    }

    public final Integer getId(){
        return id;
    }

    public void setId(Integer id) {this.id = id;}
}
