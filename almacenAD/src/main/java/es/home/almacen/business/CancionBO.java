/**
 * 
 */
package es.home.almacen.business;

import java.util.List;

import es.home.almacen.bean.Cancion;

/**
 * @author cristina
 * 
 */
public interface CancionBO {

    List<Cancion> buscarCancion(final String nombre, final String duracion, final int iddisco);

    Cancion crearCancion(Cancion bean, boolean isNew);

    boolean eliminar(final int idcancion);

    Cancion obtenerCancion(final int idcancion);

}
