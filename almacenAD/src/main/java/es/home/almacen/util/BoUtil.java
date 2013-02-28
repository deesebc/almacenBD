/**
 * 
 */
package es.home.almacen.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * @author cristina
 * 
 */
public final class BoUtil {

    public static void anyadeIntCriteria(final List<Criterion> criterios, final String campo, final int valor) {
	if (valor > 0) {
	    criterios.add(Restrictions.eq(campo, valor));
	}
    }

    public static void anyadeStringCriteria(final List<Criterion> criterios, final String campo, final String valor) {
	if (StringUtils.isNotEmpty(valor)) {
	    criterios.add(Restrictions.like(campo, DaoUtil.getSqlString(valor)));
	}
    }

    /**
     * constructor privado
     */
    private BoUtil() {
	super();
    }
}
