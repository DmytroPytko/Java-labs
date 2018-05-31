package ua.lviv.iot.dmytro.rest.service;

import ua.lviv.iot.dmytro.model.Pet;
import ua.lviv.iot.dmytro.persistence.dao.PetDao;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;

@Path("/server")
@SessionScoped
public class Server implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private PetDao dao;
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pet getFruit(@PathParam("id") Integer id) {
        return dao.findById(id);
    }

    @PUT
    public  Response createFruit(Pet pet) {
        dao.persist(pet);
        return  Response.status(200).entity("Good").build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response deleteFruit(@PathParam("id") Integer id) {
        dao.delete(id);
        return Response.status(200).entity("Good").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response updateFruit(Pet pet) {
        dao.updateObject(pet);
        return Response.status(200).entity("Good").build();
    }

    @GET
    @Path("/size")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_XML})
    public  String getSize() {
        return "Yes";
    }

}
