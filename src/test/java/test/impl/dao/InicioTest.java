/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package test.impl.dao;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Recurso Inicial
 * 
 * @author Yaher Carrillo
 * @date 01/04/2020
 * @since 01/04/2020
 */
public class InicioTest  {

	final static Logger logger = Logger.getLogger(InicioTest.class);

	@BeforeClass
	public void beforeClass() {
		logger.debug("Este metodo se ejecuta antes de cualquier test y se usa para tareas de configuracion");
	}


	@AfterClass
	public void afterClass() {
		logger.debug("Este metodo se ejecuta despues de todos los test y se usa para culminacion de procesos");
	}
}
