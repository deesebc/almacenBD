/**
 * 
 */
package es.home.almacen.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;

import es.home.almacen.bean.Componente;
import es.home.almacen.business.ComponenteBO;
import es.home.almacen.dao.ComponenteDAO;
import es.home.almacen.dto.ComponenteDTO;
import es.home.almacen.util.BoUtil;
import es.home.almacen.util.Constante;
import es.home.almacen.util.ConversorDozer;

/**
 * @author daniel
 * 
 */
public class ComponenteBOImpl implements ComponenteBO {

    private static final Logger LOGGER = Logger.getLogger(ComponenteBOImpl.class);
    private ComponenteDAO dao;

    public List<Componente> buscarComponente(final String nombre) {
	LOGGER.debug("INICIO -> buscarComponente");
	List<Componente> resultado = null;
	try {
	    DetachedCriteria criteria = DetachedCriteria.forClass(ComponenteDTO.class);
	    List<Criterion> criterios = new ArrayList<Criterion>();
	    BoUtil.anyadeStringCriteria(criterios, Constante.CAMPO_NOMBRE, nombre);

	    List<ComponenteDTO> listaDto = null;
	    if (!criterios.isEmpty()) {
		for(Criterion criterio : criterios){
		    criteria.add(criterio);
		}
		listaDto = dao.findByCriteria(criteria);
	    } else {
		listaDto = dao.findAll();
	    }

	    resultado = ConversorDozer.convertListaComponente(listaDto);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	}
	LOGGER.debug("FIN -> buscarComponente");
	return resultado;
    }

    public Componente crearComponente(final Componente componente, final boolean isnew) {
	LOGGER.debug("INICIO -> crearComponente");
	Componente bean;
	try {
	    ComponenteDTO dto = ConversorDozer.convertComponenteDTO(componente);
	    if (!isnew) {
		dao.clear();
	    }
	    dto = dao.insertUpdate(dto);
	    bean = ConversorDozer.convertComponente(dto);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	    bean = null;
	}
	LOGGER.debug("FIN -> crearComponente");
	return bean;
    }

    public boolean eliminar(final int idcomponente) {
	LOGGER.debug("INICIO -> eliminar");
	boolean resultado = true;
	try {
	    ComponenteDTO entity = dao.findById(idcomponente);
	    dao.delete(entity);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	    resultado = false;
	}
	LOGGER.debug("FIN -> eliminar");
	return resultado;
    }

    public ComponenteDAO getDao() {
	return dao;
    }

    public Componente obtenerComponente(final int idComponente) {
	LOGGER.debug("INICIO -> obtenerComponente");
	Componente resultado = null;
	try {
	    ComponenteDTO dto = null;
	    dto = dao.findById(idComponente);
	    resultado = ConversorDozer.convertComponente(dto);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	    resultado = null;
	}
	LOGGER.debug("FIN -> obtenerComponente");
	return resultado;
    }

    public void setDao(final ComponenteDAO dao) {
	this.dao = dao;
    }

}
