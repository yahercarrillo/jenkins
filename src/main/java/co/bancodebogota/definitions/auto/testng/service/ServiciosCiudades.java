/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package co.bancodebogota.definitions.auto.testng.service;


import co.bancodebogota.definitions.auto.testng.dto.servicios.CiudadesDTO;
import co.bancodebogota.definitions.auto.testng.util.service.CommonsResponse;
import co.bancodebogota.definitions.auto.testng.exceptions.ParameterException;
import co.bancodebogota.definitions.auto.testng.exceptions.ServiceException;

import java.util.List;

/**
 * Interfaz para exponer lógica de negocio de las
 * Ciudades
 *
 * @author Yaher Carrillo
 * @date 20/04/2020
 */
public interface ServiciosCiudades
{
    /**
     * metodo que se encarga de buscar un Ciudades por el id
     *
     * @param id
     * @return CiudadesDTO
     * @throws ServiceException,ParameterException
     */
    public CiudadesDTO buscarCiudadPorId(Long id) throws ServiceException, ParameterException;

    /**
     * Crea un registro de la Ciudad
     *
     * @param ciudadesDto
     * @return CommonsResponse
     * @throws ServiceException,ParameterException
     */
    public CommonsResponse crearCiudad(CiudadesDTO ciudadesDto) throws ServiceException, ParameterException;

    /**
     * Se crean ciudades de manera masiva
     *
     * @param listCiudadesDto
     * @return CommonsResponse
     * @throws ServiceException,ParameterException
     */
    public CommonsResponse crearCiudadesMasivo(List<CiudadesDTO> listCiudadesDto) throws ServiceException, ParameterException;

    /**
     * Según el parámetro recibido trae un listado de Ciudadess coicidentes
     *
     * @param ciudadesDto
     * @return List<CiudadesDTO>
     * @throws ServiceException,ParameterException
     */
    public List<CiudadesDTO> encontrarCiudadesSegunFiltro(CiudadesDTO ciudadesDto) throws ServiceException, ParameterException;

    /**
     * Según el parámetro recibido, realiza una modificación de un ciudades, es
     * crucial recibir el identificador, para poder modificar
     *
     * @param ciudadesDto
     * @return CommonsResponse
     * @throws ServiceException,ParameterException
     */
    public CommonsResponse modificarCiudadesSegunFiltro(CiudadesDTO ciudadesDto) throws ServiceException, ParameterException;

    /**
     * Trae un listado de todos las ciudades existentes en la base de datos
     *
     * @return List<CiudadesDTO>
     * @throws ServiceException,ParameterException
     */
    public List<CiudadesDTO> listarTodasCiudades() throws ServiceException, ParameterException;
}


