/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package test.impl.dao;

import co.bancodebogota.definitions.auto.testng.dao.CanalesDao;
import co.bancodebogota.definitions.auto.testng.exceptions.DaoException;
import co.bancodebogota.definitions.auto.testng.models.Canales;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

/**
 * Implementacion de procesos dao de la entidad canales, operaciones basicas de
 * la entidad
 * 
 * @author Yaher Carrillo
 * @date 01/04/2020
 * @since 01/04/2020
 */
public class CanalesDaoTest extends EntityDaoImplTest {
	/**
	 * Dao de operaciones de la entidad.
	 */
	@Autowired
	private CanalesDao canalesDao;

	/**
	 * Logger de Sistema
	 */
	final static Logger logger = Logger.getLogger(CanalesDaoTest.class);

	Canales canal;

	@BeforeClass
	public void beforeClass() throws DaoException {
		canal = new Canales();
		canal.setCodCanal("APP1");
		canal.setNombre_canal("APP MOVILES");
		canal.setHabilitado(NumberUtils.LONG_ONE);
	}

	@BeforeMethod
	public void crearInstancia() throws DaoException {
		Long result = canalesDao.agregar(canal);
		Assert.assertNotNull(result);
	}

	@Test
	public void listar(){
		List<Canales> list = canalesDao.obtenerTodo();
		logger.debug("Canales consultados : " + list);
		Assert.assertEquals(false,list.isEmpty());
	}

	@Test(dependsOnMethods ={"listar"})
	public void crearNuevoElemento() throws DaoException {
		Canales canalDto = new Canales();
		canalDto.setCodCanal("APP2");
		canalDto.setNombre_canal("APP MOVILES2");
		canalDto.setHabilitado(NumberUtils.LONG_ONE);
		Long result = canalesDao.agregar(canalDto);
		Assert.assertNotNull(result);
	}

	@Test(groups = "tests", dependsOnMethods ={"crearNuevoElemento"})
	public void listarDeNuevo(){
		List<Canales> list = canalesDao.obtenerTodo();
		logger.debug("Canales consultados : " + list);
		Assert.assertEquals(false,list.isEmpty());
	}

	@Test(dependsOnGroups = "tests")
	public void modificar() throws DaoException {
		Canales canalDto = new Canales();
		canalDto.setCodCanal("APP1");
		Canales modify = canalesDao.buscarObjetoUnico(canalDto);
		modify.setHabilitado(0l);
		canalesDao.actualizar(modify);
	}

	@AfterMethod
	public void eliminarInstancia() throws DaoException {
		canalesDao.eliminar(canal);
	}


	@AfterClass
	public void afterClass() throws DaoException {
		canal = null;
	}


	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("canales.xml"));
		return dataSet;
	}

}
