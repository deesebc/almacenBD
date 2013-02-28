/**
 * 
 */
package es.home.almacen.dao.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;

import es.home.almacen.dao.CancionDAO;
import es.home.almacen.dto.CancionDTO;

/**
 * @author DSBLANCO
 * 
 */
public class CancionDAOImpl extends GenericDAOImpl<CancionDTO, Integer> implements CancionDAO {

    public List<CancionDTO> findByCriteria(final Criterion... criterion) {
	// TODO Auto-generated method stub
	return null;
    }

}
