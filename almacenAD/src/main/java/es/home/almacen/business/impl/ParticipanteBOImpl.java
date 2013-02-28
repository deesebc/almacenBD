/**
 * 
 */
package es.home.almacen.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;

import es.home.almacen.bean.Componente;
import es.home.almacen.bean.Disco;
import es.home.almacen.bean.Participante;
import es.home.almacen.business.ParticipanteBO;
import es.home.almacen.dao.ParticipanteDAO;
import es.home.almacen.dto.ParticipanteDTO;
import es.home.almacen.util.BoUtil;
import es.home.almacen.util.Constante;
import es.home.almacen.util.ConversorDozer;

/**
 * @author daniel
 * 
 */
public class ParticipanteBOImpl implements ParticipanteBO {

    private static final Logger LOGGER = Logger.getLogger(ParticipanteBOImpl.class);
    private ParticipanteDAO dao;

    private static final String CAMPO_INSTRUMENTO = "instrumento";

    private static final String CAMPO_ID_COMPONENTE = "componente.idcomponente";

    private static final String CAMPO_ID_DISCO = "disco.iddisco";
    public List<Participante> buscarParticipante(final Disco disco, final Componente componente, final String instrumento) {
	LOGGER.debug("INICIO -> buscarComponente");
	List<Participante> resultado = null;
	try {
	    DetachedCriteria criteria = DetachedCriteria.forClass(ParticipanteDTO.class);
	    List<Criterion> criterios = new ArrayList<Criterion>();
	    BoUtil.anyadeStringCriteria(criterios, CAMPO_INSTRUMENTO, instrumento);
	    BoUtil.anyadeIntCriteria(criterios, CAMPO_ID_COMPONENTE, componente.getIdcomponente());
	    BoUtil.anyadeIntCriteria(criterios, CAMPO_ID_DISCO, disco.getIddisco());

	    List<ParticipanteDTO> listaDto = null;
	    if (!criterios.isEmpty()) {
		for(Criterion criterio : criterios){
		    criteria.add(criterio);
		}
		listaDto = dao.findByCriteria(criteria);
	    } else {
		listaDto = dao.findAll();
	    }

	    resultado = ConversorDozer.convertListaParticipante(listaDto);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	}
	LOGGER.debug("FIN -> buscarComponente");
	return resultado;
    }
    public Participante crearParticipante(final Participante participante, final boolean isnew) {
	LOGGER.debug("INICIO -> crearParticipante");
	Participante bean;
	try {
	    ParticipanteDTO dto = ConversorDozer.convertParticipanteDTO(participante);
	    dto = dao.insertUpdate(dto);
	    bean = ConversorDozer.convertParticipante(dto);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	    bean = null;
	}
	LOGGER.debug("FIN -> crearParticipante");
	return bean;
    }

    public ParticipanteDAO getDao() {
	return dao;
    }

    public Participante obtenerParticipante(final int idParticipante) {
	LOGGER.debug("INICIO -> obtenerParticipante");
	Participante resultado = null;
	try {
	    ParticipanteDTO dto = null;
	    dto = dao.findById(idParticipante);
	    resultado = ConversorDozer.convertParticipante(dto);
	} catch (Exception except) {
	    LOGGER.error(Constante.ERROR_BBDD, except);
	    resultado = null;
	}
	LOGGER.debug("FIN -> obtenerParticipante");
	return resultado;
    }

    public void setDao(final ParticipanteDAO dao) {
	this.dao = dao;
    }

}
