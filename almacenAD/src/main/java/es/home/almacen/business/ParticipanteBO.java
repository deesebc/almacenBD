package es.home.almacen.business;

import java.util.List;

import es.home.almacen.bean.Componente;
import es.home.almacen.bean.Disco;
import es.home.almacen.bean.Participante;

public interface ParticipanteBO {

    /**
     * @param nombre
     * @return
     */
    List<Participante> buscarParticipante(final Disco disco, final Componente componente, final String instrumento);

    Participante crearParticipante(final Participante componente, final boolean isnew);

    Participante obtenerParticipante(final int idComponente);
}
