package ua.lviv.iot;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WriterPet {

        public final void writeToFile(final List<Pet> pets) {
            try (PrintWriter writer = new PrintWriter("PetStaff.csv file")) {
                writer.println(pets.get(0).getHeaders());
                for (Pet pet : pets) {

                    writer.println(pet.toCSV());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
