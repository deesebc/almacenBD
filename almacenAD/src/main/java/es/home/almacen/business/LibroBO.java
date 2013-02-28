/**
 * 
 */
package es.home.almacen.business;

import java.util.List;

import es.home.almacen.bean.Libro;

/**
 * @author cristina
 * 
 */
public interface LibroBO {

    /**
     * Busqueda de libros segun los valores del mismo
     * 
     * @param nombre
     * @param autor
     * @param saga
     * @param paginas
     * @return List<Libro>
     */
    List<Libro> buscarLibro(final String nombre, final String autor, final String saga, final int paginas);

    /**
     * @param libro
     * @return
     */
    Libro crearLibro(final Libro libro, final boolean isNew);

    boolean eliminar(final int idcomponente);

    /**
     * @param libro
     * @return
     */
    Libro obtenerLibro(final int libro);

}
