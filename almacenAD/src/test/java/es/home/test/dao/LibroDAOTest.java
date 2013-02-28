/**
 * 
 */
package es.home.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.home.almacen.dao.LibroDAO;
import es.home.almacen.dao.impl.LibroDAOImpl;
import es.home.almacen.dto.LibroDTO;

/**
 * @author daniel
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:es/appContextAAD.xml"
})
public class LibroDAOTest {

    @Autowired @Qualifier("libroDaoTxDeclarativoImpl")
    private final LibroDAO libroDaoTxDeclarativoImpl = new LibroDAOImpl();

    @Test
    public void findByCriteria() {

	// nombre like %10%

	// criterios.add(Restrictions.like(campo, DaoUtil.getSqlString(valor)));
	List<Criterion> criterios = new ArrayList<Criterion>();
	DetachedCriteria criteria = DetachedCriteria.forClass(LibroDTO.class);
	criterios.add(Restrictions.like("nombre", "%10%"));
	for (Criterion criterio : criterios) {
	    criteria.add(criterio);
	}

	List<LibroDTO> listaDto = null;
	listaDto = libroDaoTxDeclarativoImpl.findByCriteria(criteria);
	//	Assert.assertFalse(listaDto.isEmpty());
	for(LibroDTO libro : listaDto){
	    System.out.println(libro.getNombre());
	}
    }
}
