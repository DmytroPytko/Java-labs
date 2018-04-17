package ua.lviv.iot;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Path("/pets")
public class PetService implements Serializable{
    private static Map<Integer, Pet> petMap = new HashMap<>();
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public final Pet getPet(@PathParam("id") Integer id) {
        return petMap.get(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public final Response createPet(Pet pet) {
        petMap.put(pet.getId(), pet);
        return Response.status(200).entity("Good").build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public final Response deletePet(@PathParam("id") Integer id) {
        petMap.remove(id);
        return Response.status(200).entity("Good").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public final Response updatePet(Pet pet) {
        petMap.put(pet.getId(), pet);
        return Response.status(200).entity("Good").build();
    }
}