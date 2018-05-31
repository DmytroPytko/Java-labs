package ua.lviv.iot.dmytro.model;


import javax.persistence.*;

@Entity
public class Pet {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="pet_id")
    private Integer id;
    @Column(name="pet_species")
    private String species;
    @Column(name="pet_numberOfFood")
    private int numberOfFood;
    @Column(name="pet_type")
    private  String type;


    public Pet(){

    }

    public int getNumberOfFood() {
        return numberOfFood;
    }

    public void setNumberOfFood(int numberOfFood) {
        this.numberOfFood = numberOfFood;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType(){return type;}

    public void setType(String type) {this.type = type;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
