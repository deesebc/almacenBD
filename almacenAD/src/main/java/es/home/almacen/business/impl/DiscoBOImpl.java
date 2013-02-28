/**
 * 
 */
package es.home.almacen.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;

import es.home.almacen.bean.Disco;
import es.home.almacen.business.DiscoBO;
import es.home.almacen.dao.DiscoDAO;
import es.home.almacen.dto.DiscoDTO;
import es.home.almacen.util.BoUtil;
import es.home.almacen.util.Constante;
import es.home.almacen.util.ConversorDozer;

/**
 * @author cristina
 * 
 */
public class DiscoBOImpl implements DiscoBO {

    private final static Logger LOGGER = Logger.getLogger(DiscoBOImpl.class);

    private final static String CAMPO_NOMBRE = "nombre";
    private final static String CAMPO_PRODUCTOR = "productor";
    private final static String CAMPO_SELLO = "sello";
    private final static String CAMPO_ANYO = "anyo";

    private DiscoDAO dao;

    /*
     * (non-Javadoc)
     * 
     * @see es.home.almacen.business.DiscoBO#buscarDisco(java.lang.String,
     * java.lang.String, java.lang.String, int)
     */
    public List<Disco> buscarDisco(final String nombre, final String productor, final String sello, final int anyo) {
	LOGGER.debug("INICIO -> buscarDisco");
	List<Disco> resultado = null;
	try {
	    DetachedCriteria criteria = DetachedCriteria.forClass(DiscoDTO.class);
	    List<Criterion> criterios = new ArrayList<Criterion>();
	    BoUtil.anyadeStringCriteria(criterios, CAMPO_NOMBRE, nombre);
	    BoUtil.anyadeStringCriteria(criterios, CAMPO_PRODUCTOR, productor);
	    BoUtil.anyadeStringCriteria(criterios, CAMPO_SELLO, sello);
	    BoUtil.anyadeIntCriteria(criterios, CAMPO_ANYO, anyo);

	    List<DiscoDTO> listaDto = null;
	    if (!criterios.isEmpty()) {
		for(Criterion criterio : criterios){
		    criteria.add(criterio);
		}
		listaDto = dao.findByCriteria(criteria);
	    } else {
		listaDto = dao.findAll();
	    }

	    resultado = ConversorDozer.convertListaDisco(listaDto);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	}
	LOGGER.debug("FIN -> buscarDisco");
	return resultado;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * es.home.almacen.business.DiscoBO#crearDisco(es.home.almacen.bean.Disco,
     * boolean)
     */
    public Disco crearDisco(final Disco disco, final boolean isNew) {
	LOGGER.debug("INICIO -> crearDisco");
	Disco bean;
	try {
	    DiscoDTO dto = ConversorDozer.convertDiscoDTO(disco);
	    if (!isNew) {
		dao.clear();
	    }
	    dto = dao.insertUpdate(dto);
	    bean = ConversorDozer.convertDisco(dto);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	    bean = null;
	}
	LOGGER.debug("FIN -> crearDisco");
	return bean;
    }

    public boolean eliminar(final int iddisco) {
	LOGGER.debug("INICIO -> eliminar");
	boolean resultado = true;
	try {
	    DiscoDTO entity = dao.findById(iddisco);
	    dao.delete(entity);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	    resultado = false;
	}
	LOGGER.debug("FIN -> eliminar");
	return resultado;
    }

    public DiscoDAO getDao() {
	return dao;
    }

    /*
     * (non-Javadoc)
     * 
     * @see es.home.almacen.business.DiscoBO#obtenerDisco(int)
     */
    public Disco obtenerDisco(final int iddisco) {
	LOGGER.debug("INICIO -> obtenerDisco");
	Disco resultado = null;
	try {
	    DiscoDTO dto = null;
	    dto = dao.findById(iddisco);
	    resultado = ConversorDozer.convertDisco(dto);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	    resultado = null;
	}
	LOGGER.debug("FIN -> obtenerDisco");
	return resultado;
    }

    public void setDao(final DiscoDAO dao) {
	this.dao = dao;
    }

}
