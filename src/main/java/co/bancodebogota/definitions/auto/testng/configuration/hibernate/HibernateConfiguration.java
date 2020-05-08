/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package co.bancodebogota.definitions.auto.testng.configuration.hibernate;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Configuracion a traves de anotaciones de las
 * conexiones de hibernate
 *
 * @author Yaher Carrillo
 * @Date 20/04/2020
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({ "co.bancodebogota.definitions.auto.testng" })
@PropertySource(value = { "classpath:hibernate.properties" })
public class HibernateConfiguration
{

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory()
    {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] {"co.bancodebogota.definitions.auto.testng"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource()
    {
        try
        {
            if (environment.getRequiredProperty("jdbc.servidor.app").equalsIgnoreCase("tomcat")){
                return (DataSource) new JndiTemplate().lookup(environment.getRequiredProperty("jdbc.url.datasource"));
            }else if (environment.getRequiredProperty("jdbc.servidor.app").equalsIgnoreCase("jboss")) {
                return (DataSource) new JndiTemplate().lookup(environment.getRequiredProperty("jdbc.url.datasource.jboss"));
            }

        }
        catch (NamingException e)
        {
            System.out.println("Ha ocurrido un error tratando de conectarse via JDBC");
        }
        return null;
    }

    private Properties hibernateProperties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s)
    {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
}

