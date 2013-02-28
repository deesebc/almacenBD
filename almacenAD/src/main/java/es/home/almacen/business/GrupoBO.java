/**
 * 
 */
package es.home.almacen.business;

import java.util.List;

import es.home.almacen.bean.Grupo;

/**
 * @author cristina
 * 
 */
public interface GrupoBO {

    /**
     * Buscar un grupo determinado un nombre
     * 
     * @param nombre
     * @return List<Grupo>
     */
    List<Grupo> buscarGrupo(final String nombre);

    /**
     * @param grupo
     * @return
     */
    Grupo crearGrupo(final Grupo grupo, boolean isNew);

    boolean eliminar(final int idcomponente);

    /**
     * @param grupo
     * @return
     */
    Grupo obtenerGrupo(final int grupo);
}
