/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package co.bancodebogota.definitions.auto.testng.service;

import co.bancodebogota.definitions.auto.testng.dto.servicios.CiudadesDTO;
import co.bancodebogota.definitions.auto.testng.util.service.CommonsResponse;
import co.bancodebogota.definitions.auto.testng.util.service.EnumCodigosValidacion;
import co.bancodebogota.definitions.auto.testng.util.service.EstatusGenericos;
import co.bancodebogota.definitions.auto.testng.util.service.ValidacionCrudBase;
import co.bancodebogota.definitions.auto.testng.dao.CiudadesDao;
import co.bancodebogota.definitions.auto.testng.exceptions.DaoException;
import co.bancodebogota.definitions.auto.testng.exceptions.ParameterException;
import co.bancodebogota.definitions.auto.testng.exceptions.ServiceException;
import co.bancodebogota.definitions.auto.testng.models.Ciudades;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de los servicios de Ciudades
 *
 * @author Yaher Carrillo
 * @date 20/04/2020
 */
@Service("ServiciosCiudadesImpl")
@Transactional
public class ServiciosCiudadesImpl implements ServiciosCiudades
{
    /**
     * Logger de esta clase
     */
    final static Logger logger = Logger.getLogger(ServiciosCiudadesImpl.class);

    @Autowired
    private CiudadesDao ciudadesDao;

    @Override
    public CiudadesDTO buscarCiudadPorId(Long id) throws ServiceException, ParameterException
    {
        logger.info("Se ingresa al metodo buscarCiudadPorId " + id);
        CiudadesDTO ciudadesDto = null;

        try
        {
            ValidacionCrudBase.validarObjeto(id, " Id ");
            Ciudades ciudades = ciudadesDao.buscarPorId(id);
            ValidacionCrudBase.validarObjetoRespuesta(ciudades, EnumCodigosValidacion.BUSQUEDA_NO_ENCONTRADA.getCodigo(), EnumCodigosValidacion.BUSQUEDA_NO_ENCONTRADA.getDescripcion());
            ciudadesDto = ciudadesToCiudadesDto(ciudades);
        }
        catch (ParameterException e)
        {
            throw e;
        }

        catch (Exception e)
        {
            String mensaje = "Ocurrio un error al buscarCliente el registro buscarCiudadPorId ";
            logger.error(mensaje, e);
            throw new ServiceException(mensaje, e);
        }
        logger.info("finalizo el buscarCiudadPorId ");
        return ciudadesDto;
    }

    @Override
    public CommonsResponse crearCiudad(CiudadesDTO ciudadesDto) throws ServiceException, ParameterException
    {
        logger.info("Se ingresa al metodo crearCiudad ");
        CommonsResponse commonsResponse = new CommonsResponse();

        try
        {
            ValidacionCrudBase.validarObjeto(ciudadesDto, " CiudadesDTO ");

            if (null == ciudadesDto.getId() || ciudadesDto.getId() != null)
            {
                logger.info("el id de registro a crear no existe, se prosigue a su creacion ");
                Ciudades ciudades = ciudadesDtoToCiudades(ciudadesDto);
                Long id = ciudadesDao.agregar(ciudades);
                ValidacionCrudBase.validarObjetoRespuesta(id, EnumCodigosValidacion.ERROR_AL_CREAR_REGISTRO.getCodigo(), EnumCodigosValidacion.ERROR_AL_CREAR_REGISTRO.getDescripcion());
                logger.info("el Id del registro creado es:" + id.intValue());
                commonsResponse.setEstatus(EstatusGenericos.CIUDAD_CREADO_EXITOSAMENTE.getCode());
                commonsResponse.setResponse(EstatusGenericos.CIUDAD_CREADO_EXITOSAMENTE.getDescription());
            }
            else
            {
                logger.info("Se valida si el codigo de la ciudad existe");
                validarSiExiste(ciudadesDto.getId());
                throw new ServiceException(EstatusGenericos.CIUDAD_YA_EXISTE.getDescription(),EstatusGenericos.CIUDAD_YA_EXISTE.getCode());
            }
        }
        catch (ParameterException e)

        {
            logger.debug("Ocurrio un error de ciudad ", e);
            throw e;
        }
        catch (ServiceException e)
        {
            logger.debug("Ocurrio un error creando la zona ServiceException", e);
            throw e;
        }
        catch (Exception e)
        {
            String mensaje = "Ocurrio un error creando la zona ServiceException";
            logger.debug(mensaje, e);
            throw new ServiceException(mensaje, e);
        }

        logger.info("finalizo el crearCiudad ");

        return commonsResponse;
    }

    @Override
    public CommonsResponse crearCiudadesMasivo(List<CiudadesDTO> listCiudadesDto) throws ServiceException, ParameterException
    {
        logger.info("Se ingresa al metodo crearCiudadesMasivo ");

        CommonsResponse commonsResponse = new CommonsResponse();

        for (CiudadesDTO ciudadesDto : listCiudadesDto)
        {
            try
            {
                crearCiudad(ciudadesDto);

            }
            catch (ServiceException e)
            {

                logger.debug("Error al intentar registrar " + ciudadesDto.toString() + " ");
                throw e;
            }
            catch (ParameterException e)
            {

                logger.debug("Error al intentar registrar " + ciudadesDto.toString() + " ");
                throw e;
            }
            catch (Exception e)
            {
                String mensaje = "Error al intentar registrar " + ciudadesDto.toString() + " ";
                logger.debug(mensaje);
                throw new ServiceException(mensaje, e);
            }
        }

        commonsResponse.setEstatus(EstatusGenericos.CIUDAD_CREADO_EXITOSAMENTE.getCode());
        commonsResponse.setResponse(EstatusGenericos.CIUDAD_CREADO_EXITOSAMENTE.getDescription());

        logger.info("Se ingresa al metodo crearCiudadesMasivo ");

        return commonsResponse;
    }

    @Override
    public List<CiudadesDTO> encontrarCiudadesSegunFiltro(CiudadesDTO ciudadesDto) throws ServiceException, ParameterException
    {
        ArrayList<CiudadesDTO> listCiudadesDto = null;
        try
        {
            logger.info("Dentro del metodo encontrarCiudadesSegunFiltro");
            ValidacionCrudBase.validarObjeto(ciudadesDto, " CiudadesDTO");
            Ciudades ciudades = ciudadesDtoToCiudades(ciudadesDto);
            List<Ciudades> listaCiudades = ciudadesDao.buscar(ciudades);
            listCiudadesDto = listaToListaDto(listaCiudades);

        }
        catch (Exception e)
        {
            String mensaje = "Ocurrio un error metodo encontrarCiudadesSegunFiltro";
            throw new ServiceException(mensaje, e);
        }
        logger.info("finalizo el metodo encontrarCiudadesSegunFiltro");
        return listCiudadesDto;

    }

    @Override
    public CommonsResponse modificarCiudadesSegunFiltro(CiudadesDTO ciudadesDto) throws ServiceException, ParameterException
    {
        logger.info("Se ingresa al metodo modificarCiudadesSegunFiltro ");
        CommonsResponse commonsResponse = new CommonsResponse();

        try
        {
            ValidacionCrudBase.validarObjeto(ciudadesDto, " CiudadesDTO ");
            validarSiExiste(ciudadesDto.getCodCiudad());
            Ciudades ciudades = ciudadesDtoToCiudades(ciudadesDto);
            ciudadesDao.actualizar(ciudades);
            commonsResponse.setEstatus(EstatusGenericos.CIUDAD_ACTUALIZADO_EXITOSAMENTE.getCode());
            commonsResponse.setResponse(EstatusGenericos.CIUDAD_ACTUALIZADO_EXITOSAMENTE.getDescription());

        }
        catch (DaoException e)
        {
            logger.info("error en el metodo modificarCiudadesSegunFiltro");
            throw new ServiceException(e.getMessage(),e.getCode());

        }
        catch (ParameterException e)
        {
            logger.debug("Error de la ciudad", e);
            throw e;
        }
        catch (ServiceException e)
        {
            logger.debug("Ocurrio un error creando la ciudad ServiceException", e);
            throw e;
        }
        catch (Exception e)
        {
            logger.debug("Ocurrio un error creando la ciudad ServiceException", e);

            throw e;
        }

        return commonsResponse;
    }

    @Override
    public List<CiudadesDTO> listarTodasCiudades() throws ServiceException, ParameterException
    {
        ArrayList<CiudadesDTO> listCiudadesDto = null;
        try
        {
            logger.info("Dentro del metodo listarTodasCiudades habilitado");
            Ciudades ciudades = new Ciudades();
            ciudades.setHabilitado(new Long(1));
            List<Ciudades> listaCiudades = ciudadesDao.buscar(ciudades);
            listCiudadesDto = listaToListaDto(listaCiudades);
            logger.info("finalizo el metodo lista todos los Ciudades habilitados");
        }
        catch (Exception e)
        {
            String mensaje = "Ocurrio un error metodo listarTodasCiudades";
            throw new ServiceException(mensaje, e);
        }
        return listCiudadesDto;
    }

    /**
     * metodo encargado de pasar los valores de un objeto ciudad (entidad) a
     * un objeto de tipo CiudadesDTO
     *
     * @param ciudades
     * @return CiudadesDTO
     */

    public static CiudadesDTO ciudadesToCiudadesDto(Ciudades ciudades)
    {

        CiudadesDTO ciudadesDto = new CiudadesDTO();
        ciudadesDto.setCodCiudad((null != ciudades.getCodCiudad()) ? ciudades.getCodCiudad() : null);
        ciudadesDto.setId((null != ciudades.getId()) ? ciudades.getId() : null);
        ciudadesDto.setDescripcion((null != ciudades.getDescripcion()) ? ciudades.getDescripcion() : null);
        ciudadesDto.setHabilitado((null != ciudades.getHabilitado()) ? ciudades.getHabilitado() : null);

        return ciudadesDto;
    }

    /**
     * metodo encargado de pasar los valores de un objeto CiudadesDTO (DTO) a
     * un objeto de tipo Ciudades (Entidad)
     *
     * @param ciudadesDto
     * @return Ciudades
     */
    public static Ciudades ciudadesDtoToCiudades(CiudadesDTO ciudadesDto)
    {

        Ciudades ciudades = new Ciudades();
        ciudades.setCodCiudad((null != ciudadesDto.getCodCiudad()) ? ciudadesDto.getCodCiudad() : null);
        ciudades.setId((null != ciudadesDto.getId()) ? ciudadesDto.getId() : null);
        ciudades.setDescripcion((null != ciudadesDto.getDescripcion()) ? ciudadesDto.getDescripcion() : null);
        ciudades.setHabilitado((null != ciudadesDto.getHabilitado()) ? ciudadesDto.getHabilitado() : null);

        return ciudades;
    }

    /**
     * metodo que se encarga de validar si existe una ciudad por id de ciudad,
     * si existe devulve TRUE, en caso de existir devuelve ServiceException
     *
     * @param id
     * @return boolean
     * @throws ServiceException
     *
     */
    private boolean validarSiExiste(Long id) throws ServiceException
    {
        logger.info("dentro del metodo validarSiExiste, se valida si existe el id ");
        try
        {
            ValidacionCrudBase.validarObjeto(id, " id ");
            Ciudades ciudades = ciudadesDao.buscarPorId(id);
            return ValidacionCrudBase.validarObjetoRespuesta(ciudades, EstatusGenericos.CIUDAD_NO_EXISTE.getCode(), EstatusGenericos.CIUDAD_NO_EXISTE.getDescription());
        }
        catch (Exception e)
        {
            String mensaje = "Ocurrio un error al buscarCliente el registro ";
            logger.error(mensaje, e);
            throw new ServiceException(mensaje, e);
        }

    }

    /**
     * metodo que se encarga de validar si existe una ciudad por codigo ciudad,
     * si existe devulve TRUE, en caso de existir devuelve ServiceException
     *
     * @param codigoCiudad
     * @return boolean
     * @throws ServiceException
     *
     */

    private boolean validarSiExiste(String codigoCiudad) throws ServiceException
    {
        logger.info("dentro del metodo validarSiExiste, se valida si existe el codigo de la ciudad ");
        try
        {
            ValidacionCrudBase.validarObjeto(codigoCiudad, " codigoCiudad ");

            Ciudades ciudades = new Ciudades();
            ciudades.setCodCiudad(codigoCiudad);
            ciudades = ciudadesDao.buscarObjetoUnico(ciudades);
            return ValidacionCrudBase.validarObjetoRespuesta(ciudades, EstatusGenericos.CIUDAD_NO_EXISTE.getCode(), EstatusGenericos.CIUDAD_NO_EXISTE.getDescription());
        }
        catch (ParameterException e)
        {
            String mensaje = "Ocurrio un error al buscarCliente el registro ";
            logger.error(mensaje, e);
            throw new ServiceException(mensaje, e);
        }
        catch (DaoException e)
        {
            String mensaje = "Ocurrio un error al buscarCliente el registro ";
            logger.error(mensaje, e);
            throw new ServiceException(mensaje, e);
        }

    }

    /**
     * metodo que llena un arrayList de CiudadesDTO dada una lista de Ciudades
     *
     * @param listaCiudades
     * @return ArrayList<CiudadesDTO>
     * @throws  ServiceException
     */
    private ArrayList<CiudadesDTO> listaToListaDto(List<Ciudades> listaCiudades) throws ServiceException
    {

        ArrayList<CiudadesDTO> listCiudadesDto = new ArrayList<>();
        if (null == listaCiudades || listaCiudades.isEmpty())
        {
            logger.debug("la lista de Ciudades esta vacia");
            throw new ServiceException(EstatusGenericos.CIUDAD_NO_EXISTE.getDescription(),EstatusGenericos.CIUDAD_NO_EXISTE.getCode());
        }
        else
        {
            for (Ciudades ciudad : listaCiudades)
            {
                CiudadesDTO ciudadesDto = ciudadesToCiudadesDto(ciudad);
                listCiudadesDto.add(ciudadesDto);
            }
        }
        return listCiudadesDto;
    }
}
