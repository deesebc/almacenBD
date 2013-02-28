package es.home.almacen.dto;

// Generated 11-mar-2011 12:03:37 by Hibernate Tools 3.3.0.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Componente generated by hbm2java
 */
public class ComponenteDTO implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer idcomponente;
    private String nombre;
    private Set<ParticipanteDTO> participantes = new HashSet<ParticipanteDTO>(0);

    public ComponenteDTO() {
    }

    public ComponenteDTO(String nombre) {
	this.nombre = nombre;
    }

    public ComponenteDTO(String nombre, Set<ParticipanteDTO> participantes) {
	this.nombre = nombre;
	this.participantes = participantes;
    }

    public Integer getIdcomponente() {
	return this.idcomponente;
    }

    public String getNombre() {
	return this.nombre;
    }

    public Set<ParticipanteDTO> getParticipantes() {
	return this.participantes;
    }

    public void setIdcomponente(Integer idcomponente) {
	this.idcomponente = idcomponente;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public void setParticipantes(Set<ParticipanteDTO> participantes) {
	this.participantes = participantes;
    }

}