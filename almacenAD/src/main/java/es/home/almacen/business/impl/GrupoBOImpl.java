/**
 * 
 */
package es.home.almacen.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;

import es.home.almacen.bean.Grupo;
import es.home.almacen.business.GrupoBO;
import es.home.almacen.dao.GrupoDAO;
import es.home.almacen.dto.GrupoDTO;
import es.home.almacen.util.BoUtil;
import es.home.almacen.util.Constante;
import es.home.almacen.util.ConversorDozer;

/**
 * @author cristina
 * 
 */
public class GrupoBOImpl implements GrupoBO {

    private final static Logger LOGGER = Logger.getLogger(GrupoBOImpl.class);

    private final static String CAMPO_NOMBRE = "nombre";

    private GrupoDAO dao;

    /*
     * (non-Javadoc)
     * 
     * @see es.home.almacen.business.GrupoBO#buscarGrupo(java.lang.String)
     */
    public List<Grupo> buscarGrupo(final String nombre) {
	LOGGER.debug("INICIO -> buscarGrupo");
	List<Grupo> resultado = null;
	try {
	    DetachedCriteria criteria = DetachedCriteria.forClass(GrupoDTO.class);
	    List<Criterion> criterios = new ArrayList<Criterion>();
	    BoUtil.anyadeStringCriteria(criterios, CAMPO_NOMBRE, nombre);

	    List<GrupoDTO> listaDto = null;
	    if (!criterios.isEmpty()) {
		for(Criterion criterio : criterios){
		    criteria.add(criterio);
		}
		listaDto = dao.findByCriteria(criteria);
	    } else {
		listaDto = dao.findAll();
	    }

	    resultado = ConversorDozer.convertListaGrupo(listaDto);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	}
	LOGGER.debug("FIN -> buscarGrupo");
	return resultado;
    }

    public Grupo crearGrupo(final Grupo grupo, final boolean isNew) {
	LOGGER.debug("INICIO -> crearGrupo");
	Grupo bean;
	try {
	    GrupoDTO dto = ConversorDozer.convertGrupoDTO(grupo);
	    dto = dao.insertUpdate(dto);
	    bean = ConversorDozer.convertGrupo(dto);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	    bean = null;
	}
	LOGGER.debug("FIN -> crearGrupo");
	return bean;
    }

    public boolean eliminar(final int idgrupo) {
	LOGGER.debug("INICIO -> eliminar");
	boolean resultado = true;
	try {
	    GrupoDTO entity = dao.findById(idgrupo);
	    dao.delete(entity);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	    resultado = false;
	}
	LOGGER.debug("FIN -> eliminar");
	return resultado;
    }

    public GrupoDAO getDao() {
	return dao;
    }

    /*
     * (non-Javadoc)
     * 
     * @see es.home.almacen.business.GrupoBO#obtenerGrupo(int)
     */
    public Grupo obtenerGrupo(final int grupo) {
	LOGGER.debug("INICIO -> obtenerGrupo");
	Grupo resultado = null;
	try {
	    GrupoDTO dto = null;
	    dto = dao.findById(grupo);
	    resultado = ConversorDozer.convertGrupo(dto);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	    resultado = null;
	}
	LOGGER.debug("FIN -> obtenerGrupo");
	return resultado;
    }

    public void setDao(final GrupoDAO dao) {
	this.dao = dao;
    }

}
