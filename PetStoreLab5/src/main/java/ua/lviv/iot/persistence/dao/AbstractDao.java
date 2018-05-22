package ua.lviv.iot.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public  abstract class AbstractDao<T> implements IDao<T> {
    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected abstract Class<T> getEntityClass();

    @Transactional(value = Transactional.TxType.REQUIRED)
    @Override
    public T findById(Integer id) {
        T result = (T) entityManager.find(getEntityClass(), id);
        return result;
    }

    @Transactional(value = Transactional.TxType.REQUIRED)
    @Override
    public T persist(T object) {
        entityManager.persist(object);
        return object;
    }

    @Transactional(value = Transactional.TxType.REQUIRED)
    @Override
    public T update(T object) {
        T entityToUpdate = entityManager.merge(object);
        entityManager.persist(entityToUpdate);
        return entityToUpdate;
    }

    @Transactional(value = Transactional.TxType.REQUIRED)
    public void deleteById(Integer id){
        entityManager.remove(findById(id));
    }
}
