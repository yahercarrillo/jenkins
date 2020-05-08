/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package test.impl.dao;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.configuration.HibernateTestConfiguration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Clase base de la que extienden todas las clases de test, tiene los métodos
 * para abrir y cerrar una conexión a una base de datos en memoria
 *
 * @author Yaher Carrillo
 * @author rlopez
 * @Date 20/04/2020
 * @Since 28/04/2020
 */
@ContextConfiguration(classes = { HibernateTestConfiguration.class })
public abstract class EntityDaoImplTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    DataSource dataSource;


    /* Nombre del archivo que contiene la estructura de la bd virtual */
    public static final String ARCHIVO = "full.xml";

    @BeforeMethod
    public void setUp() throws Exception {
        IDatabaseConnection dbConn = new DatabaseDataSourceConnection(
                dataSource);
        DatabaseOperation.CLEAN_INSERT.execute(dbConn, getDataSet());
    }

    protected abstract IDataSet getDataSet() throws Exception;

}
