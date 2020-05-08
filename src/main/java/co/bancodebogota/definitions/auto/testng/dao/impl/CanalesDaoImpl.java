package co.bancodebogota.definitions.auto.testng.dao.impl;

import co.bancodebogota.definitions.auto.testng.dao.CanalesDao;
import co.bancodebogota.definitions.auto.testng.dao.HibernateDaoImpl;
import co.bancodebogota.definitions.auto.testng.models.Canales;
import org.springframework.stereotype.Repository;

/**
 * Clase abstracta para la manipulacion de operaciones crud de la entidad
 * Canales.
 *
 * @author Yaher Carrillo
 * @Date 27/09/2018
 */
@Repository("canalesDao")
public class CanalesDaoImpl extends HibernateDaoImpl<Integer, Canales> implements CanalesDao
{

}
