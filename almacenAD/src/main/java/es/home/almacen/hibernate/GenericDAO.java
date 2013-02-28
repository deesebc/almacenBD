package es.home.almacen.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface GenericDAO<T, ID extends Serializable> {

    /**
     * Borra los cambios.
     */
    void clear();

    /**
     * Borra una entidad.
     * 
     * @param entity
     *            Entidad
     */
    void delete(T entity);

    /**
     * Obtiene una lista de entidades.
     * 
     * @return Devuelve una lista de entidades.
     */
    List<T> findAll();

    /**
     * Obtiene una lista de entidades segun un criterio
     * 
     * @param criterion
     * @return List<T>
     */
    List<T> findByCriteria(final DetachedCriteria criteria);

    /**
     * Obtiene un entidad por su id.
     * 
     * @param identity
     *            Identificador de la entidad.
     * @param lock
     *            bloquedado.
     * @return Devuleve un objeto.
     */
    T findById(ID identity);

    /**
     * Guarda los cambios.
     */
    void flush();

    /**
     * Guarda o actualiza una entidad.
     * 
     * @param entity
     *            Entidad.
     * @return Devuelve entidad.
     */
    T insertUpdate(T entity);

}
