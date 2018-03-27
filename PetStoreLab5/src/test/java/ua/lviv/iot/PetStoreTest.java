package ua.lviv.iot;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.FieldAccessor_Short;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PetStoreTest {

    PetStore petStore = null;

    Pet cat = new Pet("Cat", Types.MAMMALS, 123,
            FoodTypes.CANNEDFOOD, 30, AccomodationTypes.CAGE);

    Pet dog = new Pet("Dog", Types.MAMMALS, 123,
            FoodTypes.FELICACIES, 50, AccomodationTypes.CAGE);

    Pet ant = new Pet("Ant", Types.INSECTS, 123,
            FoodTypes.GRAIN, 130, AccomodationTypes.CAGE);

    Pet fish = new Pet("Fish", Types.FISH, 123,
            FoodTypes.FEED, 350, AccomodationTypes.AQUARIUM);

    Pet monkey = new Pet("Monkey", Types.MAMMALS, 123,
            FoodTypes.FRUITS, 302, AccomodationTypes.CAGE);

    Pet goldFish = new Pet("GoldFish", Types.FISH, 200,
            FoodTypes.FEED, 100, AccomodationTypes.AQUARIUM);

    Pet silverFish = new Pet("silverFish", Types.FISH, 300,
            FoodTypes.FEED, 120, AccomodationTypes.AQUARIUM);

    Pet shark = new Pet("shark", Types.FISH, 400,
            FoodTypes.FEED, 302, AccomodationTypes.AQUARIUM);

    Pet tigerShark = new Pet("TigerShark", Types.FISH, 250,
            FoodTypes.FEED, 280, AccomodationTypes.AQUARIUM);

    Pet nemo = new Pet("Nemo", Types.FISH, 260,
            FoodTypes.FEED, 115, AccomodationTypes.AQUARIUM);

    @BeforeEach
    public void setUp() {
        List<Pet> list = new LinkedList<>();
        petStore = new PetStore(list);
    }

    @Test
    void addPet() {
        petStore.addPet(cat);
        assertEquals(cat, petStore.getPets().get(0));
    }

    @Test
    void sortByFoodType() {
        petStore.addPet(dog);
        petStore.addPet(cat);
        petStore.addPet(nemo);

        List<Pet> result = petStore.sortByFoodType(petStore.getPets());

        assertEquals("Nemo", result.get(0).getSpecies());
    }

    @Test
    void sortByNumberOfFood() {
        petStore.addPet(dog);
        petStore.addPet(fish);
        petStore.addPet(goldFish);
        petStore.addPet(shark);
        petStore.addPet(cat);
        List<Pet> pets = new LinkedList<>();
        pets.add(dog);
        pets.add(cat);
        List<Pet> results = petStore.sortByNumberOfFood(petStore.getPets());
        assertEquals(30, results.get(0).getNumberOfFood()) ;
        assertEquals(350, results.get(4).getNumberOfFood()) ;
    }

    @Test
    void testSearchPetByType() {
        petStore.addPet(fish);
        petStore.addPet(goldFish);
        petStore.addPet(shark);
        petStore.addPet(dog);
        petStore.addPet(cat);
        List<Pet> result =  petStore.searchPetsByType(Types.FISH);
        assertEquals(3, result.size());
    }

    @Test
    void testSearchPetByTypeSortedByFoodType() {
        petStore.addPet(cat);
        petStore.addPet(dog);
        petStore.addPet(monkey);
        List<Pet> result =  petStore.searchPetByTypeSortedByFoodType(Types.MAMMALS);
        assertEquals(3, result.size());
        assertEquals("Monkey", result.get(0).getSpecies());
    }

    @Test
    void writerTest (){
        petStore.addPet(fish);
        petStore.addPet(goldFish);
        petStore.addPet(shark);
        petStore.addPet(dog);
        petStore.addPet(cat);
        petStore.addPet(monkey);
        petStore.addPet(nemo);
        petStore.addPet(silverFish);
        petStore.addPet(ant);
        petStore.addPet(tigerShark);

        WriterPet writerPet = new WriterPet();
        writerPet.writeToFile(petStore.getPets());

    }

}