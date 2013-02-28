/**
 * 
 */
package es.home.almacen.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import es.home.almacen.bean.Cancion;
import es.home.almacen.bean.Componente;
import es.home.almacen.bean.Disco;
import es.home.almacen.bean.Grupo;
import es.home.almacen.bean.Libro;
import es.home.almacen.bean.Participante;
import es.home.almacen.dto.CancionDTO;
import es.home.almacen.dto.ComponenteDTO;
import es.home.almacen.dto.DiscoDTO;
import es.home.almacen.dto.GrupoDTO;
import es.home.almacen.dto.LibroDTO;
import es.home.almacen.dto.ParticipanteDTO;

/**
 * @author cristina
 * 
 */
public final class ConversorDozer {

    private final static Mapper mapper;

    static {
	mapper = new DozerBeanMapper();
    }

    public static Cancion convertCancion(final CancionDTO dto) {
	return mapper.map(dto, Cancion.class);
    }

    public static CancionDTO convertCancionDTO(final Cancion bean) {
	return mapper.map(bean, CancionDTO.class);
    }

    public static Componente convertComponente(final ComponenteDTO dto) {
	return mapper.map(dto, Componente.class);
    }

    public static ComponenteDTO convertComponenteDTO(final Componente dto) {
	return mapper.map(dto, ComponenteDTO.class);
    }

    /**
     * Convierte la lista de discos
     * 
     * @param dto
     * @return
     */
    public static Disco convertDisco(final DiscoDTO dto) {
	return mapper.map(dto, Disco.class);
    }

    public static DiscoDTO convertDiscoDTO(final Disco bean) {
	return mapper.map(bean, DiscoDTO.class);
    }

    public static Grupo convertGrupo(final GrupoDTO dto) {
	return mapper.map(dto, Grupo.class);
    }

    public static GrupoDTO convertGrupoDTO(final Grupo bean) {
	return mapper.map(bean, GrupoDTO.class);
    }

    /**
     * @param dto
     * @return
     */
    public static Libro convertLibro(final LibroDTO dto) {
	return mapper.map(dto, Libro.class);
    }

    public static LibroDTO convertLibroDTO(final Libro bean) {
	return mapper.map(bean, LibroDTO.class);
    }

    public static List<Cancion> convertListaCancion(final List<CancionDTO> listaDto) {
	List<Cancion> resultado = new ArrayList<Cancion>();
	iteraCollectionCancion(listaDto, resultado);
	return resultado;
    }

    public static List<Componente> convertListaComponente(final List<ComponenteDTO> listaDto) {
	List<Componente> resultado = new ArrayList<Componente>();
	iteraCollectionComponente(listaDto, resultado);
	return resultado;
    }

    /**
     * Convierte la lista de discos
     * 
     * @param listaDto
     * @return
     */
    public static List<Disco> convertListaDisco(final List<DiscoDTO> listaDto) {
	List<Disco> resultado = new ArrayList<Disco>();
	iteraCollectionDisco(listaDto, resultado);
	return resultado;
    }

    public static List<Grupo> convertListaGrupo(final List<GrupoDTO> listaDto) {
	List<Grupo> resultado = new ArrayList<Grupo>();
	iteraCollectionGrupo(listaDto, resultado);
	return resultado;
    }

    public static List<Libro> convertListaLibro(final List<LibroDTO> listaDto) {
	List<Libro> resultado = new ArrayList<Libro>();
	iteraCollectionLibro(listaDto, resultado);
	return resultado;
    }

    public static List<Participante> convertListaParticipante(final List<ParticipanteDTO> listaDto) {
	List<Participante> resultado = new ArrayList<Participante>();
	iteraCollectionParticipante(listaDto, resultado);
	return resultado;
    }

    public static Participante convertParticipante(final ParticipanteDTO dto) {
	return mapper.map(dto, Participante.class);
    }

    public static ParticipanteDTO convertParticipanteDTO(final Participante bean) {
	return mapper.map(bean, ParticipanteDTO.class);
    }

    private static void iteraCollectionCancion(final Collection<CancionDTO> listaDto, final Collection<Cancion> resultado) {
	if (listaDto != null && !listaDto.isEmpty()) {
	    for (CancionDTO dto : listaDto) {
		resultado.add(convertCancion(dto));
	    }
	}
    }

    private static void iteraCollectionComponente(final Collection<ComponenteDTO> listaDto, final Collection<Componente> resultado) {
	if (listaDto != null && !listaDto.isEmpty()) {
	    for (ComponenteDTO dto : listaDto) {
		resultado.add(convertComponente(dto));
	    }
	}
    }

    /**
     * @param listaDto
     * @param resultado
     */
    private static void iteraCollectionDisco(final Collection<DiscoDTO> listaDto, final Collection<Disco> resultado) {
	if (listaDto != null && !listaDto.isEmpty()) {
	    for (DiscoDTO dto : listaDto) {
		resultado.add(convertDisco(dto));
	    }
	}
    }

    private static void iteraCollectionGrupo(final Collection<GrupoDTO> listaDto, final Collection<Grupo> resultado) {
	if (listaDto != null && !listaDto.isEmpty()) {
	    for (GrupoDTO dto : listaDto) {
		resultado.add(convertGrupo(dto));
	    }
	}
    }

    private static void iteraCollectionLibro(final Collection<LibroDTO> listaDto, final Collection<Libro> resultado) {
	if (listaDto != null && !listaDto.isEmpty()) {
	    for (LibroDTO dto : listaDto) {
		resultado.add(convertLibro(dto));
	    }
	}
    }

    private static void iteraCollectionParticipante(final Collection<ParticipanteDTO> listaDto, final Collection<Participante> resultado) {
	if (listaDto != null && !listaDto.isEmpty()) {
	    for (ParticipanteDTO dto : listaDto) {
		resultado.add(convertParticipante(dto));
	    }
	}
    }

    /**
     * constructor privado
     */
    private ConversorDozer() {
	super();
    }
}
