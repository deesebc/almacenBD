/**
 * 
 */
package es.home.almacen.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author dsblanco
 * 
 */
public class ParametroBusqueda implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SEPARADOR_CAMPO = "=";
    private static final String SEPARADOR_PARAMETRO = "&";

    private Map<String, String> parametros;

    public ParametroBusqueda() {
	parametros = new HashMap<String, String>();
    }

    /**
     * @return the parametros
     */
    public Map<String, String> getParametros() {
	return parametros;
    }

    /**
     * @param parametros
     *            the parametros to set
     */
    public void setParametros(Map<String, String> parametros) {
	this.parametros = parametros;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	StringBuilder sBuilder = new StringBuilder();
	for (Entry<String, String> parametro : parametros.entrySet()) {
	    sBuilder.append(parametro.getKey()).append(SEPARADOR_CAMPO);
	    sBuilder.append(parametro.getValue()).append(SEPARADOR_PARAMETRO);
	}
	return sBuilder.toString();
    }

}
