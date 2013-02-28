/**
 * 
 */
package es.home.almacen.business;

import java.util.List;

import es.home.almacen.bean.Disco;

/**
 * @author cristina
 * 
 */
public interface DiscoBO {

    /**
     * Busqueda de discos segun los valores del mismo
     * 
     * @param nombre
     * @param productor
     * @param sello
     * @param anyo
     * @return List<Disco>
     */
    List<Disco> buscarDisco(final String nombre, final String productor, final String sello, final int anyo);

    /**
     * @param disco
     * @param isNew
     * @return
     */
    Disco crearDisco(Disco disco, boolean isNew);

    /**
     * @param iddisco
     * @return
     */
    boolean eliminar(final int iddisco);

    /**
     * @param iddisco
     * @return
     */
    Disco obtenerDisco(final int iddisco);
}
