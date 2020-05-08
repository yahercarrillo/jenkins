/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package test.impl.dao;


import co.bancodebogota.definitions.auto.testng.dao.EmployeeDao;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeDaoImplTest extends EntityDaoImplTest{

	@Autowired
	EmployeeDao employeeDao;

	@Override
		protected IDataSet getDataSet() throws Exception{
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Employee.xml"));
		return dataSet;
	}
	

	@Test
	public void findById(){
		Assert.assertNotNull(employeeDao.findById(1));
		Assert.assertNull(employeeDao.findById(3));
	}
	
	@Test
	public void deleteEmployeeBySsn(){
		employeeDao.deleteEmployeeBySsn("11111");
		Assert.assertEquals(employeeDao.findAllEmployees().size(), 1);
	}
	
	@Test
	public void deleteEmployeeByInvalidSsn(){
		employeeDao.deleteEmployeeBySsn("23423");
		Assert.assertEquals(employeeDao.findAllEmployees().size(), 2);
	}

	@Test
	public void findAllEmployees(){
		Assert.assertEquals(employeeDao.findAllEmployees().size(), 2);
	}
	
	@Test
	public void findEmployeeBySsn(){
		Assert.assertNotNull(employeeDao.findEmployeeBySsn("11111"));
		Assert.assertNull(employeeDao.findEmployeeBySsn("14545"));
	}
}
