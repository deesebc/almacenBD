package es.home.almacen.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import es.home.almacen.hibernate.GenericDAO;

public abstract class GenericDAOImpl<T, ID extends Serializable> extends HibernateDaoSupport implements GenericDAO<T, ID> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public GenericDAOImpl() {
	this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void clear() {
	getHibernateTemplate().clear();
    }

    public void delete(final T entity) {
	getHibernateTemplate().delete(entity);

    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
	return getHibernateTemplate().loadAll(persistentClass);
    }

    @SuppressWarnings("unchecked")
    public List<T> findByCriteria(final DetachedCriteria criteria) {
	return getHibernateTemplate().findByCriteria(criteria);
    }

    @SuppressWarnings("unchecked")
    public T findById(final ID identity) {
	return (T) getHibernateTemplate().get(persistentClass, identity);
    }

    public void flush() {
	getHibernateTemplate().flush();

    }

    public T insertUpdate(final T entity) {
	getHibernateTemplate().saveOrUpdate(entity);
	return entity;
    }

}
