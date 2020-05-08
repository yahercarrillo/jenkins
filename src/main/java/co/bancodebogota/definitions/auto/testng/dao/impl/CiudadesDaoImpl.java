package co.bancodebogota.definitions.auto.testng.dao.impl;

import co.bancodebogota.definitions.auto.testng.dao.CiudadesDao;
import co.bancodebogota.definitions.auto.testng.dao.HibernateDaoImpl;
import co.bancodebogota.definitions.auto.testng.models.Ciudades;
import org.springframework.stereotype.Repository;

/**
 * Clase abstracta para la manipulacion de operaciones crud de la entidad
 * Bitacora.
 *
 * @author Yaher Carrillo
 * @Date 27/09/2018
 */
@Repository("ciudadesDao")
public class CiudadesDaoImpl extends HibernateDaoImpl<Integer, Ciudades> implements CiudadesDao
{ }
