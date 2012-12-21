package be.anova.samples.servicemix.service.impl;

import be.anova.samples.servicemix.service.AddressService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: Hans Couder
 * Date: 12/21/12
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddressServiceImp implements AddressService {

    @PersistenceContext(unitName = "user0")
    protected EntityManager entityManager;

    @Override
    public void persist(Object entity) throws Exception
    {
        entityManager.persist(entity);
    }

    @Override
    public <T> T merge(T entity) throws Exception
    {
        return entityManager.merge(entity);
    }

    @Override
    public void remove(Object entity) throws Exception
    {
        entityManager.remove(entityManager.merge(entity));
    }

    @Override
    public <T> T findById(Class<T> type, Object id) throws Exception
    {
        return (T) entityManager.find(type, id);
    }

    @Override
    public EntityManager getEntityManager()
    {
        return entityManager;
    }


}
