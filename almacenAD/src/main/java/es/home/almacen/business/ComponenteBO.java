package es.home.almacen.business;

import java.util.List;

import es.home.almacen.bean.Componente;

public interface ComponenteBO {

    /**
     * @param nombre
     * @return
     */
    List<Componente> buscarComponente(final String nombre);

    Componente crearComponente(final Componente componente, final boolean isnew);

    boolean eliminar(final int idcomponente);

    Componente obtenerComponente(final int idComponente);
}
