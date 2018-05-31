package ua.lviv.iot.dmytro.persistence.dao;

import ua.lviv.iot.dmytro.model.Pet;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

    @Named
    @Dependent
    public class PetDaoImpl extends AbstractDao<Pet> implements PetDao, Serializable {

        private static final long serialVersionUID = 1L;

        @PersistenceContext
        private EntityManager entityManager;

        @Override
        protected Class<Pet> getEntityClass() {
            return Pet.class;
        }

        //@Resource
        //private UserTransaction userTransaction;

    }


