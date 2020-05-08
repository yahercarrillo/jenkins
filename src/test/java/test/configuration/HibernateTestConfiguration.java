/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package test.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;
/**
 * Esta clase en una clase de configuracion de hibernate y sus recursos
 * la diferencia es que los metodos a exponer se realizan a traves de un archivo
 * de propiedades y tienen implementaciones especificas
 * para poder trabajar con H2 database
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({ "co.bancodebogota.definitions.auto.testng" })
public class HibernateTestConfiguration
{

    @Autowired
    private Environment environment;

    private String DB = "MEMORY";

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "co.bancodebogota.definitions.auto.testng" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        if (DB.equals("POSTGRES")){
            dataSource.setDriverClassName("org.postgresql.Driver");
            dataSource.setUrl("jdbc:postgresql://172.16.2.15:5432/bdd");
            dataSource.setUsername("usuario_infokiosk");
            dataSource.setPassword("Prueba12$");
        }else if (DB.equals("MYSQL")){
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://172.16.11.38:3306/bdd");
            dataSource.setUsername("root");
            dataSource.setPassword("Info-12345678");
        }else if (DB.equals("SQLSERVER")){
            dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dataSource.setUrl("jdbc:sqlserver://172.16.11.37:1433;databaseName=bdd");
            dataSource.setUsername("sa");
            dataSource.setPassword("INFO-12345678");
        }
        else if (DB.equals("MEMORY")){
            dataSource.setDriverClassName("org.h2.Driver");
            dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
            dataSource.setUsername("sa");
            dataSource.setPassword("");
        }
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        //properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        if (DB.equals("POSTGRES"))
        {
            properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            properties.put("hibernate.show_sql", true);
            properties.put("hibernate.format_sql", true);
        }else if (DB.equals("MYSQL")){
            properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            properties.put("hibernate.show_sql", true);
            properties.put("hibernate.format_sql", true);
        }else if (DB.equals("SQLSERVER")){
            properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
            properties.put("hibernate.show_sql", true);
            properties.put("hibernate.format_sql", true);
        }
        else if (DB.equals("MEMORY")){
            properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
            properties.put("hibernate.hbm2ddl.auto", "create-drop");
        }
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
}
