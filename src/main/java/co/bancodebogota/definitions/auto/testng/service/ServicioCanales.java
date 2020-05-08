/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package co.bancodebogota.definitions.auto.testng.service;


import co.bancodebogota.definitions.auto.testng.dto.servicios.CanalDTO;
import co.bancodebogota.definitions.auto.testng.exceptions.ParameterException;
import co.bancodebogota.definitions.auto.testng.exceptions.ServiceException;

import java.util.List;

/**
 * Interfaz para exponer lógica de negocio de los
 * Canales
 *
 * @author Yaher Carrillo
 * @date 20/04/2020
 */
public interface ServicioCanales
{
    /**
     * metodo que se encarga de buscar un Canal por el id
     *
     * @param id
     * @return CanalDTO
     * @throws ServiceException,ParameterException
     */
    CanalDTO buscarCanalPorId(Long id) throws ParameterException;

    /**
     * Crea un registro del Canal
     *
     * @param canalDto
     * @return CommonsResponse
     * @throws ServiceException,ParameterException
     */
    void crearCanal(CanalDTO canalDto) throws ServiceException, ParameterException;

    /**
     * Se crean Canales de manera masiva
     *
     * @param listCanalesDTO
     * @return CommonsResponse
     * @throws ServiceException,ParameterException
     */
    void crearCanalMasivo(List<CanalDTO> listCanalesDTO) throws ServiceException, ParameterException;

    /**
     * Según el parámetro recibido trae un listado de Canales coicidentes
     *
     * @param canalDto
     * @return List<CanalDTO>
     * @throws ServiceException,ParameterException
     */
     List<CanalDTO> encontrarCanalesSegunFiltro(CanalDTO canalDto) throws ServiceException, ParameterException;

    /**
     * Según el parámetro recibido, realiza una modificación de un Canales, es
     * crucial recibir el identificador, para poder modificar
     *
     * @param canalDto
     * @return CommonsResponse
     * @throws ServiceException,ParameterException
     */
    void modificarCanalesSegunFiltro(CanalDTO canalDto) throws ServiceException, ParameterException;

    /**
     * Eliminar el registro seleccionado
     * @param canalDto registro a eliminar
     * @return
     * @throws ServiceException
     * @throws ParameterException
     */
     void eliminarCanales(CanalDTO canalDto) throws ServiceException, ParameterException;

    /**
     * Trae un listado de todos las Canales habilitados existentes en la base de datos
     *
     * @return List<CanalDTO>
     * @throws ServiceException,ParameterException
     */
     List<CanalDTO> listarTodasCanales() throws ServiceException, ParameterException;
}
