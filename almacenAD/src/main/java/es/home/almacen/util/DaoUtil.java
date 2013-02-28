/**
 * 
 */
package es.home.almacen.util;

/**
 * @author cristina
 * 
 */
public final class DaoUtil {

    /**
     * Prepara el string de entrada para la busqueda por BBDD
     * 
     * @param valor
     * @return String
     */
    public static String getSqlString(final String valor) {
	StringBuilder sBuilder = new StringBuilder();
	sBuilder.append(Constante.PORCIENTO);
	sBuilder.append(valor);
	sBuilder.append(Constante.PORCIENTO);
	return sBuilder.toString();
    }

    /**
     * Constructor privado
     */
    private DaoUtil() {
	super();
    }
}
