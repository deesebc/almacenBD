/**
 * 
 */
package es.home.almacen.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;

import es.home.almacen.bean.Cancion;
import es.home.almacen.business.CancionBO;
import es.home.almacen.dao.CancionDAO;
import es.home.almacen.dto.CancionDTO;
import es.home.almacen.util.BoUtil;
import es.home.almacen.util.Constante;
import es.home.almacen.util.ConversorDozer;

/**
 * @author cristina
 * 
 */
public class CancionBOImpl implements CancionBO {

    private static final String CAMPO_DURACION = "duracion";
    private static final String CAMPO_IDDISCO = "disco.iddisco";

    private CancionDAO dao;

    private static final Logger LOGGER = Logger.getLogger(CancionBOImpl.class);

    public List<Cancion> buscarCancion(final String nombre, final String duracion, final int iddisco) {
	LOGGER.debug("INICIO -> buscarCancion");
	List<Cancion> resultado = null;
	try {
	    DetachedCriteria criteria = DetachedCriteria.forClass(CancionDTO.class);
	    List<Criterion> criterios = new ArrayList<Criterion>();
	    BoUtil.anyadeStringCriteria(criterios, Constante.CAMPO_NOMBRE, nombre);
	    BoUtil.anyadeStringCriteria(criterios, CAMPO_DURACION, duracion);
	    BoUtil.anyadeIntCriteria(criterios, CAMPO_IDDISCO, iddisco);

	    List<CancionDTO> listaDto = null;
	    if (!criterios.isEmpty()) {
		for(Criterion criterio : criterios){
		    criteria.add(criterio);
		}
		listaDto = dao.findByCriteria(criteria);
	    } else {
		listaDto = dao.findAll();
	    }

	    resultado = ConversorDozer.convertListaCancion(listaDto);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	}
	LOGGER.debug("FIN -> buscarCancion");
	return resultado;
    }

    public Cancion crearCancion(final Cancion bean, final boolean isNew) {
	LOGGER.debug("INICIO -> crearDisco");
	Cancion resultado;
	try {
	    CancionDTO dto = ConversorDozer.convertCancionDTO(bean);
	    // TODO Mejorar
	    if (!isNew) {
		dao.clear();
	    }
	    dto = dao.insertUpdate(dto);
	    resultado = ConversorDozer.convertCancion(dto);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	    resultado = null;
	}
	LOGGER.debug("FIN -> crearDisco");
	return resultado;
    }

    public boolean eliminar(final int idcancion) {
	LOGGER.debug("INICIO -> eliminar");
	boolean resultado = true;
	try {
	    CancionDTO entity = dao.findById(idcancion);
	    dao.delete(entity);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	    resultado = false;
	}
	LOGGER.debug("FIN -> eliminar");
	return resultado;
    }

    public CancionDAO getDao() {
	return dao;
    }

    public Cancion obtenerCancion(final int idcancion) {
	LOGGER.debug("INICIO -> obtenerCancion");
	Cancion resultado = null;
	try {
	    CancionDTO dto = null;
	    dto = dao.findById(idcancion);
	    resultado = ConversorDozer.convertCancion(dto);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	    resultado = null;
	}
	LOGGER.debug("FIN -> obtenerCancion");
	return resultado;
    }

    public void setDao(final CancionDAO dao) {
	this.dao = dao;
    }

}
