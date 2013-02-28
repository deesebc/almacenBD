
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.home.almacen.business.CancionBO;
import es.home.almacen.business.DiscoBO;
import es.home.almacen.business.GrupoBO;
import es.home.almacen.business.LibroBO;
import es.home.almacen.dao.CancionDAO;
import es.home.almacen.dao.LibroDAO;
import es.home.almacen.dto.CancionDTO;

public class Test01 {
    public static void main(final String args[]) {

	// ApplicationContext app = new
	// FileSystemXmlApplicationContext("/appContext.xml");
	ApplicationContext app = new ClassPathXmlApplicationContext(
	"appContextAAD.xml");

	// Llamada desde el autoproxy
	LibroDAO persistencia = (LibroDAO) app.getBean("libroDAOImpl");

	System.out.println(persistencia.findAll());// Llamada desde el autoproxy
	CancionDAO perssis2 = (CancionDAO) app.getBean("cancionDAOImpl");
	CancionDTO valor = perssis2.findById(Integer.valueOf(1));
	System.out.println(valor.getNombre());
	System.out.println(perssis2.findAll());
	System.out.println("--  persis 3 --");
	LibroDAO perssis3 = (LibroDAO) app.getBean("libroDaoTxDeclarativoImpl");
	System.out.println(perssis3.findAll());
	System.out.println("-- BO 1 --");
	LibroBO perssis4 = (LibroBO) app.getBean("libroBOImpl");
	System.out.println(perssis4.obtenerLibro(1));
	System.out.println("---- BO 2 ----");
	CancionBO perssi5 = (CancionBO) app.getBean("cancionBOImpl");
	System.out.println(perssi5.buscarCancion("a", null, 0));
	System.out.println("----- BO 3 -----");
	DiscoBO persis6 = (DiscoBO) app.getBean("discoBOImpl");
	System.out.println(persis6.buscarDisco(null, null, null, 0));
	System.out.println("----- BO 4 -----");
	GrupoBO persis7 = (GrupoBO) app.getBean("customerService");
	System.out.println(persis7.obtenerGrupo(1));


    }
}
