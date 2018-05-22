package ua.lviv.iot.persistence.dao;

import ua.lviv.iot.Pet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public class PetDaoImpl extends AbstractDao<Pet> implements PetDao,Serializable{
    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Pet> getEntityClass() {
        return Pet.class;
    }
}
