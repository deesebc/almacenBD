/**
 * 
 */
package es.home.almacen.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;

import es.home.almacen.bean.Libro;
import es.home.almacen.business.LibroBO;
import es.home.almacen.dao.LibroDAO;
import es.home.almacen.dto.LibroDTO;
import es.home.almacen.util.BoUtil;
import es.home.almacen.util.Constante;
import es.home.almacen.util.ConversorDozer;

/**
 * @author cristina
 * 
 */
public class LibroBOImpl implements LibroBO {

    private static final Logger LOGGER = Logger.getLogger(LibroBOImpl.class);

    private final static String CAMPO_NOMBRE = "nombre";
    private final static String CAMPO_AUTOR = "autor";
    private final static String CAMPO_SAGA = "saga";
    private final static String CAMPO_PAGINAS = "paginas";

    private LibroDAO dao;

    /*
     * (non-Javadoc)
     * 
     * @see es.home.almacen.business.LibroBO#buscarLibro(java.lang.String,
     * java.lang.String, java.lang.String, int)
     */
    public List<Libro> buscarLibro(final String nombre, final String autor, final String saga, final int paginas) {
	LOGGER.debug("INICIO -> buscarDisco");
	List<Libro> resultado = null;
	try {
	    List<Criterion> criterios = new ArrayList<Criterion>();
	    DetachedCriteria criteria = DetachedCriteria.forClass(LibroDTO.class);
	    BoUtil.anyadeStringCriteria(criterios, CAMPO_NOMBRE, nombre);
	    BoUtil.anyadeStringCriteria(criterios, CAMPO_AUTOR, autor);
	    BoUtil.anyadeStringCriteria(criterios, CAMPO_SAGA, saga);
	    BoUtil.anyadeIntCriteria(criterios, CAMPO_PAGINAS, paginas);

	    List<LibroDTO> listaDto = null;
	    if (criterios.isEmpty()) {
		listaDto = dao.findAll();
	    } else {
		for(Criterion criterio : criterios){
		    criteria.add(criterio);
		}
		listaDto = dao.findByCriteria(criteria);
	    }

	    resultado = ConversorDozer.convertListaLibro(listaDto);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	    resultado = null;
	}
	LOGGER.debug("FIN -> buscarDisco");
	return resultado;
    }

    public Libro crearLibro(final Libro libro, final boolean isNew) {
	LOGGER.debug("INICIO -> crearLibro");
	Libro bean;
	try {
	    LibroDTO dto = ConversorDozer.convertLibroDTO(libro);
	    if (!isNew) {
		dao.clear();
	    }
	    dto = dao.insertUpdate(dto);
	    bean = ConversorDozer.convertLibro(dto);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	    bean = null;
	}
	LOGGER.debug("FIN -> crearLibro");
	return bean;
    }

    public boolean eliminar(final int idlibro) {
	LOGGER.debug("INICIO -> eliminar");
	boolean resultado = true;
	try {
	    LibroDTO entity = dao.findById(idlibro);
	    dao.delete(entity);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	    resultado = false;
	}
	LOGGER.debug("FIN -> eliminar");
	return resultado;
    }

    /**
     * @return the dao
     */
    public LibroDAO getDao() {
	return dao;
    }

    /*
     * (non-Javadoc)
     * 
     * @see es.home.almacen.business.LibroBO#obtenerLIbro(int)
     */
    public Libro obtenerLibro(final int libro) {
	LOGGER.debug("INICIO -> obtenerLIbro");
	Libro resultado = null;
	try {
	    LibroDTO dto = null;
	    dto = dao.findById(libro);
	    resultado = ConversorDozer.convertLibro(dto);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	    resultado = null;
	}
	LOGGER.debug("FIN -> obtenerLIbro");
	return resultado;
    }

    /**
     * @param dao
     *            the dao to set
     */
    public void setDao(final LibroDAO dao) {
	this.dao = dao;
    }

}
