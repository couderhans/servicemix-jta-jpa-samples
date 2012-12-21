package be.anova.samples.servicemix.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Created with IntelliJ IDEA.
 * User: Hans Couder
 * Date: 12/21/12
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */
public interface AddressService {

    /**
     * Persist an entity instance in the database
     * @param entity
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void persist(Object entity) throws Exception;

    /**
     * Merge an entity instance.
     * This method is used to update an entity but also to reattach an entity instance to the entityManager context
     * @param entity
     * @return return the entity that has been merged
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public <T> T merge(T entity) throws Exception;

    /**
     * Remove an entity instance from the database
     * @param entity
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(Object entity) throws Exception;

    /**
     * Find by id an entity in the database
     * @param id
     * @return
     * @throws Exception
     */
    public <T> T findById(Class<T> type, Object id) throws Exception;

    /**
     * Get the EntityManager instance
     * @return
     */
    public EntityManager getEntityManager();

}
