/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package test.configuration;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import test.impl.dao.EntityDaoImplTest;

/**
 * Clase auxiliar para generar un archivo del que se alimenta la bd virtual que
 * consumen las pruebas unitarias
 * 
 * @author Yaher Carrillo
 *
 */
public class ExportacionBDAXML {

	/**
	 * Las credenciales de conexión dan a una base de datos local, al usar esta
	 * clase crear una instancia de base de datos con algunos registros para poder
	 * generar el xml
	 * 
	 * @param ar@SuppressWarnings("unused")
	 * 
	 */
	public static void main(String[] args) throws Exception {
		// database connection
		@SuppressWarnings({ "rawtypes", "unused" })
		Class driverClass = Class.forName("com.mysql.jdbc.Driver");
		Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://172.16.2.15:3306/bdd", "root",
				"123123123");
		IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

		/*
		 * partial database export QueryDataSet partialDataSet = new
		 * QueryDataSet(connection); partialDataSet.addTable("IK_BITACORA",
		 * "SELECT * FROM IK_BITACORA"); partialDataSet.addTable("IK_MCANALES",
		 * "SELECT * FROM IK_MCANALES"); FlatXmlDataSet.write(partialDataSet, new
		 * FileOutputStream("partial.xml"));
		 */

		// full database export
		IDataSet fullDataSet = connection.createDataSet();
		FlatXmlDataSet.write(fullDataSet, new FileOutputStream(EntityDaoImplTest.ARCHIVO));


		// dependent tables database export: export table X and all tables that
		// have a PK which is a FK on X, in the right order for insertion
		/*
		 * String[] depTableNames =
		 * TablesDependencyHelper.getAllDependentTables(connection, "X"); IDataSet
		 * depDataset = connection.createDataSet(depTableNames);
		 * FlatXmlDataSet.write(depDataset, new FileOutputStream("dependents.xml"));
		 */

	}

}
